package com.runjie.consult.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.runjie.consult.dataobject.AdminUser;


public interface AdminUserRepository extends JpaRepository <AdminUser, String> {
	AdminUser findByUserName(String userName);
}
