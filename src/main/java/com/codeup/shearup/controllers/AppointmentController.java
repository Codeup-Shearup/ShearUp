package com.codeup.shearup.controllers;

import com.codeup.shearup.models.Appointment;
import com.codeup.shearup.models.User;
import com.codeup.shearup.repositories.AppointmentRepository;
import com.codeup.shearup.repositories.BarberDetailRepository;
import com.codeup.shearup.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppointmentController {

    private final AppointmentRepository appointmentDao;
    private final UserRepository userDao;
    private final BarberDetailRepository barberDetailDao;

    public AppointmentController(AppointmentRepository appointmentDao, UserRepository userDao, BarberDetailRepository barberDetailDao) {
        this.appointmentDao = appointmentDao;
        this.userDao = userDao;
        this.barberDetailDao = barberDetailDao;
    }

    // All Appointments
    @GetMapping("/appointments")
    public String index(Model model) {
        List<Appointment> myAppointment = appointmentDao.findAll();
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
    @GetMapping("/appointments/create/{id}")
    public String showCreateAppointmentForm(Model model, @PathVariable Long id) {
        User barber = userDao.findByBarberDetail(barberDetailDao.getOne(id));
        System.out.println(barber);
        model.addAttribute("barber", barber);
        model.addAttribute("appointment", new Appointment());
        return "appointments/create";
    }

    //Creating Appointment
    @PostMapping("/appointments/create")
    public String createAppointment(@ModelAttribute Appointment appointment, @RequestParam(name="barberId") Long barberId) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User barber = userDao.findByBarberDetail(barberDetailDao.getOne(barberId));
        appointment.setBarberDetail(barber.getBarberDetail());
        appointment.setUser(loggedInUser);
//        Appointment appointment = appointmentDao.getOne(1L);
        appointment.setCreateDateTime(appointment.getCreateDateTime());
        appointmentDao.save(appointment);
        return "redirect:/appointments";
    }

    //Delete Review GET
    @GetMapping("/appointments/{id}/delete")
    public String deletePage(@PathVariable Long id, Model model){
        Appointment pulledAppointment = appointmentDao.getOne(id);
        model.addAttribute("appointment", pulledAppointment);
        return "appointments/delete";
    }

    //Deleting Review POST
    @PostMapping("/appointments/{id}/delete")
    public String deleteAppointment(@ModelAttribute Appointment appointment){
        Appointment deleteAppointment = appointmentDao.getOne(appointment.getId());
        appointmentDao.delete(deleteAppointment);
        return "redirect:/appointments";
    }

}
