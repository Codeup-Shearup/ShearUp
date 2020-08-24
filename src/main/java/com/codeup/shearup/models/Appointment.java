package com.codeup.shearup.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, columnDefinition = "DATE NOT NULL")
    private Date appointmentDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

//    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
//    private Review reviews;


    //Zero argument constructor
    public Appointment() {

    }
    //------COMMENTED OUT REVIEWS-----
    //CONSTRUCTOR
    public Appointment(long id, Date appointmentDate, User user, Service service) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.user = user;
        this.service = service;
    }

    //------COMMENTED OUT REVIEWS-----
    //NEEDS TO BE HERE FOR NOW PER BRANCE -RAMON
    public Appointment(Date appointmentDate, User user, Service service) {

        this.appointmentDate = appointmentDate;
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

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
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
