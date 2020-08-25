package com.codeup.shearup.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilestackController {

    //Placeholder for now
    @GetMapping("/filestack")
    public String about(Model model){
        return "uploadImagePage";
    }


}
