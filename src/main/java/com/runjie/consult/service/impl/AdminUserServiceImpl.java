package com.runjie.consult.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.runjie.consult.dataobject.AdminUser;
import com.runjie.consult.repository.AdminUserRepository;
import com.runjie.consult.service.AdminUserService;

@Service
public class AdminUserServiceImpl implements AdminUserService {
	@Autowired
	private AdminUserRepository repository;
	
	@Override
	public AdminUser create(AdminUser adminUser) {
		// TODO Auto-generated method stub
		return repository.save(adminUser);
	}

	@Override
	public AdminUser findOne(String userName) {
		// TODO Auto-generated method stub
		return repository.findByUserName(userName);
	}

}
