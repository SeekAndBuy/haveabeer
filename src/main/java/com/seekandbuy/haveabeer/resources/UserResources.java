/*User Controller*/
package com.seekandbuy.haveabeer.resources;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seekandbuy.haveabeer.dao.UserDao;
import com.seekandbuy.haveabeer.domain.User;
import com.seekandbuy.haveabeer.exceptions.UserNotFoundException;

@RestController
@RequestMapping("/users")
public class UserResources {
	
	@Autowired
	private UserDao userDao;
	
	public UserResources(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//debug
	@RequestMapping(method = RequestMethod.GET)
	public List<User> ListUsers() {
		return userDao.findAll(); //Descomentar quando resolver o erro das dependencias
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void userCreate(@RequestBody User user) {
		//testar cada atributo e persistir 
		
		//Para persistir use o comando abaixo apos resolver o erro das dependencias em pom.xml
		userDao.save(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<User> findUser(@PathVariable("id") Long id) throws UserNotFoundException {
		
		//Verifica se o parametro passado é valido
		//se for deve-se buscar o usuari: utilizar o comando abaixo:

		Optional<User> user = userDao.findById(id);
		
		if(user == null)
		{
			throw new UserNotFoundException("User not found");
		}
		
		return user;
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") Long id) {
		//Igual o método anterior, porem substitui o médoto "findOne" pelo de baixo:
		userDao.deleteById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void upDateUser(@RequestBody User user, @PathVariable("id") Long id){
		//Tratar ID
		user.setId(id);
		userDao.save(user);
	}
	
}
