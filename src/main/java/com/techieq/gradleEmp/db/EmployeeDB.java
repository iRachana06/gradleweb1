package com.techieq.gradleEmp.db;

import org.springframework.stereotype.Repository;

import com.techieq.gradleEmp.Employee;
import com.techieq.gradleEmp.Employees;

@Repository
public class EmployeeDB {
    private static Employees list = new Employees();

    static {
        list.getEmployeeList().add(new Employee(1, "Aman", "Gupta", "techieq@gmail.com"));
        list.getEmployeeList().add(new Employee(2, "Arav", "Sinha", "techieq@gmail.com"));
        list.getEmployeeList().add(new Employee(3, "Ankit", "Singh", "techieq@gmail.com"));
    }

    public Employees getAllEmployees() {
        return list;
    }

    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }
}