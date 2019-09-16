package com.runjie.consult.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.runjie.consult.dataobject.NewsCenter;
import com.runjie.consult.dto.NewsCenterDTO;
import com.runjie.consult.repository.NewsCenterRepository;
import com.runjie.consult.service.NewsCenterService;

@Service
public class NewsCenterServiceImpl implements NewsCenterService {
	@Autowired
	private NewsCenterRepository repository;

	@Override
	public NewsCenter findByNewsId(String newsId) {
		// TODO Auto-generated method stub
		return repository.findByNewsId(newsId);
	};

	// 创建新闻
	@Override
	public NewsCenterDTO create(NewsCenterDTO newsCenterDTO) {
		NewsCenter newsCenter = new NewsCenter();
		BeanUtils.copyProperties(newsCenterDTO, newsCenter);

		repository.save(newsCenter);
		return newsCenterDTO;
	}

	// 分页查询 无条件
	@Override
	public Page<NewsCenter> findList(Pageable pageable) {
		Page<NewsCenter> newsCenterPage = repository.findAll(pageable);

		return newsCenterPage;

		/*
		 * Page<OrderMaster> orderMasterPage =
		 * orderMasterRepository.findByBuyerOpenid(buyerOpenid, pageable);
		 * List<OrderDTO> orderDTOList =
		 * OrderMasterToOrderDTOConverter.convert(orderMasterPage.getContent());
		 * Page<OrderDTO> orderDTOPage = new PageImpl<OrderDTO>(orderDTOList, pageable,
		 * orderMasterPage.getTotalElements()); return orderDTOPage;
		 */
	}

	@Override
	public NewsCenter findPreOne(String newsId) {
		// TODO Auto-generated method stub
		NewsCenter newsCenter = new NewsCenter();
		newsCenter = repository.findPre(repository.findByNewsId(newsId).getCreateTime());
		return newsCenter;
	}

	@Override
	public NewsCenter findNextOne(String newsId) {
		// TODO Auto-generated method stub
		NewsCenter newsCenter = new NewsCenter();
		newsCenter = repository.findNext(repository.findByNewsId(newsId).getCreateTime());
		return newsCenter;
	}

}
