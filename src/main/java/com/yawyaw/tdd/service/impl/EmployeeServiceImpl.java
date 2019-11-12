package com.example.demo.service.impl;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entities.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        if(employee !=null){
            employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<Employee> findEmployeeById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Employee> retrieveEmployees() {
        return employeeRepository.findAll();
    }
}
