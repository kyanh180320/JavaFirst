package com.example.SpringTut.controller;

import com.example.SpringTut.model.Employee;
import com.example.SpringTut.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll(){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee create(@RequestBody Employee emp){
        return employeeService.save(emp);
    }
}
