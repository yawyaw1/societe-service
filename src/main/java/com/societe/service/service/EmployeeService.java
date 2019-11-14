package com.societe.service.service;

import com.societe.service.entities.Employee;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {

    /**
     * @param employee
     * @return
     */
    Employee create(Employee employee);

    /**
     * @param id
     */
    void deleteById(Long id);

    /**
     * @param id
     * @return
     */
    Employee findEmployeeById(Long id);

    /**
     * @return
     */
    List<Employee> retrieveEmployees();

    /**
     *
     * @param startDate
     * @param endDate
     * @return
     */
    List<Employee> retrieveEmployeesBetweenTwoDates(LocalDate startDate, LocalDate endDate);
}
