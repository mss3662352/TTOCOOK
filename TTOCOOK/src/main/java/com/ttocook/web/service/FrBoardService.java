package com.ttocook.web.service;

import java.util.List;
import java.util.Map;


import com.ttocook.web.domain.BoardDto;
import com.ttocook.web.domain.FrBoardDto;
import com.ttocook.web.domain.SearchCondition;

public interface FrBoardService {

	int getCount() throws Exception;

	int remove(Integer frbno, String frbwriter) throws Exception;

	int write(FrBoardDto frboardDto) throws Exception;

	List<FrBoardDto> getList() throws Exception;

	FrBoardDto read(Integer frbno) throws Exception;

	//페이징할때 사용할 예정
	List<FrBoardDto> getPage(Map map) throws Exception;

	int modify(FrBoardDto frboardDto) throws Exception;
	
	List<FrBoardDto> getSelectSearchPage(SearchCondition sc) throws Exception;
	
	int getSearchResultCnt(SearchCondition sc) throws Exception;
	

}
