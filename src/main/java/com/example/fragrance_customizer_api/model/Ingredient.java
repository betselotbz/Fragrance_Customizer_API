package com.example.fragrance_customizer_api.model;

import javax.persistence.*;

/**
 * Represents an ingredient used in the formulation of a custom fragrance.
 *
 * Each instance of this class holds information about a specific ingredient, including its name,
 * and an image. The class also manages the association with a custom fragrance through
 * the {@link CustomFragrance} entity.
 *
 */
@Entity
@Table(name = "ingredients")
public class Ingredient {

    /**
     * The unique identifier for the ingredient.
     */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the ingredient.
     */
    @Column()
    private String name;

    /**
     * The image of the ingredient used in the formulation.
     */

    @Column
    private String image;

    /**
     * Represents the association of this entity with a CustomFragrance.
     * This is a many-to-one relationship, indicating that multiple instances
     * of this entity may be associated with a single CustomFragrance.
     * The association is mapped to the 'customFragrance_id' column in the database.
     */
    @ManyToOne
    @JoinColumn(name = "customFragrance_id")
    private CustomFragrance customFragrance;


    /**
     * Default constructor required for JPA.
     */
    public Ingredient() {

    }

    /**
     * Constructs a new Ingredient with the given parameters.
     *
     * @param id              The unique identifier for the ingredient.
     * @param name            The name of the ingredient.
     * @param image           The image representing the ingredient.
     */
    public Ingredient(Long id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    /**
     * Constructs a new Ingredient with the given parameters.
     *
     * @param id              The unique identifier for the ingredient.
     * @param name            The name of the ingredient.
     * @param image           The image representing the ingredient.
     */
    public Ingredient(Long id, String name, String image, CustomFragrance customFragrance) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.customFragrance = customFragrance;
    }

    // Getter and setter methods
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public CustomFragrance getCustomFragrance() {
        return customFragrance;
    }

    public void setCustomFragrance(CustomFragrance customFragrance) {
        this.customFragrance = customFragrance;
    }

    /**
     * Returns a string representation of the Ingredient object.
     *
     * @return A string representation of the Ingredient object.
     */
    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

}
