package com.runjie.consult.ConsultExceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import com.runjie.consult.VO.ResultVO;
import com.runjie.consult.exception.ConsultException;
import com.runjie.consult.utils.ResultVOUtil;

@ControllerAdvice
public class ConsultExceptionHandler {
	@ExceptionHandler(value=ConsultException.class)
	@ResponseBody
	public ResultVO handlerConsultException (ConsultException e) {
		System.out.print("执行异常");
		return ResultVOUtil.error(e.getCode(), e.getMessage());
	}
}
