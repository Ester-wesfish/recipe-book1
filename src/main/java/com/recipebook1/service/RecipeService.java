package com.recipebook1.service;

import java.util.List;

import com.recipebook1.dto.RecipeDTO;
import com.recipebook1.entity.Recipe;

public interface RecipeService {
    List<Recipe> getAllRecipes();
    List<RecipeDTO> getAllRecipesWithIngredients();
    void addRecipe(RecipeDTO recipeDTO); 
}
