package com.codeup.shearup.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100, unique = true)
    private String username;

    @Column(nullable = false, length = 50, unique = false)
    private String first_name;

    @Column(nullable = false, length = 50, unique = false)
    private String last_name;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 50, unique = true)
    private String password;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private int is_barber;

    //NEED HELP WITH FK RELATIONSHIP // may have solved it
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user_id service_id")
    private List<Appointment>  barber_details_id;




}
