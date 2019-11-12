package com.example.demo.service;

import com.example.demo.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    /**
     *
     * @param employee
     * @return
     */
    Employee create(Employee employee);

    /**
     *
     * @param id
     */
    void deleteById(Long id);

    /**
     *
     * @param id
     * @return
     */
    Optional<Employee> findEmployeeById(Long id);

    /**
     *
     * @return
     */
    List<Employee> retrieveEmployees();
}
