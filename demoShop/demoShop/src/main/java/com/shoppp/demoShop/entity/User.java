package com.shoppp.demoShop.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
@ApiModel(value = "This is User model   ")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User 
{
    @Id
    @SequenceGenerator(name = "mySeqGenUser", sequenceName = "mySeqUser", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "mySeqGenUser")
    @Column(name = "user_id")
	private Long id;

    @Column(name = "user_name")
	private String userName;

    @Column(name = "password")
	private String password;

    @Column(name = "active")
	private boolean active;

    @Column(name = "phone_num")
    private String phoneNum;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ShoppingCart shoppingCart;

    @Column(name = "balance")
    private Double balance = 0d;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public User()
    {

    }

    public User(String userName, String password, boolean active, String phoneNum)
    {
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.phoneNum = phoneNum;
    }

    public User(String userName, String password, boolean active, String phoneNum, Set<Role> roles)
    {
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.phoneNum = phoneNum;
        this.roles = roles;
    }

    public Long getId()
    {
        return id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public String getPhoneNum()
    {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum)
    {
        this.phoneNum = phoneNum;
    }

    public ShoppingCart getShoppingCart()
    {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart)
    {
        this.shoppingCart = shoppingCart;
    }

    public Set<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<Role> roles)
    {
        this.roles = roles;
    }

    public Double getBalance()
    {
        return balance;
    }

    public void setBalance(Double balance)
    {
        this.balance = balance;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", phoneNum='" + phoneNum + '\'' +
                ", roles=" + roles +
                '}';
    }
}