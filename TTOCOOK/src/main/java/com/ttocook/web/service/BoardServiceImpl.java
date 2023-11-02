package com.ttocook.web.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ttocook.web.dao.BoardDao;
import com.ttocook.web.domain.BoardDto;
import com.ttocook.web.domain.SearchCondition;
import com.ttocook.web.util.FileUtils;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	
	@Override
	public int getCount() throws Exception {
	      return boardDao.count();
	  }

	@Override
	public int remove(Integer ckbno, String id) throws Exception {
	      return boardDao.delete(ckbno, id);
	  }

	@Override
	public int write(BoardDto boardDto) throws Exception{
	      return boardDao.insert(boardDto);
	  }

	@Override
	public List<BoardDto> getList() throws Exception {
	      return boardDao.selectAll();
	  }

	@Override
	public BoardDto read(Integer ckbno) throws Exception {
	      BoardDto boardDto = boardDao.select(ckbno);
	      boardDao.increaseViewCnt(ckbno);

	      return boardDto;
	  }

	//페이징할때 사용할 예정
	@Override
	public List<BoardDto> getPage(Map map) throws Exception {
	      return boardDao.selectPage(map);
	  }

	@Override
	public int modify(BoardDto boardDto) throws Exception {
	      return boardDao.update(boardDto);
	  }
	
	@Override
	public List<BoardDto> getSelectSearchPage(SearchCondition sc) throws Exception {
	      return boardDao.selectSearchPage(sc);
	  }
	@Override
    public int getSearchResultCnt(SearchCondition sc) throws Exception {
    	  return boardDao.searchResultCnt(sc);
    			
    }
	
}
