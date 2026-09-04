package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;

import java.net.URI;

@RestController
public class EmployeeController {
    // private Employees employees = new Employees();
    private EmployeeManager manager = new EmployeeManager();
    
    // You can't map two methods to the same URI; that'll cause ambiguous mapping, and Spring won't load that page.
    // TODO: Double check how this is done!
    @GetMapping("/emp")
    public Employee get_employee(@RequestParam(defaultValue = "-1") int id) {
        int new_id = (int) id;
        return this.manager.get_employees().get_employee(new_id);
    }

    @GetMapping("/employees")
    public Employee[] get_all_employees() {
        return this.manager.get_employees().get_all_employees();
    }

    @PutMapping("/employees")
    public ResponseEntity<Object> add_employee(@RequestBody Employee employee) {
        this.manager.get_employees().add_employee(employee);
        
        String path = String.format("/%d", this.manager.get_employees().get_current_id());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(path).buildAndExpand(employee.employee_id()).toUri();
        System.out.println(location);

        return ResponseEntity.created(location).build();
    }
}
