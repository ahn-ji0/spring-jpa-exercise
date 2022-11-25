package com.spring.springjpaexercise.domain.entity;

import com.spring.springjpaexercise.domain.dto.HospitalResponse;
import com.spring.springjpaexercise.domain.dto.ReviewResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "hospital")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "hospital",fetch = FetchType.LAZY)
    private List<Review> reviews;
    public static HospitalResponse of(Hospital hospital){
        return HospitalResponse.builder()
                .name(hospital.getName())
                .address(hospital.getAddress())
                .reviews(hospital.getReviews().stream().map(review -> ReviewResponse.builder()
                        .hospitalName(review.getHospital().getName())
                        .title(review.getTitle())
                        .content(review.getContent())
                        .patientName(review.getPatientName()).build()).collect(Collectors.toList()))
                .build();
    }
}
