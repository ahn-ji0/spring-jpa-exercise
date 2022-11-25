package com.spring.springjpaexercise.repository;

import com.spring.springjpaexercise.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
