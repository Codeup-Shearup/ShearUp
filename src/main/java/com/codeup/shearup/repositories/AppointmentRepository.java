package com.codeup.shearup.repositories;

import com.codeup.shearup.models.Appointment;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;

// Ad is the reference type of the entity to CRUD
// Long is the reference type for the primary key of Ad
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
//    List<Appointments> findAppointmentByUserId(long id);

}
