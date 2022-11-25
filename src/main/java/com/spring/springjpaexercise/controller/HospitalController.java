package com.spring.springjpaexercise.controller;

import com.spring.springjpaexercise.domain.dto.HospitalResponse;
import com.spring.springjpaexercise.domain.dto.ReviewCreateRequest;
import com.spring.springjpaexercise.domain.dto.ReviewCreateResponse;
import com.spring.springjpaexercise.domain.dto.ReviewResponse;
import com.spring.springjpaexercise.service.HospitalService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospital")
public class HospitalController {

    private HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @ApiOperation(value = "hospital 리스트 받기")
    @GetMapping("/list")
    public ResponseEntity<List<HospitalResponse>> listAll(){
        List<HospitalResponse> hospitalList = hospitalService.findAll();
        return ResponseEntity.ok().body(hospitalList);
    }

    @ApiOperation(value="병원 리뷰 등록하기")
    @PostMapping("/{id}/review")
    public ResponseEntity<ReviewCreateResponse> addReview(@PathVariable Long id, @RequestBody ReviewCreateRequest reviewCreateRequest){
        ReviewCreateResponse reviewCreateResponse = hospitalService.addReview(id,reviewCreateRequest);
        return ResponseEntity.ok().body(reviewCreateResponse);
    }
    @ApiOperation(value="병원 리뷰 보기")
    @GetMapping("/{id}/review")
    public ResponseEntity<List<ReviewResponse>> getReview(@PathVariable Long id){
        List<ReviewResponse> reviewResponseList = hospitalService.findReview(id);
        return ResponseEntity.ok().body(reviewResponseList);
    }
}
