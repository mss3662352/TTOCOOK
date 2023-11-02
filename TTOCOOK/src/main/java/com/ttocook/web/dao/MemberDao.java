package com.ttocook.web.dao;

import com.ttocook.web.domain.MemberDto;

public interface MemberDao {

	MemberDto select(String id) throws Exception;

	int insert(MemberDto dto) throws Exception;

	int update(MemberDto dto) throws Exception;

	int delete(String id, String pw) throws Exception;

	int deleteAll() throws Exception ;

	int count() throws Exception;

	int deleteForAdmin() throws Exception;
	
	int idCheck(String id) throws Exception;
	
	int nickCheck(String nickname) throws Exception;

	MemberDto login(MemberDto dto) throws Exception;
}