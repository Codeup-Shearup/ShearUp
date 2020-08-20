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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReviewsController {

    private final ReviewRepository reviewDao;
    private final UserRepository usersDao;
    private final AppointmentRepository appointmentDao;

    public ReviewsController(ReviewRepository reviewDao, UserRepository usersDao, AppointmentRepository appointmentDao){
        this.reviewDao = reviewDao;
        this.usersDao = usersDao;
        this.appointmentDao = appointmentDao;
    }

    //Viewing Review
    @GetMapping("/reviews/show")
    public String showsReviews(@PathVariable(value = "id") long id, Model model){
        Review reviewPost = reviewDao.getOne(id);
        model.addAttribute("review", reviewPost);
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
        Appointment appointment = (Appointment) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        review.setAppointment(appointment);
        reviewDao.save(review);
        return "redirect:/reviews";
    }

    //Deleting Review
    @PostMapping("/reviews/{id}/delete")
    public String deleteReview(@PathVariable long id){
        reviewDao.deleteById(id);
        return "redirect:/reviews";
    }



}
