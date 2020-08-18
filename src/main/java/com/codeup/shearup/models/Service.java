package com.codeup.shearup.models;

import javax.persistence.*;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column(nullable = false, length = 50, unique = true)
    private String name;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "DECIMAL(4,2)")
    private double price;

    @Column(nullable = false, columnDefinition = "INTEGER")
    private int duration;

    //BARBER DETAILS FOREIGN KEY NEEDED HERE
    @ManyToOne
    @JoinColumn(name = "barber_details_id")
    private BarberDetail barberDetail;


}
