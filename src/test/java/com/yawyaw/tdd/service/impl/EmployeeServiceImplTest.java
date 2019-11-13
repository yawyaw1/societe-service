package com.yawyaw.tdd.service.impl;

import com.yawyaw.tdd.dao.EmployeeRepository;
import com.yawyaw.tdd.entities.Employee;
import com.yawyaw.tdd.service.EmployeeService;
import javafx.beans.binding.When;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

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

        Optional<Employee> employeeById = employeeService.findEmployeeById(1L);

        Assert.assertEquals("firstname1", employeeById.get().getFirstname());

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
}