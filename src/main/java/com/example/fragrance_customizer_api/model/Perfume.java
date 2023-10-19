package com.example.fragrance_customizer_api.model;

import javax.persistence.*;

@Entity
@Table(name = "perfumes")
public class Perfume {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String name;
    @Column (nullable = false)
    private String Family;
    @Column (nullable = false)
    private String Notes;
    @Column (nullable = false)
    private String Image;



}
