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


    @GetMapping("/map")
    public String viewMap(Model model) {
        return "map";
    }


}