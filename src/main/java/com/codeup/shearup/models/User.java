package com.codeup.shearup.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false, length = 50, unique = false)
    private String firstName;

    @Column(nullable = false, length = 50, unique = false)
    private String lastName;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 50, unique = false)
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
    public User(long id, String username, String firstName, String lastName, String email, String password, boolean isBarber, BarberDetail barberDetail) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isBarber = isBarber;
        this.barberDetail = barberDetail;
    }

    //COPY OF FOR SPRING
    public User(User copy) {
        this.id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        this.username = copy.username;
        this.firstName = copy.firstName;
        this.lastName = copy.lastName;
        this.email = copy.email;
        this.password = copy.password;
        this.isBarber = copy.isBarber;
        this.barberDetail = copy.barberDetail;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
