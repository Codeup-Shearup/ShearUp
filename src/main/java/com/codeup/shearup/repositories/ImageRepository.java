package com.codeup.shearup.repositories;

import com.codeup.shearup.models.Image;
import com.codeup.shearup.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query("SELECT i FROM Image i WHERE i.service = ?1")
    List<Image> findImageById(Service Id);
}
