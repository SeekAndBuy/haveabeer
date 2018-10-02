package com.seekandbuy.haveabeer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.seekandbuy.haveabeer.dao.UserDao;
import com.seekandbuy.haveabeer.domain.Address;
import com.seekandbuy.haveabeer.domain.User;
import com.seekandbuy.haveabeer.exceptions.UserNotFoundException;

@Service
public class UserService 
{
	
	@Autowired
	private UserDao userDao;
	
	
	
	public List<User> listar()
	{
		return userDao.findAll();  
	}
	 
	public Optional<User> findUser(Long id)
	{
		Optional<User> user = userDao.findById(id);
		
		if(user == null)
		{
			throw new UserNotFoundException("User can not be found");
		}
		
		return user;
	}
	
	public User userCreate(User user) 
	{
		user.setId(null); //Garantir que criaremos uma instância nova e não atualizaremos nenhuma
		Address address = user.getAddress();
		
		return userDao.save(user);	
	}
	
	public void deleteUser(Long id) 
	{
		try 
		{
			userDao.deleteById(id);
		}
		catch(EmptyResultDataAccessException e)
		{
			throw new UserNotFoundException("User can not be found");
		}
	}
	
	public void updateUser(User user)
	{
		verifyExistence(user);
		userDao.save(user);
	}
	
	//Semântica melhor, só verifica existência 
	public void verifyExistence(User user)
	{
		findUser(user.getId());
	}
}
