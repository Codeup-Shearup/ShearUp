package com.codeup.shearup.controllers;

import com.codeup.shearup.models.BarberDetail;
import com.codeup.shearup.models.Location;
import com.codeup.shearup.models.Service;
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
import org.springframework.web.bind.annotation.RequestParam;

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
    
    //===========START OF TWO STEP FORM========///
    //==========BARBER-DETAIL => LOCATIONS
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
        //ORIGINAL
        barberDetailDao.getOne(sessionUser.getId());
//        BarberDetail testBarberDetail = barberDetailDao.getOne(sessionUser.getId());
//        barberDetailDao.save(barberDetail); // ORIGINAL
        barberDetailDao.save(barberDetail);
        barber.setBarberDetail(barberDetail);
        usersDao.save(barber);
        return "redirect:/barber/barber-details/location";
    }

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
        BarberDetail barberDeet = barberDetailDao.getOne(barber.getBarberDetail().getId());
        location.setBarber(barberDeet);
        locationsDao.save(location);

        barberDeet.setLocation(location);
        barberDetailDao.save(barberDeet);
        return "redirect:/barber/profile";
    }
    
    //==============EDIT BARBER DETAILS=========//
    @GetMapping("/barber/edit-barber-details")
    public String editBarberDetails(Model model, @RequestParam(name="editBarberDetailsButton") Long barberDetailId){
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        BarberDetail barberDetail = barberDetailDao.getOne(barberDetailId);
        model.addAttribute("barberDetail", barberDetail);
        model.addAttribute("user", sessionUser);
        return "barber/edit-barber-details";
    }
    
    @PostMapping("/barber/edit-barber-details")
    public String editBarberDetailsPost(@ModelAttribute BarberDetail barberDetail, @RequestParam(name = "barberDetailId") Long barberDetailId) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        BarberDetail editBarberDetail = barberDetailDao.getOne(barberDetailId);
        editBarberDetail.setBio(barberDetail.getBio());
        editBarberDetail.setPhone(barberDetail.getPhone());
        editBarberDetail.setHoursOfWork(barberDetail.getHoursOfWork());
        barberDetailDao.save(editBarberDetail);
        return "redirect:/barber/profile";
    }


    //===========EDIT LOCATION ============//

    @GetMapping("/barber/edit-barber-location")
    public String editLocation(Model model, @RequestParam(name="editLocationButton") Long locationId) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Location locationDetail = locationsDao.getOne(locationId);
        model.addAttribute("location", locationDetail);
        model.addAttribute("user", sessionUser);
        return "barber/edit-barber-location";
    }

    @PostMapping("/barber/edit-barber-location")
    public String editLocationPost(@ModelAttribute Location location, @RequestParam(name="locationId") Long locationId) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Location editLocationDetail = locationsDao.getOne(locationId);
        editLocationDetail.setAddressOne(location.getAddressOne());
        editLocationDetail.setAddressTwo(location.getAddressTwo());
        editLocationDetail.setCity(location.getCity());
        editLocationDetail.setState(location.getState());
        editLocationDetail.setZipCode(location.getZipCode());
        locationsDao.save(editLocationDetail);
        return "redirect:/barber/profile";
    }


}
