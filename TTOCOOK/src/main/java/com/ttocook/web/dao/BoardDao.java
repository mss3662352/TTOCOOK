package com.ttocook.web.dao;

import java.util.List;
import java.util.Map;

import com.ttocook.web.domain.BoardDto;
import com.ttocook.web.domain.SearchCondition;

public interface BoardDao {

	BoardDto select(int ckbno) throws Exception;

	int count() throws Exception;

	int insert(BoardDto dto) throws Exception;

	int update(BoardDto dto) throws Exception;

	int delete(Integer ckbno, String ckbwriter) throws Exception;

	int deleteForAdmin(Integer ckbno) throws Exception;

	int deleteAll();

	List<BoardDto> selectAll() throws Exception;

	int increaseViewCnt(Integer ckbno) throws Exception;
	
	List<BoardDto> selectPage(Map map) throws Exception;
	
	List<BoardDto> selectSearchPage(SearchCondition sc) throws Exception;
	
    int searchResultCnt(SearchCondition sc) throws Exception;

    
    
}