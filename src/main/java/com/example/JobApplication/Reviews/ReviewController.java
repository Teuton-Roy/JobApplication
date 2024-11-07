package com.example.JobApplication.Reviews;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /*add a method to get all reviews for a company*/
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId),
                HttpStatus.OK);
    }

    /*Create method*/
    @PostMapping("/createReviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review){
//      reviewService.addReview(companyId, review);
//      return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
//      logic for, review is manage if the company doesn't exit

        boolean isReviewSaved = reviewService.addReview(companyId, review);
        if (isReviewSaved) {
            return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not saved!",HttpStatus.NOT_FOUND);
    }

    /*add a method to get a specific review for a specific company*/
    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(companyId, reviewId), HttpStatus.OK);
    }
}
