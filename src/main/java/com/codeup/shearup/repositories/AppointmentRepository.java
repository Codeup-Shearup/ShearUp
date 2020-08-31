package com.codeup.shearup.repositories;

import com.codeup.shearup.models.Appointment;
import com.codeup.shearup.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Ad is the reference type of the entity to CRUD
// Long is the reference type for the primary key of Ad
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
//    List<Appointments> findAppointmentByUserId(long id);

    @Query("from Review r where r.barberDetail.id = ?1")
    List<Appointment> findAllAppointmentsByBarber(long barberDetailsId);

    @Query("from Review r where r.author.id = ?1")
    List<Appointment> findAllAppointmentsByAuthor(long userId);

}
