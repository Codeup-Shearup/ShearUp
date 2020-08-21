package com.codeup.shearup.controllers;


import com.codeup.shearup.models.Service;
import com.codeup.shearup.models.User;
import com.codeup.shearup.repositories.ServiceRepository;
import com.codeup.shearup.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ServiceController {

    private final ServiceRepository servicesDao;
    private final UserRepository usersDao;

    public PostController(ServiceRepository servicesDao, UserRepository usersDao) {
        this.servicesDao = servicesDao;
        this.usersDao = usersDao;
    }

    @GetMapping("/services")
    public String index(Model model){
        model.addAttribute("services", servicesDao.findAll());
        return "services/index";
    }

    @GetMapping("/services/{id}")
    public String show(@PathVariable long id, Model model){
        Service pulledPost = servicesDao.getOne(id);
        model.addAttribute("Service", pulledPost);
        return "services/show";
    }


    // return the create form
    @GetMapping("/services/create")
    public String showServiceForm(Model model){
        model.addAttribute("Service", new Service());
        return "services/create";
    }


    @PostMapping("/services/create")
    public String createService(@ModelAttribute Service Service){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Service.setBarberDetail(loggedInBarberDetail);
        servicesDao.save(Service);
        return "redirect:/services";
    }

    //editing individual services
    @GetMapping("/services/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model){
        model.addAttribute("Service", servicesDao.getOne(id));
        return "services/edit";
    }

    @PostMapping("/services/{id}/edit")
    public String editPost(@PathVariable long id, @ModelAttribute Service Service){
        //TODO: Change user to logged in user dynamic
        User user = usersDao.getOne(1L);
//        Service.setBarberDetail(barberDetailId); <----
        servicesDao.save(Service);
        return "redirect:/services";
    }


    @PostMapping("/services/{id}/delete")
    public String deletePost(@PathVariable long id) {
        servicesDao.deleteById(id);
        return "redirect:/services";
    }

}