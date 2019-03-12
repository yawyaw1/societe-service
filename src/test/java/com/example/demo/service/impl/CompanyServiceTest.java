package com.example.demo.service.impl;


import com.example.demo.dao.CompanyRepository;
import com.example.demo.entities.Company;
import com.example.demo.service.CompanyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceTest {

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CompanyService companyService = new CompanyServiceImpl();


    @Before
    public void init() {

    }

    @Test
    public void should_create_new_company_service_test() {
        Company company= addAndSaveCompany();

        Optional<Company> createdCompany = companyService.create(company);
        assertNotNull(createdCompany);
        assertEquals("company1", createdCompany.get().getDescription());

        verify(companyRepository, times(1)).save(company);
    }

    @Test
    public void should_delete_company_by_id_service_test() {
        addAndSaveCompany();

        doNothing().when(companyRepository).deleteById(1L);
        companyService.deleteById(1L);
    }

    @Test
    public void should_find_company_by_id_service_test() {
        Company company= addAndSaveCompany();

        when(companyRepository.findById(company.getId())).thenReturn(Optional.of(company));

        Optional<Company> companyToFind=companyService.findCompanyById(company.getId());
        assertNotNull(companyToFind);
        assertEquals(1L,companyToFind.get().getId(),0);
        assertEquals("company1",companyToFind.get().getDescription());
    }

    private Company addAndSaveCompany() {
        Company company = new Company();
        company.setId(1L);
        company.setDescription("company1");
        when(companyRepository.save(company)).thenReturn(company);

        return company;
    }
}
