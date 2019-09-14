package com.runjie.consult.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.runjie.consult.dataobject.AdminUser;
import com.runjie.consult.dataobject.NewsCenter;
import com.runjie.consult.dto.NewsCenterDTO;

public interface NewsCenterRepository extends JpaRepository<NewsCenter, String> {
}
