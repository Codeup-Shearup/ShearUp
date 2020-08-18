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


    //Zero argument Constructor
    public Location() {

    }

    //Constructor
    public Location(long id, String address_one, String address_two, String city, String state, int zip_code) {
        this.id = id;
        this.address_one = address_one;
        this.address_two = address_two;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
    }

    //GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress_one() {
        return address_one;
    }

    public void setAddress_one(String address_one) {
        this.address_one = address_one;
    }

    public String getAddress_two() {
        return address_two;
    }

    public void setAddress_two(String address_two) {
        this.address_two = address_two;
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
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }
}
