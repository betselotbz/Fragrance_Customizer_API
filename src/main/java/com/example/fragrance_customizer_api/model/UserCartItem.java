package com.example.fragrance_customizer_api.model;

import javax.persistence.*;

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
    @JoinColumn(name = "custom_fragrance_id")
    private CustomFragrance customFragrance;

    public UserCartItem() {

    }

    public UserCartItem(Long id, User user, Perfume perfume, CustomFragrance customFragrance ){
        this.id = id;
        this.user = user;
        this.perfume = perfume;
        this.customFragrance = customFragrance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Perfume getPerfume() {
        return perfume;
    }

    public void setPerfume(Perfume perfume) {
        this.perfume = perfume;
    }

    public CustomFragrance getCustomFragrance() {
        return customFragrance;
    }

    public void setCustomFragrance(CustomFragrance customFragrance) {
        this.customFragrance = customFragrance;
    }

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
