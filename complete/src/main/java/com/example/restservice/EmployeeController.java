package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.net.URI;

@RestController
public class EmployeeController {
    private Employees employees = new Employees();
    
    @GetMapping("/employees")
    public Employee get_employee(@RequestParam(defaultValue = "-1") int id) {
        return this.employees.get_employee(id);
    }

    @GetMapping("/employees")
    public Employee[] get_all_employees() {
        return this.employees.get_all_employees();
    }

    @PutMapping("/employees")
    public ResponseEntity<Object> add_employee(@RequestBody Employee employee) {
        this.employees.add_employee(employee);
        
        String path = String.format("/%d", this.employees.get_current_id());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(path).buildAndExpand(employee.employee_id()).toUri();
        System.out.println(location);
        
        return ResponseEntity.created(location).build();
    }
}
