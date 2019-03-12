package com.example.demo.service;


import com.example.demo.entities.Company;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CompanyService {

    /**
     *
     * @param company
     * @return
     */
    Optional<Company> create(Company company);

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
    Optional<Company> findCompanyById(Long id);
}
