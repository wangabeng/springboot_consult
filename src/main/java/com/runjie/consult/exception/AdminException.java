package com.runjie.consult.exception;

import com.runjie.consult.enums.ResultEnum;

public class AdminException extends RuntimeException {
	private Integer code;

	public AdminException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}

	public AdminException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
