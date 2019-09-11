package com.runjie.consult.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	// 管理员登录
	@PostMapping(value= "/login")
	public AdminUserVO findUser(HttpServletRequest request) {
	
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.print(userName + password);
		
		AdminUserVO adminUserVO = new AdminUserVO();
		BeanUtils.copyProperties(adminService.findOne("abeng"), adminUserVO);
		log.info("adminUserVO:{} ", adminUserVO.getUserName());
		
		
		return adminUserVO;
	}
}
