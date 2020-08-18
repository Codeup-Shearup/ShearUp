package com.codeup.shearup.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "barber_details")
public class BarberDetail {
    //Not accepting Long, Integer, int and long data Types
    //for database OneToOne join
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // One to one not included because already defined in User class in Models

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String bio;

    // Need 2 foreign key relationships location id fk
    //one to one barber details to location
    @OneToOne(mappedBy = "locations", cascade = CascadeType.ALL)
    private Location location;
    // image id fk
    @OneToMany(mappedBy = "images", cascade = CascadeType.ALL)
    private List<Image> images;
    //one to many barber details to images


}
