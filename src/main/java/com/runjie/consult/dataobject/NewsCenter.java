package com.runjie.consult.dataobject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="news_center")
@DynamicUpdate
@Getter
@Setter
public class NewsCenter {
	@Id
	private String newsId;
	private String newsTitle;
	private String newsAuthor;
	private String newsContent;
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd") 
	private Date createTime;
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd") 
	private Date updateTime;
}