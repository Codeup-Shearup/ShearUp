package com.codeup.shearup.models;

import org.springframework.jdbc.core.CallableStatementCallback;

import javax.persistence.*;

@Entity
@Table(name="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length =50)
    private String title;

    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String content;

    @Column(nullable = false, columnDefinition = "DECIMAL(1,1)")
    private double rating;

    //IMAGE ID FOREIGN KEY NEEDED
    @OneToOne(mappedBy = "images", cascade = CascadeType.ALL)
    private Image image;
    //APPOINTMENT ID FOREIGN KEY NEEDED
    @OneToOne(mappedBy = "appointments", cascade = CascadeType.ALL)
    private Appointment appointment;

    //Zero argument constructor
    public Review () {

    }
    //Constructor
    public Review(long id, String title, String content, double rating, Image image, Appointment appointment) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.image = image;
        this.appointment = appointment;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
