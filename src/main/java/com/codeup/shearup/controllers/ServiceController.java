package com.codeup.shearup.controllers;

import com.codeup.shearup.models.Review;
import com.codeup.shearup.models.Service;
import com.codeup.shearup.models.User;
import com.codeup.shearup.repositories.ServiceRepository;
import com.codeup.shearup.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ServiceController {

    //dependency injection
    private final ServiceRepository servicesDao;
    private final UserRepository usersDao;

    public PostController(ServiceRepository servicesDao, UserRepository usersDao) {
        this.servicesDao = servicesDao;
        this.usersDao = usersDao;
    }

    //  ALL POSTS
    @GetMapping("/services")
    public String serviceIndexPage(Model model) {
        List<Service> myServices = servicesDao.findAll();
        model.addAttribute("services", myService);
        return "services/index";
    }

    //GETTING ONE SERVICE
    @GetMapping("/services/{id}")
    public String showOne(@PathVariable long id, Model model){
        Service pulledPost = servicesDao.getOne(id);
        model.addAttribute("Service", pulledPost);
        return "services/show";
    }

    // RETURN CREATE FORM
    @GetMapping("/services/create")
    public String showServiceForm(Model model){
        model.addAttribute("Service", new Service());
        return "services/create";
    }

//    @PostMapping("/services/create")
//    public String createService(@ModelAttribute Service Service){
//        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////        Service.setBarberDetail(loggedInBarberDetail);
//        servicesDao.save(Service);
//        return "redirect:/services";
//    }

    //  CREATE REVIEW
//    @PostMapping("/services/show/{id}/review")
//    public String getPost(@PathVariable(value = "id") long id, @RequestParam(name = "createReview") String createReview) {
//        Service service = servicesDao.getOne(id);
//        Review review = new Review();
//        Review.setContent(createReview);
//        Review.setParentService(service);
//        reviewDao.save(review);
//
//        return "redirect:/services/show/" + id;
//    }
//


    //editing individual services
    @GetMapping("/services/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model){
        model.addAttribute("Service", servicesDao.getOne(id));
        return "services/edit";
    }

    @PostMapping("/services/{id}/edit")
    public String editPost(@PathVariable long id, @ModelAttribute Service Service){
        //TODO: Change user to logged in user dynamic
        User user = usersDao.getOne(1L);
//        Service.setBarberDetail(barberDetailId); <----own barber should edit their service
        servicesDao.save(Service);
        return "redirect:/services";
    }


// ==== DELETING SERVICES ==== //


//    DELETING INDIVIDUAL SERVICES
    @PostMapping("/services/{id}/delete")
    public String deletePost(@PathVariable long id) {
        servicesDao.deleteById(id);
        return "redirect:/services";
    }





}