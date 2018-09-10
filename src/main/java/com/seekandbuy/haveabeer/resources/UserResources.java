/*User Controller*/
package com.seekandbuy.haveabeer.resources;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.seekandbuy.haveabeer.dao.UserDao;
import com.seekandbuy.haveabeer.domain.User;

@RestController
@RequestMapping("/user")
public class UserResources {
	
	@Autowired
	//private UserDao userDao;
	
	//debug
	@RequestMapping(method = RequestMethod.GET)
	public List<User> ListUsers() {
		//return userDao.findAll(); Descomentar quando resolver o erro das dependencias
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void userCreate(@RequestBody User user) {
		//testar cada atributo e persistir 
		
		//Para persistir use o comando abaixo apos resolver o erro das dependencias em pom.xml
		//userDao.save(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public void findUser(@PathVariable("id") Long id) {
		
		//Verifica se o parametro passado é valido
		//se for deve-se buscar o usuari: utilizar o comando abaixo:

		//user = userDao.findOne(id);
		/*
		if(user = null)
		{
			throw new UserNotFoundException("User not found");
		}
		*/
		//return user;
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") Long id) {
		//Igual o método anterior, porem substitui o médoto "findOne" pelo de baixo:
		//userDao.delete(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void upDateUser(@RequestBody User user, @PathVariable("id") Long id){
		//Tratar ID
		user.setId(id);
		//userDao.save(user);
	}
	
}
