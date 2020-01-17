package com.shoppp.demoShop.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cars")
public class Car
{
	@Id
	@Column(name = "car_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "year")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate year;

	@Column(name = "price")
	private Double price;

	@Column(name = "in_stock")
	private Boolean inStock = true;

	@Column
	@Enumerated(EnumType.STRING)
	private Category categories;

	public Car()
	{
	}

	public Car(String name, LocalDate year, Double price, Boolean inStock, Category categories)
	{
		this.name = name;
		this.year = year;
		this.price = price;
		this.inStock = inStock;
		this.categories = categories;
	}

	public Long getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public LocalDate getYear()
	{
		return year;
	}

	public void setYear(LocalDate year)
	{
		this.year = year;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

	public Boolean getInStock()
	{
		return inStock;
	}

	public void setInStock(Boolean inStock)
	{
		this.inStock = inStock;
	}

	public Category getCategories()
	{
		return categories;
	}

	public void setCategories(Category categories)
	{
		this.categories = categories;
	}

	@Override
	public String toString()
	{
		return "Car{" +
				"id=" + id +
				", name='" + name + '\'' +
				", year=" + year +
				", price=" + price +
				", inStock=" + inStock +
				", categories=" + categories +
				'}';
	}
}