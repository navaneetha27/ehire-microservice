package com.microserviceproject.reviewms.repository;

import com.microserviceproject.reviewms.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository  extends JpaRepository<Review, Long> {
    List<Review> findByCompanyId(Long id);
}
