package com.example.fragrance_customizer_api.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "custom_fragrance")
public class CustomFragrance {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String family;
    @Column
    private String notes;
    @OneToMany(mappedBy = "customFragrance", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<UserCartItem> userCartItemLists = new ArrayList<>();

    public CustomFragrance() {

    }
    public CustomFragrance(Long id, String family, String notes, List<UserCartItem> userCartItemLists) {
        this.id = id;
        this.family = family;
        this.notes = notes;
        this.userCartItemLists = userCartItemLists;
    }
    @OneToMany(mappedBy = "custom_fragrance", cascade = CascadeType.ALL)
    private List<UserCartItem> userCartItems = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<UserCartItem> getUserCartItemLists() {
        return userCartItemLists;
    }

    public void setUserCartItemLists(List<UserCartItem> userCartItemLists) {
        this.userCartItemLists = userCartItemLists;
    }

    @Override
    public String toString() {
        return "CustomFragrance{" +
                "id=" + id +
                ", family='" + family + '\'' +
                ", notes='" + notes + '\'' +
                ", userCartItemLists=" + userCartItemLists +
                ", userCartItems=" + userCartItems +
                '}';
    }
}
