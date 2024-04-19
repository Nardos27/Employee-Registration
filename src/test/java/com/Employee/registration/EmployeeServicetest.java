package com.Employee.registration;

import com.Employee.registration.Dto.EmployeeRequestDto;
import com.Employee.registration.Dto.EmployeeResponseDto;
import com.Employee.registration.Model.Address;
import com.Employee.registration.Model.Employee;
import com.Employee.registration.Repository.AddressRepository;
import com.Employee.registration.Repository.EmployeeRepository;
import com.Employee.registration.Service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class EmployeeServicetest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddNewEmployee() {
        EmployeeRequestDto requestDto = new EmployeeRequestDto();
        Employee employee = new Employee();
        employee.setFullName("John Doe");
        employee.setEmail("john.doe@example.com");
        employee.setPhoneNumber("1234567890");
        employee.setAge(30);

        Address address = new Address();
        address.setCity("AddisAbaba");
        address.setCountry("ethiopia");
        employee.setAddress(address);


        when(addressRepository.save(any(Address.class))).thenReturn(address);
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        employeeService.addNewEmployee(requestDto);

        // Verify that addressRepository.save() and employeeRepository.save() were called
        verify(addressRepository, times(1)).save(any(Address.class));
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

    @Test
    public void testUpdateEmployeeByFullName() {
        EmployeeRequestDto requestDto = new EmployeeRequestDto();
        requestDto.setFullName("John Doe"); // Set the full name of the employee to be updated
        requestDto.setEmail("john.doe@example.com"); // Set the updated email
        requestDto.setPhoneNumber("1234567890"); // Set the updated phone number
        requestDto.setAge(30); // Set the updated age

        Address address = new Address();
        address.setCity("AddisAbaba"); // Set the updated city
        address.setCountry("ethiopia"); // Set the updated country

        // Stub the behavior of findByFullName to return an existing employee
        when(employeeRepository.findByFullName(anyString())).thenReturn(Collections.singletonList(new Employee()));

        List<Employee> updatedEmployees = employeeService.updateEmployeeByFullName(requestDto);

        // Verify that employeeRepository.findByFullName was called once
        verify(employeeRepository, times(1)).findByFullName(anyString());

        // Verify that employeeRepository.save was called once
        verify(employeeRepository, times(1)).save(any(Employee.class));

        // Assert the size of updatedEmployees list
        assertEquals(1, updatedEmployees.size());
    }

    @Test
    public void testFindAllEmployees() {
        // Mock data for employees
        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setFullName("John Doe");
        employee1.setEmail("john.doe@example.com");
        employee1.setPhoneNumber("1234567890");
        employee1.setAge(30);

        Address address1 = new Address();
        address1.setId(1L);
        address1.setCity("New York");
        address1.setCountry("USA");
        employee1.setAddress(address1);

        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setFullName("Jane Smith");
        employee2.setEmail("jane.smith@example.com");
        employee2.setPhoneNumber("9876543210");
        employee2.setAge(35);

        Address address2 = new Address();
        address2.setId(2L);
        address2.setCity("Los Angeles");
        address2.setCountry("USA");
        employee2.setAddress(address2);

        // Mock employee repository behavior
        List<Employee> mockEmployees = Arrays.asList(employee1, employee2);
        Mockito.when(employeeRepository.findAll()).thenReturn(mockEmployees);

        // Call the service method
        List<EmployeeResponseDto> result = employeeService.findAllEmployees();


        // Assert the result
        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getFullName());
        assertEquals("john.doe@example.com", result.get(0).getEmail());
        assertEquals("1234567890", result.get(0).getPhoneNumber());
        assertEquals(30, result.get(0).getAge());
        assertEquals(1L, result.get(0).getAddressId());
        assertEquals("New York", result.get(0).getCity());
        assertEquals("USA", result.get(0).getCountry());

        assertEquals("Jane Smith", result.get(1).getFullName());
        assertEquals("jane.smith@example.com", result.get(1).getEmail());
        assertEquals("9876543210", result.get(1).getPhoneNumber());
        assertEquals(35, result.get(1).getAge());
        assertEquals(2L, result.get(1).getAddressId());
        assertEquals("Los Angeles", result.get(1).getCity());
        assertEquals("USA", result.get(1).getCountry());
    }


    @Test
    public void testFindAllEmployeesByFullName() {
        String fullName = "John Doe";

        // Mock data for employeeRepository.findAllEmployeesByFullName()
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFullName("John Doe");
        employee.setEmail("john.doe@example.com");
        employee.setPhoneNumber("1234567890");
        employee.setAge(30);
        Address address = new Address();
        address.setId(1L);
        address.setCity("New York");
        address.setCountry("USA");
        employee.setAddress(address);
        employees.add(employee);

        when(employeeRepository.findAllEmployeesByFullName(fullName)).thenReturn(employees);

        List<EmployeeResponseDto> employeeResponseDtos = employeeService.findAllEmployeesByFullName(fullName);

        // Verify that employeeRepository.findAllEmployeesByFullName() was called
        verify(employeeRepository, times(1)).findAllEmployeesByFullName(fullName);

        // Verify the size of employeeResponseDtos list
        assertEquals(1, employeeResponseDtos.size());

        // Optionally, verify the content of the first element in the list
        EmployeeResponseDto firstEmployeeDto = employeeResponseDtos.get(0);
        assertEquals(1L, firstEmployeeDto.getId());
        assertEquals("John Doe", firstEmployeeDto.getFullName());

    }
}