package com.seekandbuy.haveabeer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository; 

import com.seekandbuy.haveabeer.domain.Promotion;

@Repository
public interface PromotionDao extends JpaRepository<Promotion, Long>
{
	@Query("SELECT p FROM Promotion p WHERE USERID(p.Id) = USERID(:userId)")
	public List<Promotion> getPromotionByUserId(@Param("userId") Long id);
}
