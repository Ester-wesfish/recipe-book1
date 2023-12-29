package com.recipebook1.entity;

import jakarta.persistence.*;

import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.recipebook1.dto.IngredientDTO;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long recipeId;

    @Column(name = "recipe_name")
    private String recipeName;

    @Column(name = "instructions")
    private String instructions;

   @OneToMany(mappedBy = "recipe",cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Set<RecipeIngredient> recipeIngredients;


   @Transient
   private double totalPrice;
   
    public Recipe() {
        
    }

    public Recipe(String recipeName, String instructions,double totalPrice) {
        this.recipeName = recipeName;
        this.instructions = instructions;
        this.totalPrice=totalPrice;
    }
    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    public String getInstructions() {
        return instructions;
    }

    public void setPreparationInstructions(String instructions) {
        this.instructions = instructions;
    } public Set<RecipeIngredient> getRecipeIngredient() {
        return recipeIngredients;
    }

    public void setRecipeIngredient(Set<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}