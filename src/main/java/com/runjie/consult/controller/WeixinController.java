package com.runjie.consult.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.runjie.consult.VO.ResultVO;
import com.runjie.consult.dataobject.NewsCenter;
import com.runjie.consult.utils.ResultVOUtil;

import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;

@RestController
@RequestMapping("/weixin")
public class WeixinController {

	@GetMapping("/test")
	public WxJsapiSignature test() throws Exception { 
		WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
		config.setAppId("wx0da4e67530296351"); // 设置微信公众号的appid
		config.setSecret("1a397ecbc0b101c3b41276d1382bfafb"); // 设置微信公众号的app corpSecret
		// config.setToken("..."); // 设置微信公众号的token
		// config.setAesKey("..."); // 设置微信公众号的EncodingAESKey

		WxMpService wxService = new WxMpServiceImpl();
		wxService.setWxMpConfigStorage(config);
		// System.out.print("token你好:" + wxService.createJsapiSignature("http://nicedevelop.nat300.top/weixin/test"));
		return  wxService.createJsapiSignature("http://nicedevelop.nat300.top");
	}
	
	@GetMapping("/test2")
	public String test2() throws Exception { 

		return "nihao";
	}
}
