package com.spring.springjpaexercise.repository;

import com.spring.springjpaexercise.domain.entity.Author;
import com.spring.springjpaexercise.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
