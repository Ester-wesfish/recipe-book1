package com.recipebook1.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.recipebook1.entity.Recipe;


@Repository
public interface RecipeRepository  extends JpaRepository<Recipe, Long> {
	
	
}

