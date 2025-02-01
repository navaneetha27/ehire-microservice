package com.microserviceproject.reviewms.service;

import com.microserviceproject.reviewms.model.Review;
import com.microserviceproject.reviewms.repository.ReviewRepository;
import com.microserviceproject.reviewms.service.impl.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService  implements ReviewServiceImpl {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReview(Long id) {
        List<Review> reviews = reviewRepository.findByCompanyId(id);
        return reviews;
    }

    @Override
    public Review getReviewById(Long id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if(reviewOptional.isPresent()){
            return reviewOptional.get();
        }
        return null;
    }

    @Override
    public boolean postReviews(Long companyId, Review review) {

        if(review != null && companyId != null){
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReview(Review companyReview, Long reviewId) {
        if(reviewRepository.existsById(reviewId)){
            reviewRepository.save(companyReview);
            return true;

        }
        return false;
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        if(reviewRepository.existsById(reviewId)){
            reviewRepository.deleteById(reviewId);
            return true;

        }
        return false;
    }
}
