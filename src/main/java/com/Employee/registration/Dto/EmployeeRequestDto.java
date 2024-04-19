package com.Employee.registration.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequestDto {
    private Long id;

    private String fullName;

    private String email;

    private String phoneNumber;

    private Integer age;

    private Long address_id;

    private String city;

    private String country;

//    public Address address;

//        public  void setAddress(Address address) {
//            this.address = address;
//        }
//
//        public Address getAddress() {
//            return address;
//        }

}
