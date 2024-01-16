package com.Employee.registration.Service;

import com.Employee.registration.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    public List<Employee> findAllEmployees(){
        return List.of(
                new Employee(
                        1l,
                        "Nardos Mulugeta",
                        "Nardos@gmail.com",
                        "0940643322"
                ),
        new Employee(
                2l,
                "Mahlet Mulugeta",
                "Mahlet@gmail.com",
                "0911121314"
        )
        );
    }


}
