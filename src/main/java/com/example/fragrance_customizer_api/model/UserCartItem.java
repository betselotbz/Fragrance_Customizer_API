package com.example.fragrance_customizer_api.model;

import javax.persistence.*;
/**
 * Entity class representing a user's cart item.
 * Each item in the cart corresponds to a perfume or a custom fragrance.
 */
@Entity
@Table(name = "user_cart_item")
public class UserCartItem {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "perfume_id")
    private Perfume perfume;

    @ManyToOne
    @JoinColumn(name = "customFragrance_id")
    private CustomFragrance customFragrance;
    /**
     * Default constructor required for JPA.
     */
    public UserCartItem() {

    }
    /**
     * Constructor to initialize a UserCartItem with specific values.
     *
     * @param id      The ID of the cart item.
     * @param user    The user associated with the cart item.
     * @param perfume The perfume associated with the cart item.
     */
    public UserCartItem(Long id, User user, Perfume perfume){
        this.id = id;
        this.user = user;
        this.perfume = perfume;
    }


    /**
     * @param id  The ID of the cart item.
     * @param user The user associated with the cart item.
     * @param customFragrance The customFragrance associated with the cart item.
     */
    public UserCartItem(Long id, User user, CustomFragrance customFragrance){
        this.id = id;
        this.user = user;
        this.customFragrance = customFragrance;
    }
    /**
     * Get the ID of the cart item.
     *
     * @return The ID of the cart item.
     */
    public Long getId() {
        return id;
    }
    /**
     * Set the ID of the cart item.
     *
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Get the user associated with the cart item.
     *
     * @return The user associated with the cart item.
     */
    public User getUser() {
        return user;
    }
    /**
     * Set the user associated with the cart item.
     *
     * @param user The user to set.
     */
    public void setUser(User user) {
        this.user = user;
    }
    /**
     * Get the perfume associated with the cart item.
     *
     * @return The perfume associated with the cart item.
     */
    public Perfume getPerfume() {
        return perfume;
    }
    /**
     * Set the perfume associated with the cart item.
     *
     * @param perfume The perfume to set.
     */
    public void setPerfume(Perfume perfume) {
        this.perfume = perfume;
    }
    /**
     * Get the custom fragrance associated with the cart item.
     *
     * @return The custom fragrance associated with the cart item.
     */
    public CustomFragrance getCustomFragrance() {
        return customFragrance;
    }
    /**
     * Set the custom fragrance associated with the cart item.
     *
     * @param customFragrance The custom fragrance to set.
     */
    public void setCustomFragrance(CustomFragrance customFragrance) {
        this.customFragrance = customFragrance;
    }
    /**
     * Override of the default `toString` method to provide a string representation of the cart item.
     *
     * @return A string representation of the cart item.
     */
    @Override
    public String toString() {
        return "UserCartItem{" +
                "id=" + id +
                ", user=" + user +
                ", perfume=" + perfume +
                ", customFragrance=" + customFragrance +
                '}';
    }
}
