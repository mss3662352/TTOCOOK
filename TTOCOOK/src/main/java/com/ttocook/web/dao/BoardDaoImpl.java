package com.ttocook.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttocook.web.domain.BoardDto;
import com.ttocook.web.domain.SearchCondition;


@Repository
public class BoardDaoImpl implements BoardDao{

    @Autowired
    SqlSession session;

    String namespace="com.ttocook.web.dao.BoardMapper.";

    @Override
	public BoardDto select(int ckbno) throws Exception {
        return session.selectOne(namespace + "select", ckbno);
    }

    @Override
	public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }

    @Override
	public int insert(BoardDto dto) throws Exception {
        return session.insert(namespace+"insert", dto);
    }

    @Override
	public int update(BoardDto dto) throws Exception {
        return session.update(namespace+"update", dto);
    }


    @Override
	public int delete(Integer ckbno, String ckbwriter) throws Exception {
        Map map = new HashMap();
        map.put("ckbno", ckbno);
        map.put("ckbwriter", ckbwriter);
        return session.delete(namespace+"delete", map);
    }

    @Override
	public int deleteForAdmin(Integer ckbno) throws Exception {
        Map map = new HashMap();
        map.put("ckbno", ckbno);
        return session.delete(namespace+"deleteForAdmin", map);
    }
	
    @Override
	public int deleteAll() {
        return session.delete(namespace+"deleteAll");
    }


    @Override
	public List<BoardDto> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    }

    @Override
	public int increaseViewCnt(Integer ckbno) throws Exception {
        return session.update(namespace+"increaseViewCnt", ckbno);
    }
    
    @Override
    public List<BoardDto> selectPage(Map map) throws Exception {
    	return session.selectList(namespace + "selectPage", map);
    			
    }
  
    @Override
    public List<BoardDto> selectSearchPage(SearchCondition sc) throws Exception {
    	return session.selectList(namespace + "selectSearchPage", sc);
    			
    }
    @Override
    public int searchResultCnt(SearchCondition sc) throws Exception {
    	return session.selectOne(namespace + "searchResultCnt", sc);
    			
    }
    
}