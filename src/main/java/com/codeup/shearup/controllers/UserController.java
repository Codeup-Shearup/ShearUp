package com.codeup.shearup.controllers;

import com.codeup.shearup.models.*;
import com.codeup.shearup.repositories.ImageRepository;
import com.codeup.shearup.repositories.ReviewRepository;
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
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class UserController {
	private UserRepository users;
	private PasswordEncoder passwordEncoder;
	private BarberDetailRepository barberDetailDao;
	private ReviewRepository reviewsDao;
	private ImageRepository imagesDao;
//
	public UserController(UserRepository users, PasswordEncoder passwordEncoder,
	                      BarberDetailRepository barberDetailDao, ReviewRepository reviewsDao, ImageRepository imagesDao) {
		this.users = users;
		this.passwordEncoder = passwordEncoder;
		this.barberDetailDao = barberDetailDao;
		this.reviewsDao = reviewsDao;
		this.imagesDao = imagesDao;
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
		//======THIS CODE WAS CREATING AN EXTRA BARBER DETAIL
		// DERAILING THE BARBER-DETAIL FORMS/LOCATION=====//
//		if(user.isBarber()) {
//			BarberDetail newBarberDetail = new BarberDetail();
//			newBarberDetail.setUser(user);
//			user.setBarberDetail(newBarberDetail);
//			barberDetailDao.save(newBarberDetail);
//		}
//		authenticate(user); // programatically login the new user
		return "redirect:/login"; // direct redirect upon login
	}
		//work from Brance
//		BarberDetail barberDetails = new BarberDetail(user.getId());
//		user.setBarberDetail(barberDetails);
//		barberDetailDao.save(barberDetails);
//		user = users.save(user);

//	private void authenticate(User user) {
//		UserDetails userDetails = new UserWithRoles(user, Collections.emptyList());
//		Authentication auth = new UsernamePasswordAuthenticationToken(
//				userDetails,
//				userDetails.getPassword(),
//				userDetails.getAuthorities()
//		);
//		SecurityContext context = SecurityContextHolder.getContext();
//		context.setAuthentication(auth);
//	}

	// this will redirect differently for barbers and clients
	@GetMapping("/dashboard")
	public String loginGateway(Model model) {
		User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//=====THIS REPRESENTS CURRENT USER THAT IS LOGGED IN GRABBING USER OBJECT==////
		//===== GETS USER OBJECT OF ASSOCIATED ID WITH USER THAT IS LOGGED IN=======///
		//==SUPPOSED TO BE USERDAO====//
		//BELOW IF STATEMENT SEND THEM TO DASHBOARD===//
		User user = users.getOne(sessionUser.getId());
		List<Image> myImage = imagesDao.findAll();
		model.addAttribute("images", myImage);

//		(barberDetailDao.getOne(Long.parseLong(user.getBarberDetail().toString())).getBio() == null))
		if (user.isBarber() && (user.getBarberDetail() == null)) {
			return "redirect:barber/barber-details/bio";
		}
		else if (user.isBarber()) {
			return "redirect:barber/profile";
		}
		return "redirect:/profile";
	}
	
	@GetMapping("/profile")
	public String userProfile(Model model) {
		User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = users.getOne(sessionUser.getId());
		List<Review> reviews = reviewsDao.findAllReviewsByAuthor(user.getId());
		List<Image> myImage = imagesDao.findAll();
		model.addAttribute("user", user);
		model.addAttribute("reviews", reviews);
		model.addAttribute("images", myImage);
		if (user.isBarber()) {
			return "redirect:barber/profile";
		}
		return "users/user-profile";
	}
	
	@GetMapping("/profile/edit/{id}")
	public String editProfile(@PathVariable long id, Model model) {
		User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		User user = users.getOne(sessionUser.getId());
		model.addAttribute("user", sessionUser);
		return "users/edit-profile";
	}
	
	@PostMapping("/profile/edit/{id}")
	public String update(@PathVariable long id, @ModelAttribute User user, @RequestParam String imageUpload) {
//		User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User currentUser = users.findById(id);
		User userz = users.getOne(currentUser.getId());
		System.out.println(imageUpload);
		Image img = new Image();
		if (imageUpload != null && !imageUpload.isEmpty()){
			System.out.println("imageUpload");
			img.setFilestackUrl(imageUpload);
			img.setUser(user);
		}

		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setUsername(user.getUsername());
		currentUser.setEmail(user.getEmail());
		if (imageUpload != null && !imageUpload.isEmpty()){
			imagesDao.save(img);
//			currentUser.setImages(img);
		} else {
			currentUser.setImages(user.getImages());
		}
//		currentUser.setImages(user.getImages());
//		String hash = passwordEncoder.encode(user.getPassword());
//		currentUser.setPassword(hash);
		users.save(currentUser);
//		imagesDao.save(img);
		return "redirect:/profile";
	}


//	@GetMapping()
//	public String picture(){
//		User currentUser = users.findById(id);
//		User userz = users.getOne(currentUser.getId());
//	}


}
