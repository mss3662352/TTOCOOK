package com.ttocook.web.service;

import com.ttocook.web.domain.RecipeDto;

public interface RecipeService {
	
	int rcInsert(RecipeDto recipeDto) throws Exception;
	
}