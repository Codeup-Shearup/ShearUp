package com.codeup.shearup.models;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true, length = 255)
    private String filestack_url;

    //NEED SERVICE ID FOREIGN KEY
    // Get entire service object
    @OneToOne(mappedBy = "services", cascade = CascadeType.ALL)
    private Service service;

}
