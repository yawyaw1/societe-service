package com.example.demo.dao;


import com.example.demo.SocieteServiceApplication;
import com.example.demo.entities.Company;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SocieteServiceApplication.class)
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    private List<Company> companies;

    @Before
    public void init() {
        companies = new ArrayList<>(3);
        Company company1 = new Company();
        company1.setDescription("company1");

        Company company2 = new Company();
        company2.setDescription("company2");

        Company company3 = new Company();
        company3.setDescription("company3");

        companies.add(company1);
        companies.add(company2);
        companies.add(company3);
    }

    @Test
    public void should_create_new_company_test() {
        Company company = new Company();
        Company createdCompany = companyRepository.save(company);
        assertNotNull(createdCompany);
        assertEquals(2L, createdCompany.getId(), 0);

    }

    @Test
    public void should_retrieve_company_by_id_test() {
        Company company = new Company();
        company.setDescription("company1");

        Company createdCompany = companyRepository.save(company);
        assertNotNull(createdCompany);

        Company fetchedCompany = companyRepository.findById(2l).get();
        assertNotNull(fetchedCompany);
        assertEquals(2L, fetchedCompany.getId(), 0);
        assertEquals("company1", fetchedCompany.getDescription());

    }

    @Test
    public void should_fetch_list_of_company_test() {
        companyRepository.saveAll(companies);

        List<Company> companyList = companyRepository.findAll();
        assertEquals(3, companyList.stream().count());
    }

}
