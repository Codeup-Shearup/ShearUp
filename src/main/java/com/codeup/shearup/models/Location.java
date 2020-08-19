package com.codeup.shearup.models;

import javax.persistence.*;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255)
    private String addressOne;

    @Column(nullable = false, length = 255)
    private String addressTwo;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false, columnDefinition = "CHAR(2) DEFAULT 'XX'")
    private String state;

    @Column(nullable = false, columnDefinition = "INT UNSIGNED")
    private int zipCode;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "location")
    private BarberDetail barber;


    //Zero argument Constructor
    public Location() {

    }

    //Constructor
    public Location(long id, String addressOne, String addressTwo, String city, String state, int zipCode, BarberDetail barber) {
        this.id = id;
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.barber = barber;
    }

    //GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress_one() {
        return addressOne;
    }

    public void setAddress_one(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getAddress_two() {
        return addressTwo;
    }

    public void setAddress_two(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip_code() {
        return zipCode;
    }

    public void setZip_code(int zipCode) {
        this.zipCode = zipCode;
    }
}
