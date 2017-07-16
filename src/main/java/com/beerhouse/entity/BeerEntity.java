package com.beerhouse.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="Beer")
@Entity
public class BeerEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	private String Name;
	private String Ingredients;
	private String AlcoholContent;
	private Float Price;
	private String Category;
	
	//Ctor	
	public BeerEntity(String name, String ingredients, String alcoholContent, Float price, String category) {
		super();
		Name = name;
		Ingredients = ingredients;
		AlcoholContent = alcoholContent;
		Price = price;
		Category = category;
	}
	
	
	
	public BeerEntity() {
		super();
	}



	//Setters Getters
	
	public Integer getId() {
		return Id;
	}
	
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getIngredients() {
		return Ingredients;
	}
	public void setIngredients(String ingredients) {
		Ingredients = ingredients;
	}
	public String getAlcoholContent() {
		return AlcoholContent;
	}
	public void setAlcoholContent(String alcoholContent) {
		AlcoholContent = alcoholContent;
	}
	public Float getPrice() {
		return Price;
	}
	public void setPrice(Float price) {
		Price = price;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	
	
	
	
}
/*
id:	integer
name:	string
ingredients:	string
alcoholContent:	string
price:	number
category:	string
 */