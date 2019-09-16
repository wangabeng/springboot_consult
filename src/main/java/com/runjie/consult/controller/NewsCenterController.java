package com.runjie.consult.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.runjie.consult.VO.ResultVO;
import com.runjie.consult.dataobject.NewsCenter;
import com.runjie.consult.service.NewsCenterService;
import com.runjie.consult.utils.ResultVOUtil;

@RestController
@RequestMapping("/newscenter")
public class NewsCenterController {
	@Autowired
	private NewsCenterService newsCenterService;
	
	// 新闻列表
	@GetMapping("/lists")
	public ResultVO lists(@RequestParam (value = "curpage",  defaultValue="1") Integer curPage, 
			@RequestParam(value="pagesize",  defaultValue="3")Integer pageSize) {
		// Integer curPage = 0; // 第2页 
		// Integer PageSize = 4; // 页面容量
		// curPage从1开始 查询的时候 对于0 DESC降序
		Pageable pageable  = PageRequest.of(curPage - 1, pageSize, Sort.Direction.DESC, "createTime");
		Page<NewsCenter> newsCenterPage = newsCenterService.findList(pageable);
		Map<String, Object> map = new HashMap<>();
		map.put("curPage", curPage); // 当前第几页 curpage = 0 是第1页
		map.put("amountSetting", newsCenterPage.getSize()); // 查询设定的页面容量
		map.put("amountReal", newsCenterPage.getNumber()); // 查询本页实际的数量
		map.put("ifPrevious", newsCenterPage.hasPrevious()); // 是否有上一页
		map.put("ifNext", newsCenterPage.hasNext()); // 是否有下一页
		
		map.put("TotalPages", newsCenterPage.getTotalPages());		
		map.put("content", newsCenterPage.getContent());
		
		return ResultVOUtil.success(map);
	}
	
	// 新闻列表
	@GetMapping("/detail")
	public ResultVO detail(@RequestParam (value = "newsId") String newsId) {
		// 找到当前newsId的详情 找到上一条 下一条是否存在
		NewsCenter curNews = newsCenterService.findByNewsId(newsId);
		NewsCenter preNews = newsCenterService.findPreOne(newsId);
		NewsCenter nextNews = newsCenterService.findNextOne(newsId);
		Map<String, Object> map = new HashMap<>();
		map.put("cur", curNews);
		map.put("pre", preNews);
		map.put("next", nextNews);
		
		return ResultVOUtil.success(map);
	}
}
