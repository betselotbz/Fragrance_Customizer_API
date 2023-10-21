package com.example.fragrance_customizer_api.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/**
        * Represents a custom fragrance entity.
        * <p>
 * This entity is used to store information about custom fragrances created by users.
         * It includes details such as family, notes, and a list of user cart items associated with it.
         * </p>
        *
        * @Entity Indicates that this class is a JPA entity and will be mapped to a database table.
        * @Table Specifies the details of the database table to be used for mapping.
        */
@Entity
@Table(name = "custom_fragrance")
public class CustomFragrance {
    /**
     * The unique identifier for the custom fragrance.
     */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * The family to which the custom fragrance belongs.
     */
    @Column
    private String family;
    /**
     * Additional notes or description of the custom fragrance.
     */
    @Column
    private String notes;
    /**
     * List of user cart items associated with this custom fragrance.
     */
    @OneToMany(mappedBy = "customFragrance", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<UserCartItem> userCartItemLists = new ArrayList<>();
    /**
     * Default constructor for the CustomFragrance class.
     */

    public CustomFragrance() {
        // Default constructor needed for JPA
    }
    /**
     * Parameterized constructor to create a CustomFragrance with specific attributes.
     *
     * @param id                 The unique identifier for the custom fragrance.
     * @param family             The family to which the custom fragrance belongs.
     * @param notes              Additional notes or description of the custom fragrance.
     * @param userCartItemLists List of user cart items associated with this custom fragrance.
     */
    public CustomFragrance(Long id, String family, String notes, List<UserCartItem> userCartItemLists) {
        this.id = id;
        this.family = family;
        this.notes = notes;
        this.userCartItemLists = userCartItemLists;
    }
    /**
     * Getter method for the custom fragrance ID.
     *
     * @return The unique identifier for the custom fragrance.
     */
    public Long getId() {
        return id;
    }
    /**
     * Setter method for the custom fragrance ID.
     *
     * @param id The unique identifier for the custom fragrance.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Getter method for the family of the custom fragrance.
     *
     * @return The family to which the custom fragrance belongs.
     */
    public String getFamily() {
        return family;
    }
    /**
     * Setter method for the family of the custom fragrance.
     *
     * @param family The family to which the custom fragrance belongs.
     */
    public void setFamily(String family) {
        this.family = family;
    }
    /**
     * Getter method for the notes of the custom fragrance.
     *
     * @return Additional notes or description of the custom fragrance.
     */
    public String getNotes() {
        return notes;
    }
    /**
     * Setter method for the notes of the custom fragrance.
     *
     * @param notes Additional notes or description of the custom fragrance.
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
    /**
     * Getter method for the list of user cart items associated with the custom fragrance.
     *
     * @return List of user cart items associated with this custom fragrance.
     */
    public List<UserCartItem> getUserCartItemLists() {
        return userCartItemLists;
    }
    /**
     * Setter method for the list of user cart items associated with the custom fragrance.
     *
     * @param userCartItemLists List of user cart items associated with this custom fragrance.
     */
    public void setUserCartItemLists(List<UserCartItem> userCartItemLists) {
        this.userCartItemLists = userCartItemLists;
    }
    /**
     * Overrides the default toString() method to provide a string representation of the CustomFragrance object.
     *
     * @return A string representation of the CustomFragrance object.
     */
    @Override
    public String toString() {
        return "CustomFragrance{" +
                "id=" + id +
                ", family='" + family + '\'' +
                ", notes='" + notes + '\'' +
                ", userCartItemLists=" + userCartItemLists +
                '}';
    }
}
