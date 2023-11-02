package com.ttocook.web.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ttocook.web.dao.BoardDao;
import com.ttocook.web.dao.FrBoardDao;
import com.ttocook.web.domain.BoardDto;
import com.ttocook.web.domain.FrBoardDto;
import com.ttocook.web.domain.SearchCondition;
import com.ttocook.web.util.FileUtils;

@Service
public class FrBoardServiceImpl implements FrBoardService {
	
	@Autowired
	FrBoardDao frboardDao;
	
	
	@Override
	public int getCount() throws Exception {
	      return frboardDao.count();
	  }

	@Override
	public int remove(Integer frbno, String id) throws Exception {
	      return frboardDao.delete(frbno, id);
	  }

	@Override
	public int write(FrBoardDto frboardDto) throws Exception{
	      return frboardDao.insert(frboardDto);
	  }

	@Override
	public List<FrBoardDto> getList() throws Exception {
	      return frboardDao.selectAll();
	  }

	@Override
	public FrBoardDto read(Integer frbno) throws Exception {
	      FrBoardDto frboardDto = frboardDao.select(frbno);
	     frboardDao.increaseViewCnt(frbno);

	      return frboardDto;
	  }

	//페이징할때 사용할 예정
	@Override
	public List<FrBoardDto> getPage(Map map) throws Exception {
	      return frboardDao.selectPage(map);
	  }

	@Override
	public int modify(FrBoardDto frboardDto) throws Exception {
	      return frboardDao.update(frboardDto);
	  }
	
	@Override
	public List<FrBoardDto> getSelectSearchPage(SearchCondition sc) throws Exception {
	      return frboardDao.selectSearchPage(sc);
	  }
	@Override
    public int getSearchResultCnt(SearchCondition sc) throws Exception {
    	  return frboardDao.searchResultCnt(sc);
    			
    }
	
}
