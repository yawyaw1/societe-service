package com.yawyaw.tdd.dao;

import com.yawyaw.tdd.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {

}
