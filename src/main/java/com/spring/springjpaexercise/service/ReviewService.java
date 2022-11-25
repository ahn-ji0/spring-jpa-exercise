package com.spring.springjpaexercise.service;

import com.spring.springjpaexercise.domain.dto.ReviewResponse;
import com.spring.springjpaexercise.domain.entity.Review;
import com.spring.springjpaexercise.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public ReviewResponse find(Long id){
        Review review = reviewRepository.findById(id).orElseThrow(()-> new RuntimeException("id에 해당하는 리뷰가 없습니다."));
        return new ReviewResponse(review.getHospital().getName(),review.getTitle(), review.getContent(), review.getPatientName());
    }
}
