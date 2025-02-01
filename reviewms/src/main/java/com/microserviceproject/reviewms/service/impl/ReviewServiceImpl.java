package com.microserviceproject.reviewms.service.impl;


import com.microserviceproject.reviewms.model.Review;

import java.util.List;

public interface ReviewServiceImpl {

    List<Review> getAllReview(Long id);
    Review getReviewById(Long Id);

    boolean postReviews(Long companyId, Review review);

    boolean updateReview(Review companyReview, Long reviewId);

    boolean deleteReview(Long reviewId);
}
