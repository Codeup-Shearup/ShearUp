package com.codeup.shearup.repositories;

import com.codeup.shearup.models.BarberDetail;
import com.codeup.shearup.models.Service;
import com.codeup.shearup.models.User;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {


}