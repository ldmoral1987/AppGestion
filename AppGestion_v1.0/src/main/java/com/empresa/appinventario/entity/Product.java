package com.empresa.appinventario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@Column(name="id")
	@NotNull
	private long id;
	
	@Column(name="reference")
	@NotNull
	private String reference;
	
	@Column(name="name")
	@NotNull
	private String name;
	
	@Column(name="category")
	@NotNull
	private String category;
	
	@Column(name="price")
	@Min(1)
	private float price;
	
	public Product() {
		
	}

	public Product(long id, String reference, String name, String category, float price) {
		this.id = id;
		this.reference = reference;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", reference=" + reference + ", name=" + name + ", category=" + category
				+ ", price=" + price + "]";
	}
}
