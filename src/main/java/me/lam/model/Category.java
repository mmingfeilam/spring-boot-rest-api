package me.lam.model;
// Generated Dec 28, 2020 12:24:35 AM by Hibernate Tools 5.2.10.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category")
public class Category implements java.io.Serializable {

	private int id;
	private String name;

	@JsonBackReference
	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
	private Set<Product> products = new HashSet<Product>(0);

	public Category() {
	}

	public Category(int id) {
		this.id = id;
	}

	public Category(int id, String name, Set<Product> products) {
		this.id = id;
		this.name = name;
		this.products = products;
	}

	@Id

	@Column(name = "Id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}