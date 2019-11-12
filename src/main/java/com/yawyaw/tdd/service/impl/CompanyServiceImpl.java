package com.yawyaw.tdd.service.impl;

import com.yawyaw.tdd.dao.CompanyRepository;
import com.yawyaw.tdd.entities.Company;
import com.yawyaw.tdd.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Optional<Company> create(Company company) {
        if (company != null) {
            companyRepository.save(company);
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
        if(id != null){
            return companyRepository.findById(id);
        }
        return Optional.empty();
    }
}
