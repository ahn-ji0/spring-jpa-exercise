package com.spring.springjpaexercise.controller;

import com.spring.springjpaexercise.domain.dto.ReviewResponse;
import com.spring.springjpaexercise.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponse> find(@PathVariable Long id){
        ReviewResponse reviewResponse = reviewService.find(id);
        return ResponseEntity.ok().body(reviewResponse);
    }
}
