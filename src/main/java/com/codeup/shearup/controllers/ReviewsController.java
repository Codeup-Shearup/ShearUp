package com.codeup.shearup.controllers;

import com.codeup.shearup.models.Appointment;
import com.codeup.shearup.models.Review;
import com.codeup.shearup.models.User;
import com.codeup.shearup.repositories.AppointmentRepository;
import com.codeup.shearup.repositories.ReviewRepository;
import com.codeup.shearup.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReviewsController {

    private final ReviewRepository reviewsDao;
    private final UserRepository usersDao;
    private final AppointmentRepository appointmentDao;

    public ReviewsController(ReviewRepository reviewsDao, UserRepository usersDao, AppointmentRepository appointmentDao){
        this.reviewsDao = reviewsDao;
        this.usersDao = usersDao;
        this.appointmentDao = appointmentDao;
    }

    @GetMapping("/reviews")
    public String index(Model model){
        List<Review> myReview = reviewsDao.findAll();
//        Review pulledReview = reviewsDao.getOne(id);
        model.addAttribute("reviews", myReview);
        return "reviews/index";
    }

    //Viewing Review
    @GetMapping("/reviews/{id}")
    public String show(@PathVariable long id, Model model){
        Review pulledReview = reviewsDao.getOne(id);
        model.addAttribute("review", pulledReview);
        return "reviews/show";
    }

    //Creating Review
    @GetMapping("/reviews/create")
    public String showCreateReviewForm(Model model){
        model.addAttribute("review", new Review());
        return "reviews/create";
    }

    //Creating Review
    @PostMapping("reviews/create")
    public String createReview(@ModelAttribute Review review){
//
        Appointment appointment = appointmentDao.getOne(1L);
        review.setAppointment(appointment);
        reviewsDao.save(review);
        return "redirect:/reviews";
    }

    //Edit Review
    @GetMapping("/reviews/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model){
        model.addAttribute("review", reviewsDao.getOne(id));
        return "reviews/edit";
    }

    //Edit Review
    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id,
                           @RequestParam(name = "titleEdit")String titleUpdate,
                           @RequestParam(name = "contentEdit") String contentUpdate,
                           @RequestParam(name = "ratingEdit") Double ratingUpdate){
        Review review = reviewsDao.getOne(id);
        review.setTitle(titleUpdate);
        review.setContent(contentUpdate);
        review.setRating(ratingUpdate);
        reviewsDao.save(review);
        return "redirect:/reviews/show" + id;
    }

    //Deleting Review
    @PostMapping("/reviews/{id}/delete")
    public String deleteReview(@PathVariable long id){
        reviewsDao.deleteById(id);
        return "redirect:/reviews";
    }


    //About Us Controller Placeholder for now
    @GetMapping("/about")
    public String about(Model model){
        return "/about/about-us";
    }


}
