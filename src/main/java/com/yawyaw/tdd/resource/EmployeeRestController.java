package com.yawyaw.tdd.resource;


import com.yawyaw.tdd.entities.Employee;
import com.yawyaw.tdd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> retreiveEmployees() {
        List<Employee> employees = employeeService.retrieveEmployees();

        if (!CollectionUtils.isEmpty(employees)) {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
        return new ResponseEntity<>(employees, HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        if (employee != null) {
            Employee createdEmployee = employeeService.create(employee);
            return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
