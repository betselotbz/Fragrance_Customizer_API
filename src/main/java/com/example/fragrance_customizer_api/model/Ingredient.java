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
    @Column
    private String name;

    /**
     * The image of the ingredient used in the formulation.
     */

    @Column
    private String image;

    /**
     * The custom fragrance to which this ingredient belongs.
     *
     * <p>Represents the many-to-one relationship between an ingredient and the custom fragrance it is part of.
     * Cascades all operations (persist, remove, refresh, merge, detach) to the associated custom fragrance.</p>
     *
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private CustomFragrance customFragranceList;

    /**
     * Default constructor required for JPA.
     */
    public Ingredient() {

    }

    /**
     * Constructs a new Ingredient with the given parameters.
     *
     * @param id     The unique identifier for the ingredient.
     * @param name   The name of the ingredient.
     * @param image  The image representing the ingredient.
     */
    public Ingredient(Long id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;

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

    public CustomFragrance getCustomFragranceList() {
        return customFragranceList;
    }

    public void setCustomFragranceList(CustomFragrance customFragranceList) {
        this.customFragranceList = customFragranceList;
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
                ", customFragranceList=" + customFragranceList +
                '}';
    }

}
