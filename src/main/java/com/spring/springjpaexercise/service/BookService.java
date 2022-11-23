package com.spring.springjpaexercise.service;

import com.spring.springjpaexercise.domain.dto.BookResponse;
import com.spring.springjpaexercise.domain.entity.Author;
import com.spring.springjpaexercise.domain.entity.Book;
import com.spring.springjpaexercise.repository.AuthorRepository;
import com.spring.springjpaexercise.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookResponse> find() {
        List<Book> books = bookRepository.findAll();
        List<BookResponse> bookResponseList= new ArrayList<>();
        for(Book book : books){
            BookResponse bookResponse = Book.of(book);
            bookResponseList.add(bookResponse);
        }
        return bookResponseList;
    }
}
