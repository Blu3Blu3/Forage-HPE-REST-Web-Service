package com.example.restservice;

// Record classes in Java have getters and setters built in for all vars in the header.
public record Employee(int employee_id, String first_name, String last_name, String email, String title) { }
