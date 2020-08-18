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
    private boolean isBarber;

    //NEED HELP WITH FK RELATIONSHIP // may have solved it
    // Relationship with Appointments Table One to Many
    //Grabs users id and service id from appointments Table
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersId")
//    private List<Appointment>  barber_details_id;

    @OneToOne
    private BarberDetail barberDetail;



//    @JoinTable(
//            name="barber_details")
//            joinColumns={@JoinColumn(name="post_id")},
//            inverseJoinColumns={@JoinColumn(name="category_id")}
//    )

    //ZERO ARGUMENT CONSTRUCTOR
    public User() {

    }
    //CONSTRUCTOR
    public User(long id, String username, String first_name, String last_name, String email, String password, boolean isBarber, BarberDetail barberDetail) {
        this.id = id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.isBarber = isBarber;
        this.barberDetail = barberDetail;
    }

    //COPY OF FOR SPRING
    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        username = copy.username;
        first_name = copy.first_name;
        last_name = copy.last_name;
        email = copy.email;
        password = copy.password;
        isBarber = copy.isBarber;
        barberDetail = copy.barberDetail;
    }

    //GETTERS AND SETTERS

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

    public boolean isBarber() {
        return isBarber;
    }

    public void setBarber(boolean barber) {
        isBarber = barber;
    }

    public BarberDetail getBarberDetail() {
        return barberDetail;
    }

    public void setBarberDetail(BarberDetail barberDetail) {
        this.barberDetail = barberDetail;
    }
}
