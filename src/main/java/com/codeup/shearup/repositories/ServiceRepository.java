package com.codeup.shearup.repositories;

import com.codeup.shearup.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {

}
