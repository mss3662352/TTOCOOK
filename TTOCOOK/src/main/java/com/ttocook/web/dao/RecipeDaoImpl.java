package com.ttocook.web.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttocook.web.domain.RecipeDto;

@Repository
public class RecipeDaoImpl implements RecipeDao {
	
	@Autowired
	SqlSession session;
	
	String namespace = "com.ttocook.web.dao.RecipeMapper.";
	
	
	@Override
	public int insert(RecipeDto dto) throws Exception{
		return session.insert(namespace+"insert", dto);
	}


}
