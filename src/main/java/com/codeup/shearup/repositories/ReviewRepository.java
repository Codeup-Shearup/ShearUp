package com.codeup.shearup.repositories;

import com.codeup.shearup.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
//    List<Review> findReviewsByUserId(long id);

}
