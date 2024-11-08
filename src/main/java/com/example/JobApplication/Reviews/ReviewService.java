package com.example.JobApplication.Reviews;

import java.util.*;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
//    void addReview(Long companyId, Review review);
    boolean addReview(Long companyId, Review review); //boolean because, if company doesn't exit then how handel the review...
    Review getReview(Long companyId, Long reviewId);
    boolean updateReview(Long companyId, Long reviewId, Review review);
}
