package com.codeup.shearup.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //SERVICE SHOULD NOT BE UNIQUE
    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
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
    public Service(long id, String title, String description, double price, int duration, BarberDetail barberDetail) {
        this.id = id;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }




}
