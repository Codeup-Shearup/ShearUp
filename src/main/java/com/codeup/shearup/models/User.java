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

    @Column(nullable = false, columnDefinition = "TINYINT")
    private boolean is_barber;

    //NEED HELP WITH FK RELATIONSHIP // may have solved it
    // Relationship with Appointments Table One to Many
    //Grabs users id and service id from appointments Table
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersId")
//    private List<Appointment>  barber_details_id;

    @OneToOne(mappedBy = "barber_details", cascade = CascadeType.ALL)
    private BarberDetail barber_details_id;



//    @JoinTable(
//            name="barber_details")
//            joinColumns={@JoinColumn(name="post_id")},
//            inverseJoinColumns={@JoinColumn(name="category_id")}
//    )
    
    public User() {

    }
    
    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        username = copy.username;
        first_name = copy.first_name;
        last_name = copy.last_name;
        email = copy.email;
        password = copy.password;
        is_barber = copy.is_barber;
        barber_details_id = copy.barber_details_id;
    }
    
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

    public boolean getIs_barber() {
        return is_barber;
    }

    public void setIs_barber(boolean is_barber) {
        this.is_barber = is_barber;
    }

    public boolean isIs_barber() {
        return is_barber;
    }

    public BarberDetail getBarber_details_id() {
        return barber_details_id;
    }

    public void setBarber_details_id(BarberDetail barber_details_id) {
        this.barber_details_id = barber_details_id;
    }
}
