package com.example.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Domain")
@Table(name = "DOMAIN")
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
