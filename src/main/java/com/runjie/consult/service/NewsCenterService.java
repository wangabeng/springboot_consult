package com.runjie.consult.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.runjie.consult.dto.NewsCenterDTO;


@Service
@Transactional
public interface NewsCenterService {
	// 创建新闻
	NewsCenterDTO create(NewsCenterDTO newsCenterDTO);
	
	// 分页查询
}
