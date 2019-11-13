package com.yawyaw.tdd.service.impl;

import com.yawyaw.tdd.dao.EmployeeRepository;
import com.yawyaw.tdd.entities.Employee;
import com.yawyaw.tdd.exception.EmployeeInvalidException;
import com.yawyaw.tdd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        if (employee != null) {
            return employeeRepository.save(employee);
        }
        throw new EmployeeInvalidException("Invalid input employee");
    }

    @Override
    public void deleteById(Long id) {
        if (id != null) {
            employeeRepository.deleteById(id);
        } else {
            throw new EmployeeInvalidException("Invalid input id");
        }

    }

    @Override
    public Optional<Employee> findEmployeeById(Long id) {
        if (id != null) {
            return employeeRepository.findById(id);
        } else {
            throw new EmployeeInvalidException("Invalid input id");
        }
    }

    @Override
    public List<Employee> retrieveEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        if (!CollectionUtils.isEmpty(employeeList)) {
            return employeeList;
        } else {
            return null;
        }
    }
}
