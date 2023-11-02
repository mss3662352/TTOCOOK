package com.ttocook.web.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttocook.web.domain.RcContentDto;

@Repository
public class RcContentDaoImpl implements RcContentDao {
	
	@Autowired
	SqlSession session;
	
	String namespace = "com.ttocook.web.dao.RcContentMapper.";
	
	@Override
	public int view(Integer rcno,Integer step) throws Exception{
		Map map = new HashMap();
        map.put("rcno", rcno);
        map.put("step", step);
        return session.selectOne(namespace+"view", map);
	}
	@Override
	public int insert(RcContentDto dto) throws Exception{
		return session.selectOne(namespace+"insert", dto);
	}
}
