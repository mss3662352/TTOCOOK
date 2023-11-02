package com.ttocook.web.dao;

import com.ttocook.web.domain.RecipeDto;

public interface RecipeDao {

	int insert(RecipeDto dto) throws Exception;
	
	
}