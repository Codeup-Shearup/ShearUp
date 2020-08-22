package com.codeup.shearup.controllers;


import com.codeup.shearup.models.User;
import com.codeup.shearup.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class MapController {

    private UserRepository usersDao;

    public MapController(UserRepository usersDao) {
        this.usersDao = usersDao;
    }

//    where is this returning?
    @GetMapping("/map")
    public String viewMap(Model model) {
        return "services/map-index";
    }

//    not sure how to incorporate a JSON file yet
//    @GetMapping("/users.json")
//    public @ResponseBody
//    List<User> viewAllUserInJSONFormat() {
//        return usersDao.findAll();
//    }
}