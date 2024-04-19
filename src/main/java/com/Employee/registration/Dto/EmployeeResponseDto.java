package com.Employee.registration.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponseDto {

    private Long id;

    private String fullName;
@Column(unique = true)
    private String email;

    private String phoneNumber;

    private Integer age;

   private Long addressId;

    private String city;

    private String country;
}
