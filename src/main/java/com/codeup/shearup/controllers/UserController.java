package com.codeup.shearup.controllers;

import com.codeup.shearup.models.BarberDetail;
import com.codeup.shearup.models.User;
import com.codeup.shearup.models.UserWithRoles;
import com.codeup.shearup.repositories.UserRepository;
import com.codeup.shearup.repositories.BarberDetailRepository;
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
		String hash = passwordEncoder.encode(user.getPassword());
		user.setPassword(hash);
		users.save(user);
		if(user.isBarber()) {
			BarberDetail newBarberDetail = new BarberDetail();
			newBarberDetail.setUser(user);
			user.setBarberDetail(newBarberDetail);
			barberDetailDao.save(newBarberDetail);
		}
		authenticate(user); // programatically login the new user
		return "redirect:/"; // direct redirect upon login
	}
		//work from Brance
//		BarberDetail barberDetails = new BarberDetail(user.getId());
//		user.setBarberDetail(barberDetails);
//		barberDetailDao.save(barberDetails);
//		user = users.save(user);

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

	//========PLACE HOLDER FOR DASHBOARD FOR NOW TEMPORARY======//
	@GetMapping("/dashboard")
	public String dashboard() {
		User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//=====THIS REPRESENTS CURRENT USER THAT IS LOGGED IN GRABBING USER OBJECT==////
		//===== GETS USER OBJECT OF ASSOCIATED ID WITH USER THAT IS LOGGED IN=======///
		//==SUPPOSED TO BE USERDAO====//
		//BELOW IF STATEMENT SEND THEM TO DASHBOARD===//
		User user = users.getOne(sessionUser.getId());
		if (user.isBarber()) {
			return "redirect:/barber/profile/" + user.getBarberDetail().getId();
		}
		return "redirect:/";
	}
}
