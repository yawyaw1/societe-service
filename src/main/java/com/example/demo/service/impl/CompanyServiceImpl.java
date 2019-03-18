package com.example.demo.service.impl;

import com.example.demo.dao.CompanyRepository;
import com.example.demo.entities.Company;
import com.example.demo.service.CompanyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final static Logger LOGGER = LogManager.getLogger(CompanyServiceImpl.class);

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Optional<Company> create(Company company) {
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
