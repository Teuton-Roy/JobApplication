package com.example.JobApplication.Reviews.Implementation;

import com.example.JobApplication.Reviews.Review;
import com.example.JobApplication.Reviews.ReviewRepository;
import com.example.JobApplication.Reviews.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        /*use custome methods findByCompanyId so create a method in ReviewRepository*/
        return reviews;
    }
}
