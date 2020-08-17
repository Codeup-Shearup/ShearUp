package com.codeup.shearup.models;

import javax.persistence.*;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String address_one;

    @Column(nullable = false, length = 50)
    private String address_two;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false, columnDefinition = "CHAR(2) DEFAULT 'XX'")
    private String state;

    @Column(nullable = false, columnDefinition = "INT UNSIGNED")
    private int zip_code;



}
