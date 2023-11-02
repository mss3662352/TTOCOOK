package com.ttocook.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ttocook.web.domain.BoardDto;
import com.ttocook.web.domain.SearchCondition;

public interface BoardService {

	int getCount() throws Exception;

	int remove(Integer ckbno, String ckbwriter) throws Exception;

	int write(BoardDto boardDto) throws Exception;

	List<BoardDto> getList() throws Exception;

	BoardDto read(Integer ckbno) throws Exception;

	//페이징할때 사용할 예정
	List<BoardDto> getPage(Map map) throws Exception;

	int modify(BoardDto boardDto) throws Exception;
	
	List<BoardDto> getSelectSearchPage(SearchCondition sc) throws Exception;
	
	int getSearchResultCnt(SearchCondition sc) throws Exception;
	

}
