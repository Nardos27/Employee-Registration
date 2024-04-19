package com.Employee.registration.Service;

import com.Employee.registration.Dto.EmployeeRequestDto;
import com.Employee.registration.Dto.EmployeeResponseDto;
import com.Employee.registration.Model.Address;
import com.Employee.registration.Model.Employee;
import com.Employee.registration.Repository.AddressRepository;
import com.Employee.registration.Repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    AddressRepository addressRepository;

    public Employee addNewEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee = new Employee();
        employee.setFullName(employeeRequestDto.getFullName());
        employee.setEmail(employeeRequestDto.getEmail());
        employee.setPhoneNumber(employeeRequestDto.getPhoneNumber());
        employee.setAge(employeeRequestDto.getAge());
        Address address = new Address();
        address.setCity(employeeRequestDto.getCity());
        address.setCountry(employeeRequestDto.getCountry());
        employee.setAddress(address);
        addressRepository.save(address);
        return employeeRepository.save(employee);

    }
    public List<Employee> updateEmployeeByFullName(EmployeeRequestDto employeeRequestDto) {
        List<Employee> updatedEmployees = new ArrayList<>();

        List<Employee> employees = employeeRepository.findByFullName(employeeRequestDto.getFullName());

        if (!employees.isEmpty()) {
            Employee employee = employees.get(0);
            employee.setFullName(employeeRequestDto.getFullName());
            employee.setEmail(employeeRequestDto.getEmail());
            employee.setPhoneNumber(employeeRequestDto.getPhoneNumber());
            employee.setAge(employeeRequestDto.getAge());

            Address address = employee.getAddress();
            if (address == null) {
                address = new Address();
                employee.setAddress(address);
            }
            address.setCity(employeeRequestDto.getCity());
            address.setCountry(employeeRequestDto.getCountry());
            addressRepository.save(address);

            updatedEmployees.add(employeeRepository.save(employee));
        }
        return updatedEmployees;
    }


    public List<EmployeeResponseDto> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponseDto> employeeResponseDtos = new ArrayList<>();

        for (Employee employee : employees) {
            EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
            employeeResponseDto.setId(employee.getId());
            employeeResponseDto.setFullName(employee.getFullName());
            employeeResponseDto.setEmail(employee.getEmail());
            employeeResponseDto.setPhoneNumber(employee.getPhoneNumber());
            employeeResponseDto.setAge(employee.getAge());

            Address address = employee.getAddress();
            if (address != null) {
                employeeResponseDto.setAddressId(address.getId());
                employeeResponseDto.setCity(address.getCity());
                employeeResponseDto.setCountry(address.getCountry());
            }

            employeeResponseDtos.add(employeeResponseDto);
        }

        return employeeResponseDtos;
    }

    public List<EmployeeResponseDto> findAllEmployeesByFullName(String fullName) {
        List<Employee> employees = employeeRepository.findAllEmployeesByFullName(fullName);
        List<EmployeeResponseDto> employeeResponseDtos = new ArrayList<>();

        for (Employee employee : employees) {
            EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
            employeeResponseDto.setId(employee.getId());
            employeeResponseDto.setFullName(employee.getFullName());
            employeeResponseDto.setEmail(employee.getEmail());
            employeeResponseDto.setPhoneNumber(employee.getPhoneNumber());
            employeeResponseDto.setAge(employee.getAge());


            Address address = employee.getAddress();
            if (address != null) {
                employeeResponseDto.setAddressId(address.getId());
                employeeResponseDto.setCity(address.getCity());
                employeeResponseDto.setCountry(address.getCountry());
            }

            employeeResponseDtos.add(employeeResponseDto);
        }

        return employeeResponseDtos;
    }

}










