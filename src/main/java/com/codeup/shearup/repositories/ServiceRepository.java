package com.codeup.shearup.repositories;

import com.codeup.shearup.models.BarberDetail;
import com.codeup.shearup.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    List<Service> findAllByBarberDetail(BarberDetail barberDetail);

}
