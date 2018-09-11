package com.seekandbuy.haveabeer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seekandbuy.haveabeer.domain.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{

}
