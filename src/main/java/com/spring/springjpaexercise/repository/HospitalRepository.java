가package com.spring.springjpaexercise.repository;

import com.spring.springjpaexercise.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
