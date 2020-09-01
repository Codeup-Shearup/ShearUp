package com.codeup.shearup.controllers;


import com.codeup.shearup.models.Location;
import com.codeup.shearup.repositories.BarberDetailRepository;
import com.codeup.shearup.repositories.LocationRepository;
import com.codeup.shearup.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MapController {

    private UserRepository usersDao;
    private BarberDetailRepository barberDetailsDao;
    private LocationRepository locationsDao;

//    public MapController(UserRepository usersDao) {
//        this.usersDao = usersDao;
//    }

    public MapController(UserRepository usersDao, BarberDetailRepository barberDetailsDao, LocationRepository locationsDao) {
        this.usersDao = usersDao;
        this.barberDetailsDao = barberDetailsDao;
        this.locationsDao = locationsDao;
    }

    @GetMapping("/mapbox-map")
    public String viewMap(Model model) {
        return "mapbox-map";
    }

    @GetMapping("/mapbox/barbers")
    @ResponseBody
    public List<Location> getLocation() {
        return locationsDao.findAll();
    }


}