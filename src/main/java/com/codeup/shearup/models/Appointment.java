package com.codeup.shearup.models;

import javax.persistence.*;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, columnDefinition = "DATETIME NOT NULL")
    private int appointment_date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    //Zero argument constructor
    public Appointment() {

    }

    //CONSTRUCTOR
    public Appointment(long id, int appointment_date, User user, Service service) {
        this.id = id;
        this.appointment_date = appointment_date;
        this.user = user;
        this.service = service;
    }

    //GETTERS AND SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(int appointment_date) {
        this.appointment_date = appointment_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
