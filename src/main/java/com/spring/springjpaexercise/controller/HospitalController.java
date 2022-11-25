package com.spring.springjpaexercise.controller;

import com.spring.springjpaexercise.domain.dto.HospitalResponse;
import com.spring.springjpaexercise.domain.dto.ReviewCreateRequest;
import com.spring.springjpaexercise.domain.dto.ReviewCreateResponse;
import com.spring.springjpaexercise.service.HospitalService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    private HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @ApiOperation(value = "hospital 리스트 받기")
    @GetMapping("/list")
    public ResponseEntity<List<HospitalResponse>> listAll(){
        List<HospitalResponse> hospitalList = hospitalService.find();
        return ResponseEntity.ok().body(hospitalList);
    }

    @ApiOperation(value="병원 리뷰 등록하기")
    @PostMapping("/{id}/review")
    public ResponseEntity<ReviewCreateResponse> addReview(@PathVariable Long id, @RequestBody ReviewCreateRequest reviewCreateRequest){
        ReviewCreateResponse reviewCreateResponse = hospitalService.addReview(id,reviewCreateRequest);
        return ResponseEntity.ok().body(reviewCreateResponse);
    }
}
