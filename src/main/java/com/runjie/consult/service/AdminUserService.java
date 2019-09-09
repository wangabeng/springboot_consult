package com.runjie.consult.service;

import com.runjie.consult.dataobject.AdminUser;

public interface AdminUserService {
	// 创建用户
	AdminUser create(AdminUser adminUser);
	
	// 查找用户
	AdminUser findOne(String userName);
}
