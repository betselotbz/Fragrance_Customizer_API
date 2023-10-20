package com.example.fragrance_customizer_api.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String amount;
    @Column
    private String image;

    @ManyToOne(cascade = CascadeType.ALL)
    private CustomFragrance customFragranceList;

    public Ingredient() {

    }

    public Ingredient(Long id, String name, String amount, String image) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.image = image;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public CustomFragrance getCustomFragranceList() {
        return customFragranceList;
    }

    public void setCustomFragranceList(CustomFragrance customFragranceList) {
        this.customFragranceList = customFragranceList;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                "name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                ", image='" + image + '\'' +
                ", customFragranceList=" + customFragranceList +
                '}';
    }

}
