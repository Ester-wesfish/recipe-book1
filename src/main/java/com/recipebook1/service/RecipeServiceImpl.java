package com.recipebook1.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipebook1.dto.IngredientDTO;
import com.recipebook1.dto.RecipeDTO;
import com.recipebook1.entity.Ingredient;
import com.recipebook1.entity.Recipe;
import com.recipebook1.entity.RecipeIngredient;
import com.recipebook1.repository.RecipeIngredientRepository;
import com.recipebook1.repository.RecipeRepository;


@Service
public class RecipeServiceImpl implements RecipeService {
	private static final Logger logger = LoggerFactory.getLogger(RecipeServiceImpl.class);
 
    @Autowired
    private RecipeRepository recipeRepository;
    
    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

  
    @Override
    public List<RecipeDTO> getAllRecipesWithIngredients() {
    	try {
        List<Recipe> recipes = recipeRepository.findAll();
        List<RecipeDTO> recipeDTOs = new ArrayList<>();

        for (Recipe recipe : recipes) {
            RecipeDTO recipeDTO = new RecipeDTO();
            recipeDTO.setRecipeId(recipe.getRecipeId());
            recipeDTO.setRecipeName(recipe.getRecipeName());
            recipeDTO.setPreparationInstructions(recipe.getInstructions());

            Set<IngredientDTO> ingredientDTOs = new HashSet<>();
            double totalPrice = 0.0;
            
            for (RecipeIngredient recipeIngredient : recipe.getRecipeIngredient()) {
                Ingredient ingredient = recipeIngredient.getIngredient();
                IngredientDTO ingredientDTO = new IngredientDTO();
                ingredientDTO.setIngredientId(ingredient.getIngredientId());
                ingredientDTO.setIngredientName(ingredient.getIngredientName());
                ingredientDTO.setPrice(ingredient.getPrice());
                
                totalPrice += ingredient.getPrice();

                ingredientDTOs.add(ingredientDTO);
            }
            recipeDTO.setIngredients(ingredientDTOs);
            recipeDTO.setTotalPrice(totalPrice);

            recipeDTOs.add(recipeDTO);
        }
        logger.info("Retrieved {} recipes with ingredients", recipes.size());
        
        return recipeDTOs;
    } catch (Exception e) {
        logger.error("Error retrieving recipes with ingredients", e);
        throw new RuntimeException("Failed to retrieve recipes with ingredients", e);
    }
    }
    
    
    
   @Override
    public void addRecipe(RecipeDTO recipeDTO) {
	   try {
        Recipe recipe = new Recipe();
        recipe.setRecipeName(recipeDTO.getRecipeName());
        recipe.setPreparationInstructions(recipeDTO.getInstructions());

        Set<RecipeIngredient> recipeIngredients = new HashSet<>();

        for (IngredientDTO ingredientDTO : recipeDTO.getIngredients()) {
            Ingredient ingredient = new Ingredient();
            ingredient.setIngredientName(ingredientDTO.getIngredientName());
            ingredient.setPrice(ingredientDTO.getPrice());

            RecipeIngredient recipeIngredient = new RecipeIngredient();
            recipeIngredient.setIngredient(ingredient);
            recipeIngredient.setRecipe(recipe);

            recipeIngredients.add(recipeIngredient);
        }

        recipe.setRecipeIngredient(recipeIngredients);
        recipeRepository.save(recipe);
        logger.info("Recipe added successfully: {}", recipeDTO.getRecipeName());
       } catch (Exception e) {
           logger.error("Error adding recipe", e);
       }
    }
        
    
}

