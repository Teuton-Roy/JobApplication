package com.example.JobApplication.Reviews.Implementation;

import com.example.JobApplication.Reviews.Review;
import com.example.JobApplication.Reviews.ReviewRepository;
import com.example.JobApplication.Reviews.ReviewService;
import com.example.JobApplication.company.Company;
import com.example.JobApplication.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        /*use custome methods findByCompanyId so create a method in ReviewRepository*/
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        //Logic: call the getAllReviews() and get all the reviews in table, then filter it by companyId.
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream() //converting this list into a stream for filtering purpose
                .filter(review -> review.getId().equals(reviewId)) //apply the filter on stream where I specify the condition as review.getId().equals(reviewId)
                .findFirst() //getting the first_one from the filtered stream
                .orElse(null); // null means when there is no object found
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if(companyService.getCompanyById(companyId) != null){
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(companyService.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)){
            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            companyService.updateCompany(company, companyId);
            review.setCompany(null); //this removes all the references from the company side as well from the review side
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
