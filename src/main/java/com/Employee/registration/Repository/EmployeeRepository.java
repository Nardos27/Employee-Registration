package com.Employee.registration.Repository;

import com.Employee.registration.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllEmployeesByFullName(String fullName);



        List<Employee> findByFullName(String fullName);




}
