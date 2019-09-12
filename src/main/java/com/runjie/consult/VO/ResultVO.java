package com.runjie.consult.VO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResultVO <T> {
	private Integer code;
	private String message;
	private T data;
}
