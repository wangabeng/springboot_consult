package com.runjie.consult.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.runjie.consult.dataobject.AdminUser;
import com.runjie.consult.dataobject.NewsCenter;
import com.runjie.consult.dto.NewsCenterDTO;

public interface NewsCenterRepository extends JpaRepository<NewsCenter, String> {
	// 分页查询 无条件
	Page<NewsCenter> findAll(Pageable pageable);
	
	// 查询上一条
	// 参照https://bbs.csdn.net/topics/392301246?list=lz
	// @Query(nativeQuery = true, value = "select * from news_center t where t.news_id = ?1")
	// @Query("select t from news_center t where t.news_id = ?1")
	@Query(nativeQuery = true, value = "select * from news_center  where news_id = (select news_id from news_center where news_id < ?1 order by news_id desc limit 1)")
	NewsCenter findPre(String newsId);
}
