package com.runjie.consult.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import com.runjie.consult.dataobject.AdminUser;
import com.runjie.consult.dataobject.NewsCenter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsCenterServiceImplTest {
	@Autowired
	private NewsCenterServiceImpl newsCenterService;

	@Test
	public void findAllnewsCenter () {
		Pageable pageable  = PageRequest.of(0, 2);
		Page<NewsCenter> newsCenterPage = newsCenterService.findList(pageable);
		Map<String, Object> map = new HashMap<>();
		map.put("结果", newsCenterPage);
		
		System.out.print(map.get("结果"));
		Assert.assertNotEquals(0, newsCenterPage.getTotalElements());
	}
	
	@Test
	public void findpreUser () {
		NewsCenter reuslt = newsCenterService.findPreOne("1568475648767913964");
		System.out.println(reuslt.getNewsId());
		Assert.assertNotEquals(0, reuslt);
	}
}
