package com.codeup.shearup.models;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true, length = 255)
    private String filestackUrl;

    //NEED SERVICE ID FOREIGN KEY
    // Get entire service object
    //OneToMany relationship
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    // Zero argument Constructor
    public Image() {

    }

    //Constructor
    public Image(long id, String filestackUrl, Service service) {
        this.id = id;
        this.filestackUrl = filestackUrl;
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
        return filestackUrl;
    }

    public void setFilestack_url(String filestackUrl) {
        this.filestackUrl = filestackUrl;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
