package com.runjie.consult.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.runjie.consult.dataobject.NewsCenter;
import com.runjie.consult.dto.NewsCenterDTO;
import com.runjie.consult.repository.NewsCenterRepository;
import com.runjie.consult.service.NewsCenterService;

@Service
public class NewsCenterServiceImpl implements NewsCenterService {
	@Autowired
	private NewsCenterRepository repository;
	
	// 创建新闻
	@Override
	public NewsCenterDTO create(NewsCenterDTO newsCenterDTO) {
		NewsCenter newsCenter = new NewsCenter();
		BeanUtils.copyProperties(newsCenterDTO, newsCenter);
		
		repository.save(newsCenter);
		return newsCenterDTO;
	};
}
