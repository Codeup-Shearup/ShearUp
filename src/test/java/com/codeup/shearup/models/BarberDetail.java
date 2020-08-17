package com.codeup.shearup.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "barber_details")
public class BarberDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String bio;

    // Need 2 foreign key relationships location id fk


    // image id fk


}
