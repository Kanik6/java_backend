package com.shoppp.demoShop.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User 
{
    @Id
    @SequenceGenerator(name = "mySeqGenUser", sequenceName = "mySeqUser", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "mySeqGenUser")
    @Column(name = "user_id")
	private Long id;

	private String userName;

	private String password;

	private boolean active;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "basket",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    private Set<Car> car;

	public User()
    {

    }
    public User(String username, String password, boolean active)
    {
        super();
        this.userName = username;
        this.password = password;
        this.active = active;
    }

	public User(String username, String password, boolean active, Set<Role> roles)
	{
        this(username, password, active);
        this.roles = roles;
    }

    public void setId(Long id)
    {
    	this.id = id;
    }

    public Long getId()
    {
    	return id;
    }
    //================
    
    public void setUserName(String userName)
    {
    	this.userName = userName;
    }

    public String getUserName()
    {
    	return userName;
    }

    //========================

    public void setPassword(String password)
    {
    	this.password = password;
    }

    public String getPassword()
    {
    	return password;
    }

    //===========================

    public void setActive(boolean active)
    {
    	this.active = active;
    }

    public boolean isActive()
    {
    	return active;
    }

    //===========================

    public void setRoles(Set<Role> roles)
    {
    	this.roles = roles;
    }

    public Set<Role> getRoles()
    {
    	return roles;
    }

    public Set<Car> getCar() {
        return car;
    }

    public void setCar(Set<Car> car) {
        this.car = car;
    }

    public String toString()
    {
    	return "id: "+id+"\nUser Name: "+userName+"\nPassword: "+password+"\nRoles: "+roles+"";
    }
}