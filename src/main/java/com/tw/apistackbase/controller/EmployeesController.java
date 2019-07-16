package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import org.springframework.http.ResponseEntity;
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

    @PutMapping
    public List<Employee> modifyEmployee(@RequestBody Employee employee) {
        List<Employee> returnEmployees = Employee.createTestEmployees();
        for (Employee returnEmployee : returnEmployees) {
            if(returnEmployee.getId() == employee.getId()) {
                returnEmployees.remove(returnEmployee);
                returnEmployees.add(employee);
            }
        }
        return returnEmployees;
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEmployee(@RequestParam int employeeId) {
        List<Employee> employees = Employee.createTestEmployees();
        for (Employee employee : employees) {
            if(employee.getId() == employeeId) {
                employees.remove(employee);
                return ResponseEntity.ok("Delete Successfully");
            }
        }
        return ResponseEntity.ok("Please send a valid employee id");
    }
}
