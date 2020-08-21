package com.codeup.shearup.controllers;

import com.codeup.shearup.models.BarberDetail;
import com.codeup.shearup.models.User;
import com.codeup.shearup.models.UserWithRoles;
import com.codeup.shearup.repositories.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class UserController {
	private UserRepository users;
	private PasswordEncoder passwordEncoder;
	private BarberDetailRepository barberDetailDao;
//
	public UserController(UserRepository users, PasswordEncoder passwordEncoder, BarberDetailRepository barberDetailDao) {
		this.users = users;
		this.passwordEncoder = passwordEncoder;
		this.barberDetailDao = barberDetailDao;
	}
	
	@GetMapping("/sign-up")
	public String showSignupForm(Model model){
		model.addAttribute("user", new User());
		return "users/signup";
	}
	
	@PostMapping("/sign-up")
	public String saveUser(@ModelAttribute User user){

		//====this is for an ID
		String hash = passwordEncoder.encode(user.getPassword());
		user.setPassword(hash);
		users.save(user);
		authenticate(user);
		return "redirect:/";
	}

	private void authenticate(User user) {
		UserDetails userDetails = new UserWithRoles(user, Collections.emptyList());
		Authentication auth = new UsernamePasswordAuthenticationToken(
				userDetails,
				userDetails.getPassword(),
				userDetails.getAuthorities()
		);
		SecurityContext context = SecurityContextHolder.getContext();
		context.setAuthentication(auth);
	}
}
