package com.ttocook.web.dao;

import java.util.List;
import java.util.Map;

import com.ttocook.web.domain.BoardDto;
import com.ttocook.web.domain.FrBoardDto;
import com.ttocook.web.domain.SearchCondition;

public interface FrBoardDao {

	FrBoardDto select(int frbno) throws Exception;

	int count() throws Exception;

	int insert(FrBoardDto frdto) throws Exception;

	int update(FrBoardDto frdto) throws Exception;

	int delete(Integer frbno, String frbwriter) throws Exception;

	int deleteForAdmin(Integer frbno) throws Exception;

	int deleteAll();

	List<FrBoardDto> selectAll() throws Exception;

	int increaseViewCnt(Integer frbno) throws Exception;
	
	List<FrBoardDto> selectPage(Map map) throws Exception;
	
	List<FrBoardDto> selectSearchPage(SearchCondition sc) throws Exception;
	
    int searchResultCnt(SearchCondition sc) throws Exception;

    
    
}