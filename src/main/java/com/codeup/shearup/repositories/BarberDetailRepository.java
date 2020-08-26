package com.codeup.shearup.repositories;


import com.codeup.shearup.models.BarberDetail;
import com.codeup.shearup.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface BarberDetailRepository extends JpaRepository<BarberDetail, Long> {

}
