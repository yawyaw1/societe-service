package com.societe.service.service.impl;

import com.societe.service.entities.Employee;
import com.societe.service.enums.ErrorMessage;
import com.societe.service.exception.ValidationException;
import com.societe.service.service.EmployeeService;
import com.societe.service.dao.EmployeeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final static Logger LOGGER = LogManager.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        if (employee != null) {
            return employeeRepository.save(employee);
        }
        throw new ValidationException(ErrorMessage.LOG002_MSG.getName() + employee);
    }

    @Override
    public void deleteById(Long id) {
        if (id != null) {
            employeeRepository.deleteById(id);
        } else {
            throw new ValidationException(ErrorMessage.LOG002_MSG.getName() + id);
        }

    }

    @Override
    public Employee findEmployeeById(Long id) {
        if (id != null) {
            return employeeRepository.findById(id).orElseThrow(() -> new ValidationException(ErrorMessage.LOG002_MSG.getName() + id));
        }
        return null;
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
