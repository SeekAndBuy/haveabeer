/*User Controller*/
package com.seekandbuy.haveabeer.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.seekandbuy.haveabeer.auth.UserAuthenticationService;
import com.seekandbuy.haveabeer.domain.User;
import com.seekandbuy.haveabeer.exceptions.UserNotFoundException;
import com.seekandbuy.haveabeer.services.UserService;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults; 

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/public/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class UserResources 
{	
	@NonNull
	UserAuthenticationService authentication;
	@Autowired
	private UserService userService;
	
	public UserResources(UserService userService) 
	{
		this.userService = userService;
	}
		
	@PostMapping("/register")
	String register( @RequestParam("username") final String username, @RequestParam("password") final String password) 
	{
		User user = new User(username, password);
		userService.userCreate(user);	   

	    return login(username, password);
	}

	@PostMapping("/login") 
	String login( @RequestParam("username") final String username, @RequestParam("password") final String password) 
	{
		return authentication.login(username, password).orElseThrow(() -> new RuntimeException("invalid login and/or password"));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> ListUsers() 
	{
		return ResponseEntity.status(HttpStatus.OK).body(userService.list());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> userCreate(@RequestBody User user) 
	{
		user = userService.userCreate(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<User>> findUser(@PathVariable("id") Long id)
	{
		Optional<User> user = null;
		try
		{
			user = userService.findUser(id);
		}catch(UserNotFoundException e)
		{
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) 
	{ 
		try
		{
			userService.deleteUser(id);
		}
		catch(UserNotFoundException e)
		{
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateUser(@RequestBody User user, @PathVariable("id") Long id)
	{
		user.setId(id); // Garantir que o que vai ser atualizado é o que está vindo na URI
		try
		{
			userService.updateUser(user);
		}
		catch(UserNotFoundException e)
		{
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}
	
}
