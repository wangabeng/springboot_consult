package com.runjie.consult.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.runjie.consult.dataobject.AdminUser;
import com.runjie.consult.dataobject.NewsCenter;
import com.runjie.consult.dto.NewsCenterDTO;

public interface NewsCenterRepository extends JpaRepository<NewsCenter, String> {
	// 分页查询 无条件
	Page<NewsCenter> findAll(Pageable pageable);
}
