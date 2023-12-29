package com.recipebook1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipebook1.dto.RecipeDTO;
import com.recipebook1.entity.Recipe;
import com.recipebook1.service.RecipeService;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
	
	  @Autowired
	  private RecipeService recipeService;

	    

		@GetMapping
		public List<Recipe> getRecipes() {
			return recipeService.getAllRecipes();
		}
		 @GetMapping("/allWithIngredients")
		    public List<RecipeDTO> getAllRecipes() {
		        return recipeService.getAllRecipesWithIngredients();
		    }
	  
		 @PostMapping("/add")
		    public void addRecipe(@RequestBody RecipeDTO recipeDTO) {
			  recipeService.addRecipe(recipeDTO);
		    }
}

