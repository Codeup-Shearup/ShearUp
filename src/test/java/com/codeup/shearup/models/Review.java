package com.codeup.shearup.models;

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

    //APPOINTMENT ID FOREIGN KEY NEEDED

}
