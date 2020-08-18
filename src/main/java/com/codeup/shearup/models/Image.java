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

    // Zero argument Constructor
    public Image() {

    }

    //Constructor
    public Image(long id, String filestack_url, Service service) {
        this.id = id;
        this.filestack_url = filestack_url;
        this.service = service;
    }

    //GETTERS AND SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilestack_url() {
        return filestack_url;
    }

    public void setFilestack_url(String filestack_url) {
        this.filestack_url = filestack_url;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
