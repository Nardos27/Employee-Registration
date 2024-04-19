package com.Employee.registration.Controller;

import com.Employee.registration.Dto.EmployeeRequestDto;
import com.Employee.registration.Dto.EmployeeResponseDto;
import com.Employee.registration.Model.Employee;
import com.Employee.registration.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping("Employee/add")
    public Employee registerNewEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        return service.addNewEmployee(employeeRequestDto);

    }
    @PutMapping("/Employee/update/{id}")
    public List<Employee> updateEmployeeByFullName(@RequestBody EmployeeRequestDto employeeRequestDto) {
        return service.updateEmployeeByFullName(employeeRequestDto);
    }


    @GetMapping("/Employee")
    public List<EmployeeResponseDto> findAllEmployees() {
        return service.findAllEmployees();
    }

    @GetMapping("/Employee/search/{Employee-name}")
   public List<EmployeeResponseDto> findEmployeesByName(@PathVariable ("Employee-name")String fullName){
        return service.findAllEmployeesByFullName(fullName);
    }


}





