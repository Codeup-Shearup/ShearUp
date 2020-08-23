package com.codeup.shearup.repositories;

import com.codeup.shearup.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	// ==DEBUGGING DON'T DELETE==
//	List<User> findAllByBarber(boolean isBarber);
}
