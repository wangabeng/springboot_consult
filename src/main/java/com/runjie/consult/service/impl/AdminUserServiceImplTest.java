package com.runjie.consult.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.util.DigestUtils;

import com.runjie.consult.dataobject.AdminUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminUserServiceImplTest {
	@Autowired
	private AdminUserServiceImpl adminUserService;

	@Test
	public void savUserTest() {
		AdminUser adminUser = new AdminUser();
		adminUser.setUserId("23214");
		adminUser.setUserName("abeng");
		adminUser.setUserPassword("123");
		adminUser.setEcSalt(DigestUtils.md5DigestAsHex("123".getBytes()));

		AdminUser result = adminUserService.create(adminUser);

		Assert.assertNotNull(result);
	}
	@Test
	public void findOneTest() {

		AdminUser result = adminUserService.findOne("abeng");

		Assert.assertNotNull(result);
	}
}
