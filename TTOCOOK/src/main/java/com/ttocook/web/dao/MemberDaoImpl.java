package com.ttocook.web.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttocook.web.domain.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	SqlSession session;
	
	String namespace = "com.ttocook.web.dao.MemberMapper.";
	
	@Override
	public MemberDto select(String id) throws Exception{
		return session.selectOne(namespace + "select", id);
	}
	
	@Override
	public int insert(MemberDto dto) throws Exception{
		return session.insert(namespace+"insert", dto);
	}
	
	@Override
	public int update(MemberDto dto) throws Exception {
        return session.update(namespace+"update", dto);
    }
	@Override
	public int delete(String id, String pw) throws Exception {
        Map map = new HashMap();
        map.put("id", id);
        map.put("pw", pw);
        return session.delete(namespace+"delete", map);
    }
	@Override
	public int deleteAll() throws Exception{
        return session.delete(namespace+"deleteAll");
    }
	@Override
	public int deleteForAdmin() throws Exception{
        return session.delete(namespace+"deleteForAdmin");

	}
	@Override
	public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }

	@Override
	public int idCheck(String id) throws Exception {
		return session.selectOne(namespace+"idCheck", id);
	}
	@Override
	public int nickCheck(String nickname) throws Exception {
		return session.selectOne(namespace+"nickCheck", nickname);
	}
	@Override
	public MemberDto login(MemberDto dto) throws Exception{
		return session.selectOne(namespace+"login", dto);
	}
	
}
