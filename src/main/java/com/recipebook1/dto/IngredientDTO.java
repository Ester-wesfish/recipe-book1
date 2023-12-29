package com.recipebook1.dto;

public class IngredientDTO {
	 private Long ingredientId;
	    private String ingredientName;
	    private double price;
	    
	    public IngredientDTO() {
	    }

	    public IngredientDTO(String ingredientName, double price) {
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
