package com.example.JobApplication.Reviews;

import java.util.*;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    void addReview(Long companyId, Review review);
}
