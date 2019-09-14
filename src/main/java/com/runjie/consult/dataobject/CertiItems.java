package com.runjie.consult.dataobject;

import java.util.Date;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CertiItems {
	@Id
	private String certiId;
	private String certiName;
	private String certiMainpic;
	private String certiContent;
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd") 
	private Date createTime;
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd") 
	private Date updateTime;
}