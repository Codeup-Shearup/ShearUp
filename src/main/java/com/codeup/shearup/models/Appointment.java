package com.codeup.shearup.models;

import org.hibernate.annotations.CreationTimestamp;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(nullable = false, columnDefinition = "DATETIME NOT NULL")
    @Column
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column (nullable = false, columnDefinition = "TEXT")
    private String note;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    // Barber id for Appointment
    @ManyToOne
    @JoinColumn(name = "barber_details_id")
    private BarberDetail barberDetail;

    //---Commented out Service-----//
//    @ManyToOne
//    @JoinColumn(name = "service_id")
//    private Service service;

//    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
//    private Review reviews;


    //Zero argument constructor
    public Appointment() {

    }
    //------COMMENTED OUT REVIEWS-----
    //CONSTRUCTOR
    public Appointment(long id, LocalDateTime createDateTime, User user, String note, BarberDetail barberDetail) {
        this.id = id;
        this.user = user;
        this.createDateTime = createDateTime;
        this.note = note;
        this.barberDetail = barberDetail;
//        this.appointmentDate = appointmentDate;
//        this.service = service;
    }

    //------COMMENTED OUT REVIEWS-----//
    //NEEDS TO BE HERE FOR NOW PER BRANCE -RAMON
    public Appointment(Date appointmentDate, User user, Service service) {
//        this.appointmentDate = appointmentDate;
        this.user = user;
//        this.service = service;
    }


    //GETTERS AND SETTERS


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BarberDetail getBarberDetail() {
        return barberDetail;
    }

    public void setBarberDetail(BarberDetail barberDetail) {
        this.barberDetail = barberDetail;
    }

    //    public Date getAppointmentDate() {
//        return appointmentDate;
//    }
//
//    public void setAppointmentDate(Date appointmentDate) {
//        this.appointmentDate = appointmentDate;
//    }

//    public Service getService() {
//        return service;
//    }
//
//    public void setService(Service service) {
//        this.service = service;
//    }

}
