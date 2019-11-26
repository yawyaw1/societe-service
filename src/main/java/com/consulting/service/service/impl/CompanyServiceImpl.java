package com.consulting.service.service.impl;

import com.consulting.service.exception.ValidationException;
import com.consulting.service.service.CompanyService;
import com.consulting.service.exception.ErrorMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.consulting.service.dao.CompanyRepository;
import com.consulting.service.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final static Logger LOGGER = LogManager.getLogger(CompanyServiceImpl.class);

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company createCompany(Company company) {
        if (company != null) {
            LOGGER.info("saving company to the database");
            return companyRepository.save(company);
        }
        throw new ValidationException(ErrorMessage.LOG001_MSG.getName());
    }

    @Override
    public void deleteById(Long id) {
        if (id != null) {
            companyRepository.deleteById(id);
        } else {
            throw new ValidationException(ErrorMessage.LOG001_MSG.getName());
        }
    }

    @Override
    public Company findCompanyById(Long id) {
        if (id != null) {
            return companyRepository.findById(id).orElseThrow(() -> new ValidationException(ErrorMessage.LOG001_MSG.getName()));
        }
        return null;
    }
}
