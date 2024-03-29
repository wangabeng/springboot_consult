package com.runjie.consult.service;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.runjie.consult.dataobject.NewsCenter;
import com.runjie.consult.dto.NewsCenterDTO;

@Service
@Transactional
public interface NewsCenterService {
	// 正常查询 按newsId查询
	NewsCenter findByNewsId(String newsId);

	// 创建新闻
	NewsCenterDTO create(NewsCenterDTO newsCenterDTO);

	// 分页查询 无条件
	Page<NewsCenter> findList(Pageable pageable);

	// 查询上一条
	NewsCenter findPreOne(String newsId);

	// 查询下一条
	NewsCenter findNextOne(String newsId);
	
	// 根据id删除一条  不可以返回boolean类型
	void deleteOne(String newsId);
	
	// 更新一条数据
	void updateOne(String content, String newsId);
}
