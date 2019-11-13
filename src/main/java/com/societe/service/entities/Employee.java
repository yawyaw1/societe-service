package com.societe.service.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Employee")
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FIRSTNAME")
    @Size(max = 30,message = "FirstName should not be empty")
    private String firstname;

    @Column(name = "LASTNAME")
    @Size(max = 30,message = "LastName should not be empty")
    private String lastname;

    @Column(name = "ADRESS")
    @Size(max = 30,message = "Address should not be empty")
    private String adress;

    @Column(name = "BIRTHDAY")
    @CreatedDate
    @Size(max = 30,message = "Birthday should not be empty")
    private LocalDate birthday;

}
