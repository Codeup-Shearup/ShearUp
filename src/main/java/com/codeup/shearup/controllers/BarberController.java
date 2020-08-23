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
    //==========ADDED ModelAttribute SERVICE TO POPULATE SERVICES on page attached to Barber=======////
    @GetMapping("barber/profile/{id}")
    public String barberProfile(@ModelAttribute Service service, @PathVariable long id, Model model) {
        //=======PULL USER THAT IS CURRENTLY LOGGED IN AND CASTING USER INTO USER OBJECT======//
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //=====THIS REPRESENTS CURRENT USER THAT IS LOGGED IN GRABBING USER OBJECT==////
        //===== GETS USER OBJECT OF ASSOCIATED ID WITH USER THAT IS LOGGED IN=======///
        User user = usersDao.getOne(sessionUser.getId());

        //=======FIND SERVICES BY USERID ADD TO SERVICES REPOSITORY======//
        model.addAttribute("services", servicesDao.findAllByBarberDetail(sessionUser.getBarberDetail()));
        System.out.println("Hello");
        //=====PULLING ASSOCIATED BARBER DETAIL INFORMATION OF BARBER==//////
        model.addAttribute("barber", barberDetailDao.getOne(id));
        //=====REPRESENTS CURRENTLY LOGGED IN USER=====//
        model.addAttribute("user", user);
        return"barber/profile";
    }

    //============DELETE A SERVICE BUTTON==============// -NEEDS WORK RAMON
    @PostMapping("/barber/service-delete")
    public String deleteService(@RequestParam(name = "deleteButton") long id,
                                @ModelAttribute Service service){
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(id);
        usersDao.getOne(sessionUser.getId());
        servicesDao.delete(servicesDao.getOne(id));
        return "redirect:/barber/profile/" + sessionUser.getBarberDetail().getId();
    }

    //================ EDIT SERVICE BUTTON =======///



    //======ADD A SERVICE PAGE FOR BARBER=========//
    @GetMapping("/barber/add-service")
    public String addService(Model model){
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = usersDao.getOne(sessionUser.getId());
        //=====REPRESENTS CURRENTLY LOGGED IN USER=====//
        model.addAttribute("user", user);
        model.addAttribute("service", new Service());
        return "barber/add-service";
    }

    //NEED TO MANUALLY INPUT THE BARBER WHO MADE SERVICE=====
    @PostMapping("/barber/add-service")
    public String insertService(@ModelAttribute Service service) {
        //=======OLD USER OBJECT HERE======//
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //=====This is Placeholder for now====//
        //=====LOGIC BEHIND THIS IS A SPECIFIC BARBER===//
        usersDao.getOne(sessionUser.getId());
        sessionUser.getBarberDetail().getServices().add(service);
        service.setBarberDetail(sessionUser.getBarberDetail());
        servicesDao.save(service);
        return "redirect:/barber/profile/" + sessionUser.getBarberDetail().getId();
    }



}
