package com.codeup.shearup.controllers;

import com.codeup.shearup.models.*;
import com.codeup.shearup.repositories.BarberDetailRepository;
import com.codeup.shearup.repositories.LocationRepository;
import com.codeup.shearup.repositories.ServiceRepository;
import com.codeup.shearup.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BarberController {
    //========CREATION OF USER AND SERVICE OBJECTS=====//
    private final UserRepository usersDao;
    private final ServiceRepository servicesDao;
    private final BarberDetailRepository barberDetailDao;
    private final LocationRepository locationsDao;

    //========WE WILL NEED TO ADD MORE EVENTUALLY POSSIBLY=======//
    public BarberController(UserRepository usersDao, ServiceRepository servicesDao, BarberDetailRepository barberDetailDao, LocationRepository locationsDao) {
        this.usersDao = usersDao;
        this.servicesDao = servicesDao;
        this.barberDetailDao = barberDetailDao;
        this.locationsDao = locationsDao;
    }

    //==========PROFILE PAGE FOR SPECIFIC BARBER==========//
    //==========ADDED ModelAttribute SERVICE TO POPULATE SERVICES on page=======////
    @GetMapping("barber/profile/{id}")
    public String barberProfile(@ModelAttribute Service service, @PathVariable long id, Model model) {
        //=======PULL USER THAT IS CURRENTLY LOGGED IN AND CASTING USER INTO USER OBJECT======//
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //=====THIS REPRESENTS CURRENT USER THAT IS LOGGED IN GRABBING USER OBJECT==////
        //===== GETS USER OBJECT OF ASSOCIATED ID WITH USER THAT IS LOGGED IN=======///
        User user = usersDao.getOne(sessionUser.getId());
        //=======FIND SERVICES BY USERID ADD TO SERVICES REPOSITORY======//
        model.addAttribute("services", servicesDao.findAll());
        //=====PULLING ASSOCIATED BARBER DETAIL INFORMATION OF BARBER==//////
        model.addAttribute("barber", barberDetailDao.getOne(id));
        //=====REPRESENTS CURRENTLY LOGGED IN USER=====//
        model.addAttribute("user", user);
        return"barber/profile";
    }

    //===========START OF THREE STEP FORM========///
    //==========BARBER-DETAIL => LOCATIONS => IMAGE ==//
    //=============BARBER DETAIL FORM===========//
    @GetMapping("/barber/barber-details")
    public String barberDetail(Model model){
        model.addAttribute("barberDetail", new BarberDetail());
        return "barber/barber-details";
    }
    //============BARBER DETAIL FORM POST MAPPING=======//
    @PostMapping("/barber/barber-details")
    public String insertBarberDetails(@ModelAttribute BarberDetail barberDetail) {
        BarberDetail loggedInBarber = (BarberDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        usersDao.getOne(loggedInUser.getId());
        barberDetailDao.getOne(loggedInBarber.getId());
        return "redirect:barber/profile";
    }




    //======ADD A SERVICE PAGE FOR BARBER=========//
    @GetMapping("/barber/add-service")
    public String addService(Model model){
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = usersDao.getOne(sessionUser.getId());
        //=====PULLING ASSOCIATED BARBER DETAIL INFORMATION OF BARBER==//////
        //=====REPRESENTS CURRENTLY LOGGED IN USER=====//
        model.addAttribute("user", user);

        //LOGICAL BUT NOT NEEDED?
        model.addAttribute("service", new Service());
        return "barber/add-service";
    }

    //NEED TO MANUALLY INPUT THE BARBER WHO MADE SERVICE=====
    @PostMapping("/barber/add-service")
    public String insertService(@ModelAttribute Service service) {
        // commented out below because causing error
//        BarberDetail loggedInBarber = (BarberDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //=======OLD USER OBJECT HERE======//
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        BarberDetail barberDetailSession =(BarberDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //=====NEED TO HAVE LOGGED IN BARBER TO =====//



        //=====This is Placeholder for now====//
        //=====LOGIC BEHIND THIS IS A SPECIFIC BARBER===//
        //=====IS LINKED TO EACH BARBER DETAIL=======/////
        usersDao.getOne(sessionUser.getId());
//        barberDetailDao.getOne(barberDetailSession.getId());
        // commented out below because causing error
//        barberDetailDao.getOne(loggedInBarber.getId());
//        sessionUser.getBarberDetail().getServices().add(service);
        servicesDao.save(service);
        return "redirect:/barber/profile";
    }



}
