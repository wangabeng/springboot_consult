package com.runjie.consult.dataobject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="service_items")
@DynamicUpdate
public class CertiSample {
	@Id
	private String sampleId;
	private String sampleName;
	private String sampleMainpic;
	private String sampleContent;
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd") 
	private Date createTime;
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd") 
	private Date updateTime;
	public String getSampleId() {
		return sampleId;
	}
	public void setSampleId(String sampleId) {
		this.sampleId = sampleId;
	}
	public String getSampleName() {
		return sampleName;
	}
	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}
	public String getSampleMainpic() {
		return sampleMainpic;
	}
	public void setSampleMainpic(String sampleMainpic) {
		this.sampleMainpic = sampleMainpic;
	}
	public String getSampleContent() {
		return sampleContent;
	}
	public void setSampleContent(String sampleContent) {
		this.sampleContent = sampleContent;
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