package com.spring.springjpaexercise.domain.entity;

import com.spring.springjpaexercise.domain.dto.BookResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "book")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @Column(name="author_id")
    private Author author;

    public static BookResponse of(Book book){
        return new BookResponse(book.getId(),book.getName(), book.getAuthor().getName());
    }
}
