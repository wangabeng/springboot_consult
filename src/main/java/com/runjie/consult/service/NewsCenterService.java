package com.runjie.consult.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.runjie.consult.dataobject.NewsCenter;
import com.runjie.consult.dto.NewsCenterDTO;


@Service
@Transactional
public interface NewsCenterService {
	// 创建新闻
	NewsCenterDTO create(NewsCenterDTO newsCenterDTO);
	
	// 分页查询 无条件
	Page<NewsCenter> findList(Pageable pageable);
	
	// 查询上一条
	NewsCenter findPreOne(String id);
}
