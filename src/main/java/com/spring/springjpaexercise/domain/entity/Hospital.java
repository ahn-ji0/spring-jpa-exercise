package com.spring.springjpaexercise.domain.entity;

import com.spring.springjpaexercise.domain.dto.HospitalResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
                .name(hospital.name)
                .address(hospital.address)
                .build();
    }
}
