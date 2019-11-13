package com.yawyaw.tdd.service.impl;


import com.yawyaw.tdd.dao.CompanyRepository;
import com.yawyaw.tdd.entities.Company;
import com.yawyaw.tdd.service.CompanyService;
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
public class CompanyServiceImplTest {

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CompanyService companyService = new CompanyServiceImpl();

    private Company company;


    @Before
    public void init() {
        company = new Company();
        company.setId(1L);
        company.setDescription("company1");
    }

    @Test
    public void should_create_new_company_service_test() {
        when(companyRepository.save(company)).thenReturn(company);

        Optional<Company> createdCompany = companyService.createCompany(company);

        assertNotNull(createdCompany);
        assertEquals("company1", createdCompany.get().getDescription());

        verify(companyRepository, times(1)).save(company);
    }

    @Test
    public void should_delete_company_by_id_service_test() {
        doNothing().when(companyRepository).deleteById(1L);
        companyService.deleteById(1L);
    }

    @Test
    public void should_find_company_by_id_service_test() {
        Optional<Company> returnedCompany = Optional.of(company);

        when(companyRepository.findById(anyLong())).thenReturn(returnedCompany);

        Optional<Company> companyToFind = companyService.findCompanyById(company.getId());

        assertNotNull(companyToFind);
        assertEquals(1L, companyToFind.get().getId(), 0);
        assertEquals("company1", companyToFind.get().getDescription());

        verify(companyRepository, times(1)).findById(anyLong());

    }

}
