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
    @JoinColumn(name = "user_id", referencedColumnName = "users")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "users")
    private User serviceId;




}
