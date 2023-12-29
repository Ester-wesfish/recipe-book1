package com.recipebook1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipebook1.entity.Ingredient;

@Repository
public interface IngredientRepository  extends JpaRepository<Ingredient, Long> {

}