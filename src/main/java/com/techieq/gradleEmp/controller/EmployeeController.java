package com.techieq.gradleEmp;

import java.net.URI;
import java.lang.String;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techieq.gradleEmp.Employee;
import com.techieq.gradleEmp.Employees;
import com.techieq.gradleEmp.db.EmployeeDB;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController
{
    @Autowired
    private EmployeeDB employeedb;


    @GetMapping(path="/", produces = "application/json")
    public Employees getEmployees()
    {
        return employeedb.getAllEmployees();
    }

    @PostMapping(path= "/create", consumes = "application/json", produces = "application/json")
    public String addEmployee(
            @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
            @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
            @RequestBody Employee employee)
            throws Exception
    {
        //Generate resource id
        Integer id = employeedb.getAllEmployees().getEmployeeList().size() + 1;
        employee.setId(id);

        //add resource
        employeedb.addEmployee(employee);

        return "Resource Created";
    }
}