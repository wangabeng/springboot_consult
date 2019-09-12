package com.runjie.consult.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.runjie.consult.VO.AdminUserVO;
import com.runjie.consult.VO.ResultVO;
import com.runjie.consult.dataobject.AdminUser;
import com.runjie.consult.enums.ResultEnum;
import com.runjie.consult.exception.ConsultException;
import com.runjie.consult.service.AdminUserService;
import com.runjie.consult.utils.MD5Util;
import com.runjie.consult.utils.ResultVOUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin")
@Slf4j
public class LoginController {
	@Autowired
	private AdminUserService adminService;

	// 管理员登录
	@PostMapping(value = "/login")
	public ResultVO findUser(@RequestBody Map<String, Object> map, HttpServletRequest request) {
		HttpSession sessoin = request.getSession();//这就是session的创建
		log.info("首先查看session ： sessionId：{}", sessoin.getAttribute("sessionId"));
		// 1 获取params值 Map格式
		Map paramMap = (Map) map.get("params");
		// 2 获取键值 比如键是"userName"

		String userName = paramMap.get("userName").toString(); // 前端用户名
		String passWord = paramMap.get("password").toString(); // 前端密码
		String ecSalt = MD5Util.MD5(passWord); // 加盐密码

		AdminUser adminUser = new AdminUser();

		// 查询
		try {
			adminUser = adminService.findOne(userName);
		} catch (Exception e) {
			// 数据库查询错误
			throw new ConsultException(ResultEnum.DATABASE_ERROR);
		}				
		
		// log.info("adminUser:{} ", adminUser);
		if (StringUtils.isEmpty(adminUser)) {
			// 用户为null
			log.info("用户查询异常 用户：{} 不存在", userName);
			throw new ConsultException(ResultEnum.USER_NOT_EXIST);
		}
		
		// 用户密码错误
		if (!adminUser.getEcSalt().equals(ecSalt)) {
			log.info("用户：{} 密码错误", userName);
			throw new ConsultException(ResultEnum.PASSWORD_ERROR);
		}
		
		// 复制vo
		AdminUserVO adminUserVO = new AdminUserVO();
		BeanUtils.copyProperties(adminUser, adminUserVO);
		
		// 写入session
		
		log.info("sessionId：{}", sessoin.getAttribute("sessionId"));
		sessoin.setAttribute("sessionId",adminUserVO.getUserName());
		
		log.info("after sessionId：{}", sessoin.getAttribute("sessionId"));
		
		
		return ResultVOUtil.success(adminUserVO);
	}
	
	// 管理员登录
	@GetMapping(value = "/test")
	public void testSession (HttpServletRequest request) {
		HttpSession sessoin = request.getSession();
		System.out.println("设置前："+ sessoin.getAttribute("sessionId"));
		sessoin.setAttribute("sessionId","beb");
		System.out.println("设置后："+ sessoin.getAttribute("sessionId"));
	}
}
