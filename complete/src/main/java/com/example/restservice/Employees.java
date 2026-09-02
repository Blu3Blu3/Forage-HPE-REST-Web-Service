package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class Employees {
    // Keep in mind Java doesn't have dynamic arrays!
    // Use ArrayLists if you want something dynamic.
    private Employee[] employees = [];
    private int current_id = 1;
    
    // Reconsider if this constructor should be public.
    public Employees() {
        this.employees = [];
        this.current_id = 1;
    }

    private Employees(Employee[] employees, int current_id) {
        this.employees = employees;
        this.current_id = current_id;
    }

    /**
     * Returns an array of all employees.
     */
    public get_all_employees() { return this.employees; }
     
    /**
     * Returns an Employee object with the target ID, if it exists in the database.
     */
    public get_employee(int id) {
        for(int e = 0; e < this.employees.length; e++) {
            if this.employees[e].employee_id == id {
                return this.employees[e];
            }
        }
        System.out.println(String.format("ERROR: Employee with id %d does not exist.", id))
        return -1;
    }
    
    /**
     * Returns the next employee ID, i.e., the current (maximum) employee ID + 1.
     */
    public increment_and_get_current_id() {
        this.current_id += 1;
        return this.current_id;
    }

    /**
     * Swaps out the current database of employees with a given one.
     */
    public update_all_employees(Employee[] new_employees) { this.employees = new_employees; }

    /**
     * Updates an Employee with a target ID with new values.
     */
    public update_employee(Employee new_employee, int id) {
        for(int e = 0; e < this.employees.length; e++) {
            if this.employees[e].employee_id == id {
                this.employees[e] = new_employee;
                // The ID should be kept.
                this.employees[e].employee_id = id;
            }
        }
        System.out.println(String.format("ERROR: Employee with id %d does not exist.", id))
        return -1;
    }

    /**
     * Adds an employee with given values (or no values if none are given) and the next ID.
     */
    public add_employee(Employee new_employee = Employee()) {
        new_employee.employee_id = this.increment_and_get_current_id();
        this.employees = {...this.employees, new_employee};
    }

    /**
     * Deletes an employee with a given id if they exist in the database.
     */
    public delete_employee(int id) {
        new_employees = new Employee[this.employees.length - 1];
        ind = 0
        for(int e = 0; e < this.employees.length; e++) {
            if this.employees[e].employee_id != id {
                new_employees[ind] = this.employees[e];
                ind += 1;
            }
        }
        // If there is no employee with the target ID, nothing happens
        // because the new copy of the DB is identical to the current DB.
        this.employees = new_employees
    }
}