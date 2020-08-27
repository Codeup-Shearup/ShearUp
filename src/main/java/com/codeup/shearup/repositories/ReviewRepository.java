package com.codeup.shearup.repositories;

import com.codeup.shearup.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	@Query("from Review r where r.barberDetail = ?1")
    List<Review> findAllReviewsByBarber(long barberDetailsId);
	
	@Query("from Review r where r.author.id = ?1")
	List<Review> findAllReviewsByAuthor(long userId);

}
