package com.consulting.service.dao;


import com.consulting.service.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * @param startDate
     * @param endDate
     * @return employees between two given dates
     */

    @Query("select e from Employee e, Contract c where e.id = c.employee and c.endDate between :startDate and :endDate")
    List<Employee> findEmployeesBetweenDates(@Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate);
}
