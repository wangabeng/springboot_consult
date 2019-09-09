package com.runjie.consult.dataobject;

import java.util.Date;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	public String getCertiId() {
		return certiId;
	}
	public void setCertiId(String certiId) {
		this.certiId = certiId;
	}
	public String getCertiName() {
		return certiName;
	}
	public void setCertiName(String certiName) {
		this.certiName = certiName;
	}
	public String getCertiMainpic() {
		return certiMainpic;
	}
	public void setCertiMainpic(String certiMainpic) {
		this.certiMainpic = certiMainpic;
	}
	public String getCertiContent() {
		return certiContent;
	}
	public void setCertiContent(String certiContent) {
		this.certiContent = certiContent;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}