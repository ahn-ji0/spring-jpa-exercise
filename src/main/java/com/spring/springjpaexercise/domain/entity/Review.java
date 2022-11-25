package com.spring.springjpaexercise.domain.entity;

import com.spring.springjpaexercise.domain.dto.ReviewResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "hospital_review")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    private String title;
    private String content;

    @Column(name = "patient_name")
    private String patientName;

    public static ReviewResponse of(Review review){
        return ReviewResponse.builder()
                .title(review.getTitle())
                .content(review.getContent())
                .patientName(review.getPatientName())
                .build();
    }
}
