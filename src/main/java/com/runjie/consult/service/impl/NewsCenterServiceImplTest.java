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
import org.springframework.data.domain.Sort;
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
		// 分页设定 
		// Pageable pageable  = PageRequest.of(0, 2);
		Pageable pageable  = PageRequest.of(0, 2, Sort.Direction.DESC, "createTime");
		Page<NewsCenter> newsCenterPage = newsCenterService.findList(pageable);
		Map<String, Object> map = new HashMap<>();
		map.put("结果", newsCenterPage);
		
		System.out.print(map.get("结果"));
		Assert.assertNotEquals(0, newsCenterPage.getTotalElements());
	}
	
	//	上一条
	@Test
	public void findpreUser () {
		NewsCenter reuslt = newsCenterService.findPreOne("1568476549285399998");
		System.out.println(reuslt.getNewsId());
		Assert.assertNotEquals(0, reuslt);
	}
	
	//	下一条
	@Test
	public void findNextOne () {
		NewsCenter reuslt = newsCenterService.findNextOne("1568476549285399998");
		System.out.println(reuslt.getNewsId());
		Assert.assertNotEquals(0, reuslt);
	}
	
	// 删除一条
	@Test
	public void deleteOneTest () {
		newsCenterService.deleteOne("3244444444");
		System.out.println("删除成功");
	}
	
	// 更新一条
	@Test
	public void updateTest () {
		 newsCenterService.updateOne("<p>3再次更新更新的内容</p>", "1568638181852220187");
		System.out.println("更新成功");
		// Assert.assertNotEquals(0, result);
	}
}
