package com.Employee.registration.Model;

import org.springframework.boot.autoconfigure.domain.EntityScan;


public class Employee {

    private Long id;

    private String fullName;

    private String Email;

    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Employee() {
    }

    public Employee(Long id, String fullName, String email, String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        Email = email;
        this.phoneNumber = phoneNumber;
    }
}
