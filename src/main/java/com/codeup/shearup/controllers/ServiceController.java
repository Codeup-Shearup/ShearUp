package com.codeup.shearup.controllers;

import com.codeup.shearup.models.*;
import com.codeup.shearup.repositories.ImageRepository;
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
    private final ImageRepository imagesDao;

    public ServiceController(ServiceRepository servicesDao, UserRepository usersDao, ImageRepository imagesDao) {
        this.servicesDao = servicesDao;
        this.usersDao = usersDao;
        this.imagesDao = imagesDao;
    }

    //  LIST OF ALL SERVICES
    @GetMapping("/services")
    public String serviceIndexPage(Model model) {
        List<Service> myService = servicesDao.findAll();
        List<Image> myImage = imagesDao.findAll();
        model.addAttribute("services", myService);
        model.addAttribute("images", myImage);
//        Image img = new Image();
//        img.getImages
//        img.setFilestack_url(imagePreview);
//        img.setService(service);
        return "services/index";
    }

    //GETTING ONE SERVICE
    @GetMapping("/services/{id}")
    public String showOne(@PathVariable long id, Model model){
        Service pulledService = servicesDao.getOne(id);
        model.addAttribute("service", pulledService);
        return "services/show";
    }

    // RETURN CREATE FORM
    //    lock this down in security
    //validation if there is no logged in user
    @GetMapping("/services/create")
    public String showServiceForm(Model model){
        try {
            User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e){
            e.printStackTrace();
            return "redirect:/";
        }
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println("loggedInUser.getUsername() = " + loggedInUser.getUsername()); --prints out twice -K
        if(!loggedInUser.isBarber()) {
//            throw not barber error
            return "redirect:/";
        }
        model.addAttribute("Service", new Service());
        return "services/create";
    }

    @PostMapping("/services/create")
    public String createService(@ModelAttribute Service service, @RequestParam String imageUpload){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(loggedInUser.getBarberDetail() != null){
            service.setBarberDetail(loggedInUser.getBarberDetail());
            Image img = new Image();
            img.setFilestackUrl(imageUpload);
            img.setService(service);
            servicesDao.save(service);
            imagesDao.save(img);
            return "redirect:/services";
        }
        else {
//            throw error redirect user to 405 unathorized
            return "redirect:/services";
        }
    }

// ==== EDITING SERVICES ==== //

    //editing individual services
    @GetMapping("/services/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model){
        model.addAttribute("service", servicesDao.getOne(id));
        return "services/edit";
    }

    @PostMapping("/services/{id}/edit")
    public String editPost(@PathVariable long id, @ModelAttribute Service Service){
        //TODO: Change user to logged in user dynamic
        User user = usersDao.getOne(1L);
//        Service.setBarberDetail(barberDetailId); <----own barber should edit their service
//        service.setAuthor(user);
//        service.setBarberDetail(loggedInUser.getBarberDetail());
        servicesDao.save(Service);
        return "redirect:/services";
    }


// ==== DELETING SERVICES ==== //

    //Delete Service GET
    @GetMapping("/services/{id}/delete")
    public String deletePage(@PathVariable Long id, Model model){
        Service pulledService = servicesDao.getOne(id);
        model.addAttribute("service", pulledService);
        return "services/delete";
    }

    //Deleting Service POST
    @PostMapping("/services/{id}/delete")
    public String deleteService(@ModelAttribute Service service){
        Service deleteService = servicesDao.getOne(service.getId());
        servicesDao.delete(deleteService);
        return "redirect:/services";
    }





}