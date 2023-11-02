package com.ttocook.web.service;

import com.ttocook.web.domain.RcContentDto;

public interface RcContentService {

	int view(Integer rcno, Integer step) throws Exception;
	
	int insert(RcContentDto dto) throws Exception;
}