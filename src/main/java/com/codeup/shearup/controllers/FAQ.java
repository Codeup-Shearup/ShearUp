package com.codeup.shearup.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FAQ {

    //FAQ Controller Placeholder for now
    @GetMapping("/FAQ")
    public String about(Model model){
        return "/FAQ";
    }


}
