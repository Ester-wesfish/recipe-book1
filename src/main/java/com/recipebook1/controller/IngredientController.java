package com.recipebook1.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipebook1.entity.Ingredient;
import com.recipebook1.service.IngredientService;




@RestController
@RequestMapping("/ingredient")
public class IngredientController {

	  @Autowired
	    private IngredientService ingredientService;

	    @GetMapping
	    public List<Ingredient> getRecipe() {
	        return ingredientService.getAllIngredients();
	    }
	    
	    @PutMapping("/update/{id}")
	    public void updateIngredient(@PathVariable("id") Long id, @RequestBody Ingredient updatedIngredient) {
	    	ingredientService.updateIngredientById(id, updatedIngredient);
	    }
	    
}


