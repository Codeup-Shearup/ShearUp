//package com.codeup.shearup.controllers;
//
//import com.codeup.shearup.models.Service;
//import com.codeup.shearup.models.User;
//import com.codeup.shearup.repositories.BarberDetailRepository;
//import com.codeup.shearup.repositories.ServiceRepository;
//import com.codeup.shearup.repositories.UserRepository;
//import org.springframework.security.core.context.SecurityContextHolder;
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
////    private final BarberDetailRepository barberDetailsDao; <---setting the service to a AdminUser aka a BarberUser
//
//    public ServiceController(ServiceRepository servicesDao, UserRepository usersDao) {
//        this.servicesDao = servicesDao;
//        this.usersDao = usersDao;
//    }
////
////    //  LIST OF ALL SERVICES
////    @GetMapping("/services")
////    public String serviceIndexPage(Model model) {
////        List<Service> myService = servicesDao.findAll();
////        model.addAttribute("services", myService);
////        return "services/index";
////    }
////
////    //GETTING ONE SERVICE
////    @GetMapping("/services/{id}")
////    public String showOne(@PathVariable long id, Model model){
////        Service pulledService = servicesDao.getOne(id);
////        model.addAttribute("service", pulledService);
////        return "services/show";
////    }
////
////    // RETURN CREATE FORM
////    @GetMapping("/services/create")
////    public String showServiceForm(Model model){
////        model.addAttribute("Service", new Service());
////        return "services/create";
////    }
////
//////    @PostMapping("/services/create")
//////    public String createService(@ModelAttribute Service Service){
//////        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////////        Service.setBarberDetail(loggedInBarberDetail); <----barber-details user can create a service
//////        servicesDao.save(Service);
//////        return "redirect:/services";
//////    }
////
////// ==== EDITING SERVICES ==== //
////
////    //editing individual services
////    @GetMapping("/services/{id}/edit")
////    public String showEditForm(@PathVariable long id, Model model){
////        model.addAttribute("Service", servicesDao.getOne(id));
////        return "services/edit";
////    }
////
////    @PostMapping("/services/{id}/edit")
////    public String editPost(@PathVariable long id, @ModelAttribute Service Service){
////        User user = usersDao.getOne(1L);
//////        Service.setBarberDetail(barberDetailId); <----own barber should edit their service
////        servicesDao.save(Service);
////        return "redirect:/services";
////    }
////
//////   possibly use getParent on thymeleaf
////
////// ==== DELETING SERVICES ==== //
////
//////    DELETING INDIVIDUAL SERVICES
////    @PostMapping("/services/{id}/delete")
////    public String deletePost(@PathVariable long id) {
////        servicesDao.deleteById(id);
////        return "redirect:/services";
////    }
//
////}
//    @GetMapping("/services")
//    public String index(Model model) {
//        List<Service> myReview = servicesDao.findAll();
//        model.addAttribute("services", myReview);
//        return "services/index";
//    }
//
//    //Viewing service
//    @GetMapping("/services/{id}")
//    public String show(@PathVariable long id, Model model) {
//        Service pulledService = servicesDao.getOne(id);
//        model.addAttribute("service", pulledService);
//        return "services/show";
//    }
//
//    //Creating service
//    @GetMapping("/services/create")
//    public String showCreateReviewForm(Model model) {
//        model.addAttribute("service", new Service());
//        return "services/create";
//    }
//
////    who can create the service? the admin user aka the barber user.
////    instead of setAuthor do setBarberDetail id?
//    //Creating service
//    @PostMapping("services/create")
//    public String createService(@ModelAttribute Service service) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        service.setAuthor(user);
//        servicesDao.save(service);
//        return "redirect:/services";
//    }
//
//    //Edit service
//    @GetMapping("/services/{id}/edit")
//    public String showEditForm(@PathVariable long id, Model model) {
//        model.addAttribute("service", servicesDao.getOne(id));
//        return "services/edit";
//    }
//
//    //Edit service
//    @PostMapping("/services/{id}/edit")
//    public String editServices(@PathVariable long id, @ModelAttribute Service service) {
//        User user = usersDao.getOne(1L);
//        service.setAuthor(user);
//        servicesDao.save(service);
//        return "redirect:/services";
//    }
//
//    //Delete service GET
//    @GetMapping("/services/{id}/delete")
//    public String deletePage(@PathVariable Long id, Model model) {
//        Service pulledService = servicesDao.getOne(id);
//        model.addAttribute("service", pulledService);
//        return "services/delete";
//    }
//
//    //Deleting service POST
//    @PostMapping("/services/{id}/delete")
//    public String deleteReview(@ModelAttribute Service service) {
//        Service deleteService = servicesDao.getOne(service.getId());
//        servicesDao.delete(deleteService);
//        return "redirect:/services";
//    }
//}