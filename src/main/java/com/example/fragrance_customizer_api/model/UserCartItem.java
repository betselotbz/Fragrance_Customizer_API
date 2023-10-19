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
    @JoinColumn(name = "custom_fg_id")
    private CustomFragrance customFragrance;

    public UserCartItem(Long id, User user, Perfume perfume, CustomFragrance customFragrance ){
        this.id = id;
        this.user = user;
        this.perfume = perfume;
        this.customFragrance = customFragrance;
    }
    public UserCartItem() {

    }
    public

}
