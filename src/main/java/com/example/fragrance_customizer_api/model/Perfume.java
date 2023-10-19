package com.example.fragrance_customizer_api.model;

import javax.persistence.*;

@Entity
@Table(name = "perfumes")
public class Perfume {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
