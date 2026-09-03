package com.example.restservice;

public class Employees {
    // Keep in mind Java doesn't have dynamic arrays!
    // Use ArrayLists if you want something dynamic.
    private Employee[] employees;
    private int current_id = 1;
    
    // Reconsider if this constructor should be public.
    public Employees() {
        this.employees = new Employee[1];
        this.current_id = 1;
    }

    private Employees(Employee[] employees, int current_id) {
        this.employees = employees;
        this.current_id = current_id;
    }

    /**
     * Returns an array of all employees.
     */
    public Employee[] get_all_employees() { return this.employees; }
     
    /**
     * Returns an Employee object with the target ID, if it exists in the database.
     */
    public Employee get_employee(int id) {
        for (int e = 0; e < this.employees.length; e++) {
            if (this.employees[e].employee_id() == id) {
                return this.employees[e];
            }
        }
        System.out.println(String.format("ERROR: Employee with id %d does not exist.", id));
        return null;
    }
    
    /**
     * Returns the next employee ID, i.e., the current (maximum) employee ID + 1.
     */
    public int get_current_id() {
        return this.current_id;
    }

    /**
     * Swaps out the current database of employees with a given one.
     */
    public void update_all_employees(Employee[] new_employees) { this.employees = new_employees; }

    /**
     * Updates an Employee with a target ID with new values.
     */
    public void update_employee(Employee new_employee, int id) {
        for (int e = 0; e < this.employees.length; e++) {
            if (this.employees[e].employee_id() == id) {
                // The ID should be kept.
                // Apparently Java records are immutable! They have to be replaced fully to be updated in the DB.
                Employee copy_employee = new Employee(id, new_employee.first_name(), new_employee.last_name(), new_employee.email(), new_employee.title());
                this.employees[e] = new_employee;
            }
        }
        System.out.println(String.format("ERROR: Employee with id %d does not exist.", id));
    }

    /**
     * Adds an employee with given values (or no values if none are given) and the next ID.
     */
    public void add_employee(Employee new_employee) {
        Employee copy_employee = new Employee(this.current_id, new_employee.first_name(), new_employee.last_name(), new_employee.email(), new_employee.title());
        this.current_id += 1;
        Employee[] temp = new Employee[this.employees.length + 1];
        for (int e = 0; e <= this.employees.length; e++) {
            if (e < this.employees.length) {
                temp[e] = this.employees[e];
            }
            else {
                temp[e] = copy_employee;
            }
        }
        this.update_all_employees(temp);
    }

    /**
     * Deletes an employee with a given id if they exist in the database.
     */
    public void delete_employee(int id) {
        Employee[] new_employees = new Employee[this.employees.length - 1];
        int ind = 0;
        for (int e = 0; e < this.employees.length; e++) {
            if (this.employees[e].employee_id() != id) {
                new_employees[ind] = this.employees[e];
                ind += 1;
            }
        }
        // If there is no employee with the target ID, nothing happens
        // because the new copy of the DB is identical to the current DB.
        this.employees = new_employees;
    }
}