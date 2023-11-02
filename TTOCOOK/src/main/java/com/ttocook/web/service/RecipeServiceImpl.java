package com.ttocook.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttocook.web.dao.RecipeDao;
import com.ttocook.web.domain.RecipeDto;

@Service
public class RecipeServiceImpl implements RecipeService {
	
	@Autowired
	RecipeDao recipeDao;
	
	@Override
	public int rcInsert(RecipeDto recipeDto) throws Exception{
		return recipeDao.insert(recipeDto);
	}
	
}
