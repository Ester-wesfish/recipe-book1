package com.recipebook1.entity;



import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.*;
@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Long ingredientId;

    @Column(name = "ingredient_name")
    private String ingredientName;

    @Column(name = "price")
    private double price;

    @OneToMany(mappedBy = "ingredient", fetch = FetchType.EAGER)
   @Fetch(FetchMode.JOIN)
    private Set<RecipeIngredient> recipeIngredients;
   // @OneToMany(mappedBy = "ingredients")
   // private Set<Recipe> recipes;

  
    public Ingredient() {
    }

    public Ingredient(String ingredientName, double price) {
        this.ingredientName = ingredientName;
        this.price = price;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
   

   
}
