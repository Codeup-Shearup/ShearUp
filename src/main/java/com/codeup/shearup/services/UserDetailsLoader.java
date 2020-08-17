package com.codeup.shearup.services;

import com.codeup.shearup.models.User;
import com.codeup.shearup.models.UserWithRoles;
import com.codeup.shearup.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
	private final UserRepository users;
	
	public UserDetailsLoader(UserRepository users) {
		this.users = users;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = users.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("No user found for " + username);
		}
		
		return new UserWithRoles(user);
	}
}
