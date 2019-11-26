package com.consulting.service.service.impl;

import com.consulting.service.dao.EmployeeRepository;
import com.consulting.service.service.EmployeeService;
import com.consulting.service.entities.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Mock
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @Before
    public void init() {
        employee = new Employee();
        employee.setId(1L);
        employee.setFirstname("firstname1");
    }

    @Test
    public void should_create_a_new_employee_test() {
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);

        Employee savedEmployee = employeeService.create(employee);

        Assert.assertEquals("firstname1", savedEmployee.getFirstname());

        Mockito.verify(employeeRepository, Mockito.times(1)).save(employee);
    }

    @Test
    public void should_delete_employee_by_id_test() {
        Mockito.doNothing().when(employeeRepository).deleteById(1L);
        employeeService.deleteById(1L);
        Mockito.verify(employeeRepository, Mockito.times(1)).deleteById(1L);

    }

    @Test
    public void should_return_employee_by_id_test() {
        Optional<Employee> returnedEmployee = Optional.of(employee);
        Mockito.when(employeeRepository.findById(ArgumentMatchers.anyLong())).thenReturn(returnedEmployee);

        Employee employeeById = employeeService.findEmployeeById(1L);

        Assert.assertEquals("firstname1", employeeById.getFirstname());

        Mockito.verify(employeeRepository, Mockito.times(1)).findById(ArgumentMatchers.anyLong());

    }

    @Test
    public void should_retrieve_a_list_of_employees_test() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);

        Mockito.when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> employeeList = employeeService.retrieveEmployees();

        Assert.assertEquals(1, employeeList.size());

        Mockito.verify(employeeRepository, Mockito.times(1)).findAll();

    }

    @Test
    public void should_return_employee_between_two_dates_test() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusYears(1);


        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        Mockito.when(employeeRepository.findEmployeesBetweenDates(ArgumentMatchers.any(LocalDate.class), ArgumentMatchers.any(LocalDate.class))).thenReturn(employees);

        List<Employee> employeesBetweenDates = employeeService.retrieveEmployeesBetweenTwoDates(startDate, endDate);


        Assert.assertEquals(1, employeesBetweenDates.size());

        Mockito.verify(employeeRepository, Mockito.times(1)).findEmployeesBetweenDates(ArgumentMatchers.any(LocalDate.class), ArgumentMatchers.any(LocalDate.class));


    }


}