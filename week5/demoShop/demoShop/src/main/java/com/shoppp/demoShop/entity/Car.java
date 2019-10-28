package com.shoppp.demoShop.entity;


import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private Long id;

	private String name;

	private Double price;

	private Integer year;

	@ManyToOne(fetch = FetchType.EAGER)
	private User user;

	public Car()
	{

	}

	public Car(String name, Double price, Integer year)
	{
		this.name = name;
		this.price = price;
		this.year = year;
	}
 
	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}
	
	public Double getPrice()
	{
		return price;
	}

	public void setYear(Integer year)
	{
		this.year = year;
	}
	
	public Integer getYear()
	{
		return year;
	}

	public String toString()
	{
		return "name: " + name+"\nPrice: "+ price+ "\nYear: "+ year;
	}

}