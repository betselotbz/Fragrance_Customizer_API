package com.example.fragrance_customizer_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Entity class representing a user in the application.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column(unique = true) //No two records in the table can have the same emailAddress.
    private String emailAddress;
    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // ensure that the password is not accidentally exposed in the JSON representation of the object
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<UserCartItem> userCartItems = new ArrayList<>();

    /**
     * Default constructor needed for JPA.
     */
    public User() {

    }
    /**
     * Constructor to initialize a User with specific values.
     *
     * @param id           The ID of the user.
     * @param name         The name of the user.
     * @param emailAddress The email address of the user.
     * @param password     The password of the user.
     */
    public User(Long id, String name, String emailAddress, String password) {
        this.id = id;
        this.name = name;
        this.emailAddress=emailAddress;
        this.password=password;
    }
    /**
     * Get the ID of the user.
     *
     * @return The ID of the user.
     */
    public Long getId() {
        return id;
    }
    /**
     * Set the ID of the user.
     *
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Get the name of the user.
     *
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }
    /**
     * Set the name of the user.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get the email address of the user.
     *
     * @return The email address of the user.
     */
    public String getEmailAddress() {
        return emailAddress;
    }
    /**
     * Set the email address of the user.
     *
     * @param emailAddress The email address to set.
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    /**
     * Get the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }
    /**
     * Set the password of the user.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Get the list of cart items associated with the user.
     *
     * @return The list of cart items associated with the user.
     */
    public List<UserCartItem> getUserCartItems() {
        return userCartItems;
    }
    /**
     * Set the list of cart items associated with the user.
     *
     * @param userCartItems The list of cart items to set.
     */
    public void setUserCartItems(List<UserCartItem> userCartItems) {
        this.userCartItems = userCartItems;
    }
    /**
     * Returns a string representation of the User object.
     *
     * This implementation includes the user's id, name, email address, and password.
     *
     * @return A string representation of the User.
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
