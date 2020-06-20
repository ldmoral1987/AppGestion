package com.empresa.appinventario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="id")
	@NotNull
	private long id;
	
	@Column(name="name")
	@NotNull
	private String name;
	
	@Column(name="email")
	@Email
	private String email;
	
	@Column(name="telephone")
	@NotNull
	private String telephone;
	
	public Employee()
	{

	}
	
	public Employee(long id, String name, String email, String telephone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", telephone=" + telephone + "]";
	}
}
