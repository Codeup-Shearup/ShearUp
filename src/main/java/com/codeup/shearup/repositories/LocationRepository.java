package com.codeup.shearup.repositories;

import com.codeup.shearup.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
