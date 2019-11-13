package com.yawyaw.tdd.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.yawyaw.tdd.dao.CompanyRepository;
import com.yawyaw.tdd.entities.Company;
import com.yawyaw.tdd.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final static Logger LOGGER = LogManager.getLogger(CompanyServiceImpl.class);

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Optional<Company> createCompany(Company company) {
        if (company != null) {
            companyRepository.save(company);
            LOGGER.info("saving company to the database");
            return Optional.of(company);
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        if (id != null) {
            companyRepository.deleteById(id);
        }
    }

    @Override
    public Optional<Company> findCompanyById(Long id) {
        if (id != null) {
            return companyRepository.findById(id);
        }
        return Optional.empty();
    }
}
