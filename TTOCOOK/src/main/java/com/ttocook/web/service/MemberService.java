package com.ttocook.web.service;


import com.ttocook.web.domain.MemberDto;

public interface MemberService {

	MemberDto read(String id) throws Exception;

	int register(MemberDto memberDto) throws Exception;

	int modify(MemberDto memberDto) throws Exception;

	int getCount() throws Exception;

	int withdraw(String id, String pw) throws Exception;
	
	int idCheck(String id) throws Exception;
	
	int nickCheck(String nickname) throws Exception;
	
	MemberDto login(MemberDto dto) throws Exception;
	
	
}