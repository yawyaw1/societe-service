package com.consulting.service.service;


import com.consulting.service.entities.Company;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {

    /**
     *
     * @param company
     * @return
     */
    Company createCompany(Company company);

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
    Company findCompanyById(Long id);
}
