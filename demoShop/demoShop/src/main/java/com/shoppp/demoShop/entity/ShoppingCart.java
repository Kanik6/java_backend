package com.shoppp.demoShop.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "shopping_cart")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class ShoppingCart
{
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id_fk", nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(name = "cars_in_cart",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    private Set<Car> car;

    public ShoppingCart()
    {

    }

    public ShoppingCart(User userId)
    {
        this.user = userId;
    }

    public Long getId()
    {
        return id;
    }

    public User getUserId()
    {
        return user;
    }

    public void setUserId(User userId)
    {
        this.user = userId;
    }

    public Set<Car> getCar()
    {
        return car;
    }

    public void setCar(Set<Car> car)
    {
        this.car = car;
    }
}
