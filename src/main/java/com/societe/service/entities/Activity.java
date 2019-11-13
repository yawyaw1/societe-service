package com.societe.service.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity(name = "Activity")
@Table(name = "ACTIVITY")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "START_DATE")
    @CreatedDate
    private LocalDate startDate;

    @Column(name = "END_DATE")
    @CreatedDate
    private LocalDate endDate;

    @OneToOne
    private Employee employee;
}
