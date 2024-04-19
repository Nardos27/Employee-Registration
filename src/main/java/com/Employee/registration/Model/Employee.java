
package com.Employee.registration.Model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String phoneNumber;

    private Integer age;
    @ManyToOne
    @JoinColumn(
            name="address"
    )
    private Address address;

}



