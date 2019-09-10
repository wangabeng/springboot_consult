package com.runjie.consult.utils;

import com.runjie.consult.VO.ResultVO;

public class ResultVOUtil {
	public static ResultVO success(Object data) {
		ResultVO resultVO = new ResultVO();
		resultVO.setCode("0");
		resultVO.setMessage("成功");
		resultVO.setData(data);
		return resultVO;
	}
	public static ResultVO success() {
		return success(null);
	}
	
	public static ResultVO error(String code , String message) {
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(code);
		resultVO.setMessage(message);
		return resultVO;
	}
}
