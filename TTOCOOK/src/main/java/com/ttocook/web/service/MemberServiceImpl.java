package com.ttocook.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttocook.web.dao.MemberDao;
import com.ttocook.web.domain.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	@Override
	public MemberDto read(String id) throws Exception{
		MemberDto memberDto = memberDao.select(id);
		
		return memberDto;
	}
	@Override
	public int register(MemberDto memberDto) throws Exception {
		return memberDao.insert(memberDto);
	}
	@Override
	public int modify(MemberDto memberDto) throws Exception{
		return memberDao.update(memberDto);
	}
	@Override
	public int getCount() throws Exception{
		return memberDao.count();
	}
	
	@Override
	public int withdraw(String id, String pw) throws Exception{
		return memberDao.delete(id, pw);
	}
	@Override
	public int idCheck(String id) throws Exception {
		return memberDao.idCheck(id);
	}
	@Override
	public int nickCheck(String nickname) throws Exception {
		return memberDao.nickCheck(nickname);
	}
	@Override
	public MemberDto login(MemberDto dto) throws Exception {
		return memberDao.login(dto);
	}
}
