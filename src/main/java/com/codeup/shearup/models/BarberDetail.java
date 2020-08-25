package com.codeup.shearup.models;

import org.hibernate.boot.model.source.spi.ColumnsAndFormulasSourceContainer;

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

    @Column(columnDefinition = "LONGTEXT")
    private String bio;

    @Column(columnDefinition = "INT UNSIGNED")
    private int phone;

    // Need 2 foreign key relationships location id fk
    //one to one barber details to location
    @OneToOne
    private Location location;
    // image id fk
    //Barber should be only OneToOne 1 profile image

    //TODO: ==========MAYBE CHANGE TO PROFILEIMAGE=========
    //One profile image per Barber
    @OneToOne
    private Image image;
    //one to many barber details to images

    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "barberDetail")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "barberDetail", fetch = FetchType.EAGER)
    private List<Service> services;

    //=======TODO: UPDATE GETTERS AND SETTERS========


    //Empty Constructor
    public BarberDetail(){ }


    //====BARBER DETAILS USER CONTROLLER ONLY ACCEPTS ID======//
    public BarberDetail(long id) {
        this.id = id;
    }

    // Constructor


    public BarberDetail(long id, String bio, Location location, Image image) {
        this.id = id;
        this.bio = bio;
        this.location = location;
        this.image = image;
    }

    public BarberDetail(long id, String bio, int phone, Location location, Image image, User user, List<Service> services) {
        this.id = id;
        this.bio = bio;
        this.phone = phone;
        this.location = location;
        this.image = image;
        this.user = user;
        this.services = services;
    }

    //GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
