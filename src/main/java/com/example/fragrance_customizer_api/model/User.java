package com.example.fragrance_customizer_api.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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
    private String password;


    public User(Long id, String name, String emailAddress, String password) {
        this.id = id;
        this.name = name;
        this.emailAddress=emailAddress;
        this.password=password;
    }

    public String getName() {
        return name;
    }
    public void setName() {
        this.name = name;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress() {
        this.emailAddress = emailAddress;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword() {
        this.password = password;
    }
}
