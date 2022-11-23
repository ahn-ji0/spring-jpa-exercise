package com.spring.springjpaexercise.repository;

import com.spring.springjpaexercise.domain.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
