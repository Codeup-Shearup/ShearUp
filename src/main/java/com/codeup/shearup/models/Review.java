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

}
