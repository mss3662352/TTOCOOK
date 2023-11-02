package com.ttocook.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttocook.web.dao.RcContentDao;
import com.ttocook.web.domain.RcContentDto;

@Service
public class RcContentServiceImpl implements RcContentService {
	
	@Autowired
	RcContentDao rccontentDao;
	
	@Override
	public int view(Integer rcno, Integer step) throws Exception{
		return rccontentDao.view(rcno, step);
	}
	
	@Override
	public int insert(RcContentDto dto) throws Exception{
		return rccontentDao.insert(dto);
	}
}
