package com.example.fragrance_customizer_api.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column(unique = true) //no two records in the table can have the same emailAddress.
    private String emailAddress;
    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // ensure that the password is not accidentally exposed in the JSON representation of the object
    private String passWord;
}
