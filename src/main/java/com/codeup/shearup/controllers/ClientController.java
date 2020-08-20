package com.codeup.shearup.controllers;

import com.codeup.shearup.models.Review;
import com.codeup.shearup.repositories.ReviewRepository;
import com.codeup.shearup.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ClientController {

    //    dependency injection
    private final UserRepository usersDao;
    private final ReviewRepository reviewsDao;

    //========WE WILL NEED TO ADD MORE EVENTUALLY POSSIBLY=======//
    public ClientController(UserRepository usersDao, ReviewRepository reviewsDao) {
        this.usersDao = usersDao;
        this.reviewsDao = reviewsDao;
    }

    //==========PROFILE PAGE FOR SPECIFIC CLIENT==========//
    @GetMapping("client/profile/{id}")
    public String clientProfile(@ModelAttribute Review review, @PathVariable long id, Model model) {

        model.addAttribute("review", reviewsDao.getOne(id));
        model.addAttribute("user", usersDao.getOne(id));
        return"client/profile";
    }


    //======ADD A REVIEW PAGE FOR CLIENT=========//
    @GetMapping("/client/add-review")
    public String addReview(Model model){
        model.addAttribute("Reviews", new Review());
        return "client/add-review";
    }




}




