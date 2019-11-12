package com.yawyaw.tdd.dao;

import com.yawyaw.tdd.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
