package com.recipebook1.dto;

import java.util.Set;

public class RecipeDTO {
	
	 private Long recipeId;
	    private String recipeName;
	    private String instructions;
	    private Set<IngredientDTO> ingredients;
	    private double totalPrice;
	 public RecipeDTO() {
	        
	    }

	 public RecipeDTO(String recipeName, String instructions,double totalPrice) {
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
	    }
	    public Set<IngredientDTO> getIngredients() {
	        return ingredients;
	    }

	    public void setIngredients(Set<IngredientDTO> ingredients) {
	        this.ingredients = ingredients;
	    }
	    public double getTotalPrice() {
	        return totalPrice;
	    }

	    public void setTotalPrice(double totalPrice) {
	        this.totalPrice = totalPrice;
	    }
}
