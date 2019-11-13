package com.societe.service.service;


import com.societe.service.entities.Company;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
