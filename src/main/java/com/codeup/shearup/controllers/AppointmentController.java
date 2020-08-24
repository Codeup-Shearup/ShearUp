package com.codeup.shearup.controllers;

import com.codeup.shearup.models.Appointment;
import com.codeup.shearup.models.Review;
import com.codeup.shearup.repositories.AppointmentRepository;
import com.codeup.shearup.repositories.ReviewRepository;
import com.codeup.shearup.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppointmentController {

    private final AppointmentRepository appointmentDao;

    public AppointmentController(AppointmentRepository appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    // All Appointments
    @GetMapping("/appointments")
    public String index(Model model) {
        List<Appointment> myAppointment = appointmentDao.findAll();
//        Review pulledReview = reviewsDao.getOne(id);
        model.addAttribute("appointment", myAppointment);
        return "appointments/index";
    }

    // Viewing a single Appointment
    @GetMapping("/appointments/{id}")
    public String show(@PathVariable long id, Model model) {
        Appointment pulledAppointment = appointmentDao.getOne(id);
        model.addAttribute("appointment", pulledAppointment);
        return "appointments/show";
    }


    //Creating Appointment
    @GetMapping("/appointment/create")
    public String showCreateAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "appointments/create";
    }

    //Creating Appointment
//    @PostMapping("appointments/create")
//    public String createReview(@ModelAttribute Appointment appointment) {
////
////        Appointment appointment = appointmentDao.getOne(1L);
//        appointment.setAppointmentDate();
//        appointmentDao.save(appointment);
//        return "redirect:/appointments";
//    }
}
