package com.codeup.shearup.controllers;

import com.codeup.shearup.models.BarberDetail;
import com.codeup.shearup.models.Review;
import com.codeup.shearup.models.User;
import com.codeup.shearup.repositories.AppointmentRepository;
import com.codeup.shearup.repositories.BarberDetailRepository;
import com.codeup.shearup.repositories.ReviewRepository;
import com.codeup.shearup.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final BarberDetailRepository barberDetailDao;

    @Autowired
    public ReviewsController(ReviewRepository reviewsDao, UserRepository usersDao, AppointmentRepository appointmentDao, BarberDetailRepository barberDetailDao){
        this.reviewsDao = reviewsDao;
        this.usersDao = usersDao;
        this.appointmentDao = appointmentDao;
        this.barberDetailDao = barberDetailDao;
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
    @GetMapping("/reviews/create/{id}")
    public String showCreateReviewForm(Model model, @PathVariable Long id){
        User barber = usersDao.findByBarberDetail(barberDetailDao.getOne(id));
        model.addAttribute("barber", barber);
        model.addAttribute("review", new Review());
        model.addAttribute("rating", new Review());
        return "reviews/create";
    }

    //Creating Review
    @PostMapping("reviews/create")
    public String createReview(@ModelAttribute Review review, Model model, @RequestParam(name = "barberId") Long barberId, Long id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User barber = usersDao.findByBarberDetail(barberDetailDao.getOne(barberId));
        review.setBarberDetail(barber.getBarberDetail());
        review.setAuthor(user);
        model.addAttribute("rating", review);
        reviewsDao.save(review);
        return "redirect:/barbers";
    }

    //creation time stamp
//    https://thorben-janssen.com/persist-creation-update-timestamps-hibernate

    //Edit Review
    @GetMapping("/reviews/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model){
        model.addAttribute("review", reviewsDao.getOne(id));
        return "reviews/edit";
    }

    //Edit Review
    @PostMapping("/reviews/{id}/edit")
    public String editReviews(@PathVariable long id, @ModelAttribute Review review){
//                           @RequestParam(name = "titleEdit")String titleUpdate,
//                           @RequestParam(name = "contentEdit") String contentUpdate,
//                           @RequestParam(name = "ratingEdit") Double ratingUpdate){
//        Review review = reviewsDao.getOne(1L);
//        review.setTitle(titleUpdate);
//        review.setContent(contentUpdate);
//        review.setRating(ratingUpdate);
        User user = usersDao.getOne(1L);
        review.setAuthor(user);
        reviewsDao.save(review);
        return "redirect:/reviews";
    }

    //Delete Review GET
    @GetMapping("/reviews/{id}/delete")
    public String deletePage(@PathVariable Long id, Model model){
        Review pulledReview = reviewsDao.getOne(id);
        model.addAttribute("review", pulledReview);
        return "reviews/delete";
    }

    //Deleting Review POST
    @PostMapping("/reviews/{id}/delete")
    public String deleteReview(@ModelAttribute Review review){
        Review deleteReview = reviewsDao.getOne(review.getId());
        reviewsDao.delete(deleteReview);
        return "redirect:/profile";
    }


    //About Us Controller Placeholder for now
    @GetMapping("/about")
    public String about(Model model){
        return "about/about-us";
    }

}
