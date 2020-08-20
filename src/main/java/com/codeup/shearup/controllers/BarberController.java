package com.codeup.shearup.controllers;

import com.codeup.shearup.models.BarberDetail;
import com.codeup.shearup.models.Service;
import com.codeup.shearup.models.User;
import com.codeup.shearup.repositories.BarberDetailRepository;
import com.codeup.shearup.repositories.ServiceRepository;
import com.codeup.shearup.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;

@Controller
public class BarberController {
    //========CREATION OF USER AND SERVICE OBJECTS=====//
    private final UserRepository usersDao;
    private final ServiceRepository servicesDao;
    private final BarberDetailRepository barberDetailDao;

    //========WE WILL NEED TO ADD MORE EVENTUALLY POSSIBLY=======//
    public BarberController(UserRepository usersDao, ServiceRepository servicesDao, BarberDetailRepository barberDetailDao) {
        this.usersDao = usersDao;
        this.servicesDao = servicesDao;
        this.barberDetailDao = barberDetailDao;
    }

    //==========PROFILE PAGE FOR SPECIFIC BARBER==========//
    //==========ADDED ModelAttribute SERVICE TO POPULATE SERVICES on page=======////
    @GetMapping("barber/profile/{id}")
    public String barberProfile(@ModelAttribute Service service, @PathVariable long id, Model model) {

        model.addAttribute("service", servicesDao.getOne(id));
        model.addAttribute("barber", barberDetailDao.getOne(id));
        model.addAttribute("user", usersDao.getOne(id));
        return"barber/profile";
    }




    //======ADD A SERVICE PAGE FOR BARBER=========//
    @GetMapping("/barber/add-service")
    public String addService(Model model){
        //LOGICAL BUT UNNECCESARY
        model.addAttribute("service", new Service());
        return "barber/add-service";
    }

    //NEED TO MANUALLY INPUT THE BARBER WHO MADE SERVICE=====
    @PostMapping("/barber/add-service")
    public String insertService(@ModelAttribute Service service){
        BarberDetail loggedInBarber = (BarberDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //=======OLD USER OBJECT HERE======//
         User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //=====NEED TO HAVE LOGGED IN BARBER TO =====//
        //=====TEST OUT FUNCTIONALITY====//
        //=====This is Placeholder for now====//
        //=====LOGIC BEHIND THIS IS A SPECIFIC BARBER===//
        //=====IS LINKED TO EACH BARBER DETAIL=======/////
        usersDao.getOne(loggedInUser.getId());
        barberDetailDao.getOne(loggedInBarber.getId());
        servicesDao.save(service);
        return "redirect:barber/profile";
    }



}
