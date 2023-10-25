package com.example.fragrance_customizer_api.model;

import javax.persistence.*;
import java.util.Collection;

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
     * Additional notes or description of the custom fragrance.
     */
    @Column
    private String name;


    /**
     * Default constructor for the CustomFragrance class.
     */

    public CustomFragrance() {
        // Default constructor needed for JPA
    }

    /**
     * Parameterized constructor to create a CustomFragrance with specific attributes.
     *
     * @param id   The unique identifier for the custom fragrance.
     * @param name Additional notes or description of the custom fragrance.
     */
    public CustomFragrance(Long id, String name) {
        this.id = id;
        this.name = name;
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
     * Getter method for the notes of the custom fragrance.
     *
     * @return Additional notes or description of the custom fragrance.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the notes of the custom fragrance.
     *
     * @param notes Additional notes or description of the custom fragrance.
     */
    public void setName(String notes) {
        this.name = notes;
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
                ", notes='" + name + '\'' +
                '}';
    }

    @OneToMany(mappedBy = "customFragrance", fetch = FetchType.EAGER)
    private Collection<Ingredient> ingredients;

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @OneToMany(mappedBy = "customFragrance")
    private Collection<UserCartItem> userCartItems;

    public Collection<UserCartItem> getUserCartItems() {
        return userCartItems;
    }

    public void setUserCartItems(Collection<UserCartItem> userCartItems) {
        this.userCartItems = userCartItems;
    }
}
