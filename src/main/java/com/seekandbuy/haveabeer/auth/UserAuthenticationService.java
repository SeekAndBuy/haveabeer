package com.seekandbuy.haveabeer.auth;

import java.util.Optional;

import com.seekandbuy.haveabeer.domain.User;

public interface UserAuthenticationService 
{
	Optional<String> login(String username, String password);

	Optional<User> findByToken(String token);

	void logout(User user);
}