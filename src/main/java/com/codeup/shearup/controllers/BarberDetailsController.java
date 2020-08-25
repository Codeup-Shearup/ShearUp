package com.codeup.shearup.controllers;

import com.codeup.shearup.models.BarberDetail;
import com.codeup.shearup.models.Location;
import com.codeup.shearup.models.User;
import com.codeup.shearup.repositories.BarberDetailRepository;
import com.codeup.shearup.repositories.LocationRepository;
import com.codeup.shearup.repositories.ServiceRepository;
import com.codeup.shearup.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BarberDetailsController {
    private final UserRepository usersDao;
    private final ServiceRepository servicesDao;
    private final BarberDetailRepository barberDetailDao;
    private final LocationRepository locationsDao;

    public BarberDetailsController(UserRepository usersDao, ServiceRepository servicesDao, BarberDetailRepository barberDetailDao, LocationRepository locationsDao) {
        this.usersDao = usersDao;
        this.servicesDao = servicesDao;
        this.barberDetailDao = barberDetailDao;
        this.locationsDao = locationsDao;
    }

    //===========START OF THREE STEP FORM========///
    //==========BARBER-DETAIL => LOCATIONS => IMAGE ==//
    //=============BARBER DETAIL BIO FORM===========//
    //=============STEP ONE FORM =============//
    @GetMapping("/barber/barber-details/bio")
    public String barberDetail(Model model){
        //=====GRABS LOGGED IN USER ASSOCIATED WITH SESSION FOR BARBER=====///
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", sessionUser);
        model.addAttribute("barberDetail", new BarberDetail());
        return "barber/barber-details";
    }
    //============BARBER DETAIL BIO FORM POST MAPPING=======// OLD WAY OF DOING IT

    @PostMapping("/barber/barber-details/bio")
    public String insertBarberDetails(@ModelAttribute BarberDetail barberDetail) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User barber = usersDao.getOne(sessionUser.getId());
        barberDetailDao.getOne(sessionUser.getId());

        barberDetailDao.save(barberDetail);
        barber.setBarberDetail(barberDetail);
        usersDao.save(barber);
        return "redirect:/barber/barber-details/location";
    }

//    @PostMapping("/barber/barber-details/bio")
//    public String insertBarberDetail(@ModelAttribute BarberDetail barberDetail) {
//        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        usersDao.getOne(sessionUser.getId());
//        barberDetailDao.getOne(sessionUser.getId());
//
//        barberDetail.setBio(sessionUser.getBarberDetail());
//    }




    //=================STEP 2 OF FORM using LOCATION MODEL ========///
    @GetMapping("/barber/barber-details/location")
    public String barberLocation(Model model){
        //=====GRABS LOGGED IN USER ASSOCIATED WITH SESSION FOR BARBER=====///
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        usersDao.getOne(sessionUser.getId());
        model.addAttribute("user", sessionUser);
        model.addAttribute("barberDetail", new BarberDetail());
        model.addAttribute("location", new Location());
        return "barber/barber-location";
    }


    @PostMapping("/barber/barber-details/location")
    public String insertBarberLocation(@ModelAttribute Location location,
                                       @ModelAttribute BarberDetail barberDetail) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User barber = usersDao.getOne(sessionUser.getId());
        BarberDetail barberDeet = barberDetailDao.getOne(sessionUser.getId());
        location.setBarber(barberDeet);

        barberDeet.setLocation(location);
        locationsDao.save(location);
        barberDetailDao.save(barberDeet);
        return "redirect:/barber/profile";
    }


}
