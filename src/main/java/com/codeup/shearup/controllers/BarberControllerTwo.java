//package com.codeup.shearup.controllers;
//
//import com.codeup.shearup.models.*;
//import com.codeup.shearup.repositories.*;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//public class BarberControllerTwo {
//    //========CREATION OF USER AND SERVICE OBJECTS=====//
//    private final UserRepository usersDao;
//    private final ServiceRepository servicesDao;
//    private final BarberDetailRepository barberDetailDao;
//    private final LocationRepository locationsDao;
//    private final ReviewRepository reviewsDao;
//
//    //========WE WILL NEED TO ADD MORE EVENTUALLY POSSIBLY=======//
//    public BarberControllerTwo(UserRepository usersDao, ServiceRepository servicesDao,
//                               BarberDetailRepository barberDetailDao, LocationRepository locationsDao,
//                               ReviewRepository reviewsDao) {
//        this.usersDao = usersDao;
//        this.servicesDao = servicesDao;
//        this.barberDetailDao = barberDetailDao;
//        this.locationsDao = locationsDao;
//        this.reviewsDao = reviewsDao;
//    }
//
//    //==========PROFILE PAGE FOR SPECIFIC BARBER==========//
//    //==========ADDED ModelAttribute SERVICE TO POPULATE SERVICES on page attached to Barber=======////
//    @GetMapping("/barber/profiletwo")
//    public String barberProfile(@ModelAttribute Service service, Model model) {
//        //=======PULL USER THAT IS CURRENTLY LOGGED IN AND CASTING USER INTO USER OBJECT======//
//        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        //=====THIS REPRESENTS CURRENT USER THAT IS LOGGED IN GRABBING USER OBJECT==////
//        //===== GETS USER OBJECT OF ASSOCIATED ID WITH USER THAT IS LOGGED IN=======///
//        User user = usersDao.getOne(sessionUser.getId());
//
//        //=======FIND SERVICES BY USERID ADD TO SERVICES REPOSITORY======//
//        model.addAttribute("services", servicesDao.findAllByBarberDetail(sessionUser.getBarberDetail()));
//        //=====PULLING ASSOCIATED BARBER DETAIL INFORMATION OF BARBER==//////
////        model.addAttribute("barber", barberDetailDao.getOne(sessionUser.getId()));
//        model.addAttribute("location", locationsDao.getOne(sessionUser.getId()));
//        //=====REPRESENTS CURRENTLY LOGGED IN USER=====//
//        model.addAttribute("user", user);
//        return "barber/profiletwo";
//    }
//
//    //===BARBER PROFILE CLIENTS VIEW===
//    @GetMapping("/barber/profiletwo/{id}")
//    public String barberProfile(@PathVariable long id, Model model) {
//        User barber = usersDao.getOne(id);
//        //=======FIND SERVICES BY USERID ADD TO SERVICES REPOSITORY======//
////        model.addAttribute("services", servicesDao.findAllByBarberDetail(barber.getBarberDetail()));
////        //=====PULLING ASSOCIATED BARBER DETAIL INFORMATION OF BARBER==//////
////        model.addAttribute("barber", barberDetailDao.getOne(barber.getId()));
////        model.addAttribute("location", locationsDao.getOne(barber.getId()));
////        model.addAttribute("reviews", reviewsDao.findAllReviewsByBarber(barber.getBarberDetail().getId()));
//        //=====REPRESENTS CURRENTLY LOGGED IN USER=====//
//        model.addAttribute("barber", barber);
//        return "barber/show";
//    }
//
//}
