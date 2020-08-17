package com.codeup.shearup.models;

import javax.persistence.*;

@Entity
@Table(name = "barber_details")
public class BarberDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String bio;



}
