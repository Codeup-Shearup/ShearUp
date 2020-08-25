package com.codeup.shearup.repositories;

import com.codeup.shearup.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	User findById(long id);
	// ==DEBUGGING DON'T DELETE==
	
//	@Query(value = "SELECT users.barber_detail_id from users JOIN barber_details ON users.barber_detail_id = "
//	               + "barber_details.id", nativeQuery = true)
	@Query("from User u where u.isBarber = true")
	List<User> findAllBarbers();
}
