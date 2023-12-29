package com.recipebook1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.recipebook1.entity.Ingredient;
import com.recipebook1.exception.ResourceNotFoundException;
import com.recipebook1.repository.IngredientRepository;

@Service
public class IngredientServiceImpl implements IngredientService {

	 private static final Logger logger = LoggerFactory.getLogger(IngredientService.class);

	 @Autowired
	    private IngredientRepository ingredientRepository;

	    @Override
	    public List<Ingredient> getAllIngredients() {
	        return ingredientRepository.findAll();
	    }

	    @Override
	    public void updateIngredientById(Long id, Ingredient updatedIngredient) {
	        Optional<Ingredient> optionalingredient = ingredientRepository.findById(id);
	        if (optionalingredient.isPresent()) {
	        	Ingredient ingredient = optionalingredient.get();
	        	ingredient.setIngredientName(updatedIngredient.getIngredientName());
	        	ingredient.setPrice(updatedIngredient.getPrice());
	        	ingredientRepository.save(ingredient);

	            logger.info("Ingredient with ID {} updated successfully", id);
	        } else {
	        	throw new ResourceNotFoundException("Ingredient not found with id " + id);
	        }
	        
	    }
	   
}
