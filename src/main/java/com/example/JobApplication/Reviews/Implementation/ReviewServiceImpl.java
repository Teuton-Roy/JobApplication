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
    public void addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company != null){
            review.setCompany(company);
            reviewRepository.save(review);
        }
    }


}
