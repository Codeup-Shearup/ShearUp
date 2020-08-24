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

    @Column(nullable = false, columnDefinition = "DECIMAL(2,1)")
    private double rating;

    @OneToOne
    private Image image;

    // DISCONNECTED REVIEW TO APPOINTMENTS //
//    @OneToOne
//    @JoinColumn(name = "appointment_id") //_id was here before
//    private Appointment appointment;


    // Barber id for Review
    @ManyToOne
    @JoinColumn(name = "barber_details_id")
    private BarberDetail barberDetail;

    // Review tied to user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;


    //Zero argument constructor
    public Review () {

    }
    //Constructor
    public Review(long id, String title, String content, double rating, Image image, BarberDetail barberDetail, User author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.image = image;
        this.barberDetail = barberDetail;
        this.author = author;
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

    public BarberDetail getBarberDetail() {
        return barberDetail;
    }

    public void setBarberDetail(BarberDetail barberDetail) {
        this.barberDetail = barberDetail;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
//    public Image getImage() {
//        return image;
//    }

//    public void setImage(Image image) {
//        this.image = image;
//    }

}
