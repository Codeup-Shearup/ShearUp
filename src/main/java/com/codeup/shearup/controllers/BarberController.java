package com.codeup.shearup.controllers;

import com.codeup.shearup.models.User;
import com.codeup.shearup.repositories.ServiceRepository;
import com.codeup.shearup.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Provider;

@Controller
public class BarberController {
    //========CREATION OF USER AND SERVICE OBJECTS=====//
    private final UserRepository usersDao;
    private final ServiceRepository servicesDao;

    //========WE WILL NEED TO ADD MORE EVENTUALLY POSSIBLY=======//
    public BarberController(UserRepository usersDao, ServiceRepository servicesDao) {
        this.usersDao = usersDao;
        this.servicesDao = servicesDao;
    }


    //======ADD A SERVICE PAGE FOR BARBER=========//
    @GetMapping("/barber/add-service")
    public String create(Model model){
        model.addAttribute("service", new Service());
        return "/barber/add-service";
    }

    //
    @PostMapping("/barber/add-service")
    public String insert(@RequestParam String description,
                         @RequestParam String name,
                         @RequestParam int duration,
                         @RequestParam double price){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = usersDao.getOne(loggedInUser.getId());
        Service service = new Service(description, name, duration, price);
        servicesDao.save(service);
        return "redirect:/barber/profile";
    }



}
