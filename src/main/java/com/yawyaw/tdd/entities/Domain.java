package com.yawyaw.tdd.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Domain")
@Table(name = "DOMAIN")
public class Domain {

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
}
