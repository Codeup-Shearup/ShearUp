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

import java.util.List;

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
    @GetMapping("barber/profile")
    public String barberProfile(@ModelAttribute Service service, Model model) {
        //=======PULL USER THAT IS CURRENTLY LOGGED IN AND CASTING USER INTO USER OBJECT======//
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //=====THIS REPRESENTS CURRENT USER THAT IS LOGGED IN GRABBING USER OBJECT==////
        //===== GETS USER OBJECT OF ASSOCIATED ID WITH USER THAT IS LOGGED IN=======///
        User user = usersDao.getOne(sessionUser.getId());

        //=======FIND SERVICES BY USERID ADD TO SERVICES REPOSITORY======//
        model.addAttribute("services", servicesDao.findAllByBarberDetail(sessionUser.getBarberDetail()));
        //=====PULLING ASSOCIATED BARBER DETAIL INFORMATION OF BARBER==//////
        model.addAttribute("barber", barberDetailDao.getOne(sessionUser.getId()));
        //=====REPRESENTS CURRENTLY LOGGED IN USER=====//
        model.addAttribute("user", user);
        return"barber/profile";
    }

    //============DELETE A SERVICE BUTTON==============// -NEEDS WORK RAMON
    @PostMapping("/barber/service-delete")
    public String deleteService(@RequestParam(name = "deleteButton") long id){
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(id);
        usersDao.getOne(sessionUser.getId());
        Service service = servicesDao.getOne(id);
        System.out.println("service.getBarberDetail().getUser().getFirstName() = " + service.getBarberDetail().getUser().getFirstName());
        System.out.println("service.getBarberDetail().getUser().getId() = " + service.getBarberDetail().getUser().getId());
        servicesDao.delete(service);
        return "redirect:/barber/profile/" + sessionUser.getBarberDetail().getId();
    }
    //======2ND TRY ON THIS
//    @PostMapping("/barber/{id}/service-delete")
//    public String deleteService(@ModelAttribute Service service){
//        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Service deleteService = servicesDao.getOne(service.getId());
//        usersDao.getOne(sessionUser.getId());
//        servicesDao.delete(deleteService);
//        return "redirect:/barber/profile/" + sessionUser.getBarberDetail().getId();
//    }

    //================ EDIT SERVICE BUTTON =======///
    @GetMapping("/barber/{id}/edit-service")
    public String editButton(@PathVariable long id, Model model) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = usersDao.getOne(sessionUser.getId());

        model.addAttribute("user", user);
        model.addAttribute("editButton", servicesDao.getOne(id));
        return "barber/edit-service";
    }

    @PostMapping("/barber/{id}/edit-service")
    public String editService(@PathVariable long id,
                              @ModelAttribute Service service) {

        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        usersDao.getOne(sessionUser.getId());

//        service.setBarberDetail(sessionUser);
        servicesDao.save(service);

        return "redirect:/barber/edit-service";
    }

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
        return "redirect:/barber/profile";
    }


    // ==DEBUGGING DON'T DELETE==
//    @GetMapping("/barbers")
//    public String getBarbers(Model model) {
//        List<User> allBarbers = usersDao.findAllByBarber(true);
//        model.addAttribute("barbers", allBarbers);
//        return "barber/barbers";
//    }
}
