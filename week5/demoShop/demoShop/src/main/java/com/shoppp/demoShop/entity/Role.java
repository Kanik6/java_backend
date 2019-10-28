package com.shoppp.demoShop.entity;


import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role
{
	@Id
	@SequenceGenerator(name = "mySeqGenRole", sequenceName = "mySeqRole", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "mySeqGenRole")
	@Column(name = "role_id")
	private Long id;

	private String name;

	//====================
	public Role()
	{

	}

	public Role(String name)
	{
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "Role{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}