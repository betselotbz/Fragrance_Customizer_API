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

    public Perfume(Long id, String name, String family, String notes, String image) {
        this.id = id;
        this.name = name;
        Family = family;
        Notes = notes;
        Image = image;
    }

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
        return Family;
    }

    public void setFamily(String family) {
        Family = family;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
