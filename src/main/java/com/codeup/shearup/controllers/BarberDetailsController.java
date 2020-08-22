package com.codeup.shearup.controllers;

import com.codeup.shearup.models.BarberDetail;
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

}
