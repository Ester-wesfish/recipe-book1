package com.recipebook1.service;

import java.util.List;

import com.recipebook1.entity.Ingredient;

public interface IngredientService {
    List<Ingredient> getAllIngredients();
    void updateIngredientById(Long id, Ingredient ingredient);
}
