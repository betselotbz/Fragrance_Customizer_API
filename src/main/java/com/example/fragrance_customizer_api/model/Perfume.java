package com.example.fragrance_customizer_api.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "perfumes")
public class Perfume {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String family;
    @Column(nullable = false)
    private String notes;
    @Column(nullable = false)
    private String image;

    public Perfume() {

    }

    public Perfume(Long id, String name, String family, String notes, String image) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.notes = notes;
        this.image = image;
    }
    @OneToMany(mappedBy = "perfume", cascade = CascadeType.ALL)
    private List<UserCartItem> userCartItems = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<UserCartItem> getUserCartItems() {
        return userCartItems;
    }

    public void setUserCartItems(List<UserCartItem> userCartItems) {
        this.userCartItems = userCartItems;
    }

    @Override
    public String toString() {
        return "Perfume{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", notes='" + notes + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
