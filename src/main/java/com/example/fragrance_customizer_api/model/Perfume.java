package com.example.fragrance_customizer_api.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Represents a perfume available on the website.
 *
 * Each instance of this class holds information about a specific perfume, including its name, family,
 * notes, and an image. The class also manages the association with user cart items through the
 * {@link UserCartItem} entities.
 *
 */
@Entity
@Table(name = "perfumes")
public class Perfume {

    /**
     * The unique identifier for the perfume.
     */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the perfume.
     */
    @Column(nullable = false)
    private String name;

    /**
     * The family to which the perfume belongs (e.g., floral, citrus).
     */
    @Column(nullable = false)
    private String family;

    /**
     * Descriptive notes about the perfume.
     */
    @Column(nullable = false)
    private String notes;

    /**
     * The image representing the perfume.
     */
    @Column(nullable = false)
    private String image;

    @OneToMany(mappedBy = "perfume")
    private Collection<UserCartItem> userCartItems;

    /**
     * Default constructor required for JPA.
     */
    public Perfume() {

    }
    /**
     * Constructs a new Perfume with the given parameters.
     *
     * @param id    The unique identifier for the perfume.
     * @param name  The name of the perfume.
     * @param family The family to which the perfume belongs (e.g., floral, citrus).
     * @param notes Descriptive notes about the perfume.
     * @param image The image representing the perfume.
     */
    public Perfume(Long id, String name, String family, String notes, String image) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.notes = notes;
        this.image = image;
    }

    // Getter and setter methods
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
    public Collection<UserCartItem> getUserCartItems() {
        return userCartItems;
    }

    public void setUserCartItems(Collection<UserCartItem> userCartItems) {
        this.userCartItems = userCartItems;
    }

    /**
     * Returns a string representation of the Perfume object.
     *
     * @return A string representation of the Perfume object.
     */
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
