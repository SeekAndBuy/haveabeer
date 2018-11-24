package com.seekandbuy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.seekandbuy.domain.Address;
import com.seekandbuy.domain.Product;

@CrossOrigin(origins="http://localhost:4200")
@Repository
public interface AddressDAO extends GenericDao, JpaRepository<Address, Long>
{

}
