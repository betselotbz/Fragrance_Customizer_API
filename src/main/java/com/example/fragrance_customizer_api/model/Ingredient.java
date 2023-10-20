package com.example.fragrance_customizer_api.model;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Column
    public String name;
    @Column
    public String amount;
    @Column
    public String image;



    public Ingredient(String name, String amount, String image) {
        this.name = name;
        this.amount = amount;
        this.image = image;
    }
}
