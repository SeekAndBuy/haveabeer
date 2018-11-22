package com.seekandbuy.haveabeer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.seekandbuy.haveabeer.domain.Product;

@CrossOrigin(origins="http://localhost:4200")
@Repository
public interface ProductDao extends GenericDao, JpaRepository<Product, Long>
{
	@Query("SELECT p FROM Product p WHERE USERID(p.Id) = USERID(:userId)")
	public List<Product> getPromotionByUserId(@Param("userId") Long id);
}
