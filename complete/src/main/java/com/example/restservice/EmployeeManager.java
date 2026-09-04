package com.example.restservice;

// Not quite sure why this is necessary if the Employees class already takes care of the methods...
// Isn't this just an added layer for something that could already be implemented in EmployeeController?
public class EmployeeManager {
    private Employees employees;
    
    public EmployeeManager() {
        this.employees = new Employees();
        this.employees.add_employee(new Employee(1, "Alice", "Carroll", "acarroll@hpe.org", "Ms"));
        this.employees.add_employee(new Employee(2, "Bob", "Dabilder", "bdabilder@hpe.org", "Mr"));
        this.employees.add_employee(new Employee(3, "Carmen", "Esperanza", "cesperanza@hpe.org", "Ms"));
        this.employees.add_employee(new Employee(4, "Daniel", "Ferrero", "dferrero@hpe.org", "Mr"));
        this.employees.add_employee(new Employee(5, "Eve", "Garamond", "egaramond@hpe.org", "Mx"));
        this.employees.add_employee(new Employee(6, "Fernax", "Halcyon", "fhalcyon@hpe.org", "The Immutable"));
        this.employees.add_employee(new Employee(7, "Gwendolyn", "Ivory", "givory@hpe.org", "Ms"));
        this.employees.add_employee(new Employee(8, "Hye", "Jee", "hjee@hpe.org", "Mr"));
        this.employees.add_employee(new Employee(9, "Isabelle", "Kurt", "ikurt@hpe.org", "Ms"));
        this.employees.add_employee(new Employee(10, "Jordan", "Leduc", "jleduc@hpe.org", "Mr"));
        this.employees.add_employee(new Employee(11, "Katarina", "Miroslaw", "kmiroslaw@hpe.org", "Ms"));
        this.employees.add_employee(new Employee(12, "Lanie", "Nouveau", "lnouveau@hpe.org", "Mx"));
    };

    //'{"employee_id": 13, "first_name": "Max", "last_name": "Ocean", "email": "mocean@hpe.org", "title": "Mx"}'

    public Employees get_employees() { return this.employees; }
}
