package com.runjie.consult.enums;

public enum ResultEnum {
	USER_NOT_EXIST(1, "用户不存在"), 
	PASSWORD_ERROR(2, "密码错误");


	private Integer code;
	private String message;
	
	ResultEnum (Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
