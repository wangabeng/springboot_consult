package com.runjie.consult.repository;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.runjie.consult.LogerTest2;
import com.runjie.consult.dataobject.AdminUser;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AdminUserRepositoryTest {
	@Autowired
	private AdminUserRepository repository;

	@Test
	public void findTest() {
		AdminUser result  = new AdminUser();
		result = repository.findByUserName("zhoufang");
		log.info("result:{}", result.getUserPassword());

		Assert.assertNotNull(result);
	}
}