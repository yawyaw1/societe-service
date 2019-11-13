package com.yawyaw.tdd.service;

import com.yawyaw.tdd.entities.Employee;

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
    Employee findEmployeeById(Long id);

    /**
     *
     * @return
     */
    List<Employee> retrieveEmployees();
}
