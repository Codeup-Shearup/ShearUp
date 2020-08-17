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

    @Column(nullable = false, columnDefinition = "TINYINT(1) UNSIGNED")
    private int is_barber;

    //NEED HELP WITH FK RELATIONSHIP // may have solved it
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user_id service_id")
    private List<Appointment>  barber_details_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIs_barber() {
        return is_barber;
    }

    public void setIs_barber(int is_barber) {
        this.is_barber = is_barber;
    }

    public List<Appointment> getBarber_details_id() {
        return barber_details_id;
    }

    public void setBarber_details_id(List<Appointment> barber_details_id) {
        this.barber_details_id = barber_details_id;
    }


}
