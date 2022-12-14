package com.spring.springjpaexercise.service;

import com.spring.springjpaexercise.domain.dto.HospitalResponse;
import com.spring.springjpaexercise.domain.dto.ReviewCreateRequest;
import com.spring.springjpaexercise.domain.dto.ReviewCreateResponse;
import com.spring.springjpaexercise.domain.dto.ReviewResponse;
import com.spring.springjpaexercise.domain.entity.Hospital;
import com.spring.springjpaexercise.domain.entity.Review;
import com.spring.springjpaexercise.repository.HospitalRepository;
import com.spring.springjpaexercise.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;

    public HospitalService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<HospitalResponse> findAll() {
        List<Hospital> hospitals = hospitalRepository.findAll();
        List<HospitalResponse> hospitalResponseList = hospitals.stream().map(hospital -> Hospital.of(hospital)).collect(Collectors.toList());

        return hospitalResponseList;
    }
    public ReviewCreateResponse addReview(Long id, ReviewCreateRequest reviewCreateRequest){
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        Review review = Review.builder()
                .hospital(hospital.get())
                .title(reviewCreateRequest.getTitle())
                .content(reviewCreateRequest.getContent())
                .patientName(reviewCreateRequest.getPatientName())
                .build();
        Review savedReview = reviewRepository.save(review);
        return new ReviewCreateResponse(savedReview.getHospital().getName(),savedReview.getTitle(), savedReview.getContent(),savedReview.getPatientName(),"리뷰 등록 성공!");
    }
    public List<ReviewResponse> findReview(Long id){
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(()->new RuntimeException("id에 해당하는 병원이 없습니다"));
        List<Review> reviewList = hospital.getReviews();
        List<ReviewResponse> reviewResponseList = reviewList.stream().map(review -> Review.of(review)).collect(Collectors.toList());
        return reviewResponseList;
    }
    public HospitalResponse findById(Long id){
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(()->new RuntimeException("id에 해당하는 병원이 없습니다"));
        HospitalResponse hospitalResponse = Hospital.of(hospital);
        return hospitalResponse;
    }
}
