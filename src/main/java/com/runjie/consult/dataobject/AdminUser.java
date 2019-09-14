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
@Table(name="admin_user")
@DynamicUpdate
@Getter
@Setter
public class AdminUser {
	
	private String userId;
	@Id
	private String userName;
	private String userPassword;
	private String ecSalt;
	private String userPortrait;
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd") 
	private Date createTime;
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd") 
	private Date updateTime;	
}