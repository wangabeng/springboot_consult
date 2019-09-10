package com.runjie.consult.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.runjie.consult.VO.AdminUserVO;
import com.runjie.consult.dataobject.AdminUser;
import com.runjie.consult.service.AdminUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin")
@Slf4j
public class LoginController {
	@Autowired
	private AdminUserService adminService;

	// 创建订单
	@GetMapping("/login")
	public AdminUserVO findUser() {
		System.out.print("LOGIN");
		AdminUserVO adminUserVO = new AdminUserVO();
		BeanUtils.copyProperties(adminService.findOne("abeng"), adminUserVO);
		log.info("adminUserVO:{} ", adminUserVO.getUserName());
		
		return adminUserVO;
	}
}
