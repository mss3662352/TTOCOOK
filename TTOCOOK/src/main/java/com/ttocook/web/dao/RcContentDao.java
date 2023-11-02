package com.ttocook.web.dao;

import com.ttocook.web.domain.RcContentDto;

public interface RcContentDao {

	int view(Integer rcno, Integer step) throws Exception;
	
	int insert(RcContentDto dto) throws Exception;
}