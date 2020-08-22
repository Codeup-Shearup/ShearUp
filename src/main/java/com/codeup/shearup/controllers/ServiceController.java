//package com.codeup.shearup.controllers;
//
//import com.codeup.shearup.models.Service;
//import com.codeup.shearup.models.User;
//import com.codeup.shearup.repositories.ServiceRepository;
//import com.codeup.shearup.repositories.UserRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//public class ServiceController {
//
//    //dependency injection
//    private final ServiceRepository servicesDao;
//    private final UserRepository usersDao;
//
//    public ServiceController(ServiceRepository servicesDao, UserRepository usersDao) {
//        this.servicesDao = servicesDao;
//        this.usersDao = usersDao;
//    }
//
//    //  LIST OF ALL SERVICES
//    @GetMapping("/services")
//    public String serviceIndexPage(Model model) {
//        List<Service> myService = servicesDao.findAll();
//        model.addAttribute("services", myService);
//        return "services/index";
//    }
//
//    //GETTING ONE SERVICE
//    @GetMapping("/services/{id}")
//    public String showOne(@PathVariable long id, Model model){
//        Service pulledService = servicesDao.getOne(id);
//        model.addAttribute("service", pulledService);
//        return "services/show";
//    }
//
//    // RETURN CREATE FORM
//    @GetMapping("/services/create")
//    public String showServiceForm(Model model){
//        model.addAttribute("Service", new Service());
//        return "services/create";
//    }
//
////    @PostMapping("/services/create")
////    public String createService(@ModelAttribute Service Service){
////        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//////        Service.setBarberDetail(loggedInBarberDetail); <----barber-details user can create a service
////        servicesDao.save(Service);
////        return "redirect:/services";
////    }
//
//// ==== EDITING SERVICES ==== //
//
//    //editing individual services
//    @GetMapping("/services/{id}/edit")
//    public String showEditForm(@PathVariable long id, Model model){
//        model.addAttribute("Service", servicesDao.getOne(id));
//        return "services/edit";
//    }
//
//    @PostMapping("/services/{id}/edit")
//    public String editPost(@PathVariable long id, @ModelAttribute Service Service){
//        //TODO: Change user to logged in user dynamic
//        User user = usersDao.getOne(1L);
////        Service.setBarberDetail(barberDetailId); <----own barber should edit their service
//        servicesDao.save(Service);
//        return "redirect:/services";
//    }
//
////    getParent on thymeleaf
//
//
//// ==== DELETING SERVICES ==== //
//
//
////    DELETING INDIVIDUAL SERVICES
//    @PostMapping("/services/{id}/delete")
//    public String deletePost(@PathVariable long id) {
//        servicesDao.deleteById(id);
//        return "redirect:/services";
//    }
//
//
//
//
//
//}