package com.example.SpringTut.service;

import com.example.SpringTut.model.Employee;
import com.example.SpringTut.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository _employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository){
        this._employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return _employeeRepository.findAll();
    }

    public Employee save(Employee emp){
        return _employeeRepository.save(emp);
    }
}
