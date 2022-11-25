package com.spring.springjpaexercise.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewCreateResponse {
    private String hospitalName;
    private String title;
    private String content;
    private String patientName;
    private String status;
}
