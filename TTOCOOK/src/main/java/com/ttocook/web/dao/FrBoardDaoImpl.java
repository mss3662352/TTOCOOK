package com.ttocook.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttocook.web.domain.FrBoardDto;
import com.ttocook.web.domain.SearchCondition;


@Repository
public class FrBoardDaoImpl implements FrBoardDao{

    @Autowired
    SqlSession session;

    String namespace="com.ttocook.web.dao.FrBoardMapper.";

    @Override
	public FrBoardDto select(int frbno) throws Exception {
        return session.selectOne(namespace + "select", frbno);
    }

    @Override
	public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }

    @Override
	public int insert(FrBoardDto frdto) throws Exception {
        return session.insert(namespace+"insert", frdto);
    }

    @Override
	public int update(FrBoardDto frdto) throws Exception {
        return session.update(namespace+"update", frdto);
    }


    @Override
	public int delete(Integer frbno, String frbwriter) throws Exception {
        Map map = new HashMap();
        map.put("frbno", frbno);
        map.put("frbwriter", frbwriter);
        return session.delete(namespace+"delete", map);
    }

    @Override
	public int deleteForAdmin(Integer frbno) throws Exception {
        Map map = new HashMap();
        map.put("frbno", frbno);
        return session.delete(namespace+"deleteForAdmin", map);
    }
	
    @Override
	public int deleteAll() {
        return session.delete(namespace+"deleteAll");
    }


    @Override
	public List<FrBoardDto> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    }

    @Override
	public int increaseViewCnt(Integer frbno) throws Exception {
        return session.update(namespace+"increaseViewCnt", frbno);
    }
    
    @Override
    public List<FrBoardDto> selectPage(Map map) throws Exception {
    	return session.selectList(namespace + "selectPage", map);
    			
    }
  
    @Override
    public List<FrBoardDto> selectSearchPage(SearchCondition sc) throws Exception {
    	return session.selectList(namespace + "selectSearchPage", sc);
    			
    }
    @Override
    public int searchResultCnt(SearchCondition sc) throws Exception {
    	return session.selectOne(namespace + "searchResultCnt", sc);
    			
    }
    
}