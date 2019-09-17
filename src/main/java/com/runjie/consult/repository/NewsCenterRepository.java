package com.runjie.consult.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.runjie.consult.dataobject.AdminUser;
import com.runjie.consult.dataobject.NewsCenter;
import com.runjie.consult.dto.NewsCenterDTO;

public interface NewsCenterRepository extends JpaRepository<NewsCenter, String> {
	NewsCenter findByNewsId(String newsId);
	
	// 分页查询  查询条件可以再条件pageable中添加
	Page<NewsCenter> findAll(Pageable pageable);
	
	// 本例默认设置查询条件按照时间创建顺序 降序排列DESC
	// 查询上一条 默认从小到大
	// 参照https://bbs.csdn.net/topics/392301246?list=lz
	// @Query(nativeQuery = true, value = "select * from news_center t where t.news_id = ?1")
	// @Query("select t from news_center t where t.news_id = ?1")
	@Query(nativeQuery = true, value = "select * from news_center  where news_id = (select news_id from news_center where create_time > ?1 order by create_time asc limit 1)")
	NewsCenter findPre(Date createTime); //  Date createTime
	
	// 查询下一条
	@Query(nativeQuery = true, value = "select * from news_center  where news_id = (select news_id from news_center where create_time < ?1 order by create_time desc limit 1)")
	NewsCenter findNext(Date createTime); // String newsId
	
	// 删除一条数据
	@Query(value = "delete from news_center where news_id = ?1", nativeQuery = true)
	void deleteOne(String newsId);
	// @Query(value = "delete from bdsp_storm_manage where id=?1 ", nativeQuery = true)
	// @Modifying
	// public void deleteStormManageById(int id);
	
	// 修改文章内容
	
}
