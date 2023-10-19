package com.example.fragrance_customizer_api.model;

import javax.persistence.*;

@Entity
@Table(name = "custom_fragrance")
public class CustomFragrance {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
