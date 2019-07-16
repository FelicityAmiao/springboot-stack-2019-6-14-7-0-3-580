package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeesController {

    @GetMapping
    public List<Employee> getAllEmployees() {
        return Employee.createTestEmployees();
    }

    @PostMapping
    public List<Employee> addEmployee(@RequestBody Employee employee) {
        List<Employee> acceptEmployees = new ArrayList<>();
        acceptEmployees.add(employee);
        return acceptEmployees;
    }
}
