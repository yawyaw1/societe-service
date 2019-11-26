package com.employee.service.entities;

import com.employee.service.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Company")
@Table(name = "COMPANY")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @Column(name = "DESCRIPTION")
    private String description;

    @Enumerated(EnumType.STRING)
    private FinalityEnum finality;

    @Enumerated(EnumType.STRING)
    private SizeEnum size;

    @Enumerated(EnumType.STRING)
    private LegalStatus legalStatus;

    @Enumerated(EnumType.STRING)
    private NationalityEnum nationality;

    @OneToOne
    private Sector sector;

    @OneToOne
    private Activity activity;

    @OneToOne
    private Domain domain;

    @ManyToOne
    private User user;

}
