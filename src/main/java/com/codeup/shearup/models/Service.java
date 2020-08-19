package com.codeup.shearup.models;

import javax.persistence.*;
import java.util.List;

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
    @JoinColumn(name = "barber_details_id") //_id was here before
    private BarberDetail barberDetail;
    // mappedBy references service on line 20 in Image class (ManyToOne)


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "service")
    private List<Image> images;

    //Zero argument Constructor
    public Service () {

    }
    //Constructor
    public Service(long id, String name, String description, double price, int duration, BarberDetail barberDetail) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.barberDetail = barberDetail;
    }



    //GETTERS AND SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public BarberDetail getBarberDetail() {
        return barberDetail;
    }

    public void setBarberDetail(BarberDetail barberDetail) {
        this.barberDetail = barberDetail;
    }
}
