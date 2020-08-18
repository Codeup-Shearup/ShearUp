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

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String bio;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "barber_details")
    private List<Service> services;

    //=======TODO: UPDATE GETTERS AND SETTERS========


    //Empty Constructor
    public BarberDetail(){

    }

    // Constructor


    public BarberDetail(long id, String bio, Location location, Image image, List<Service> services) {
        this.id = id;
        this.bio = bio;
        this.location = location;
        this.image = image;
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

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
