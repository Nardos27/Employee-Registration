package com.Employee.registration.Controller;

import com.Employee.registration.Model.Employee;
import com.Employee.registration.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class EmployeeController {


    private EmployeeService Service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        Service = service;
    }

    @GetMapping
    public List<Employee> findAllEmployees(){
        return Service.findAllEmployees();
    }
}
