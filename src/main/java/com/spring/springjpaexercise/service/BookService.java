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
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<BookResponse> find() {
        List<Book> books = bookRepository.findAll();
        List<BookResponse> bookResponseList= new ArrayList<>();
        for(Book book : books){
            Long authorId = book.getAuthorId();
            String authorName = authorRepository.findById(authorId).get().getName();
            BookResponse bookResponse = Book.of(book, authorName);
            bookResponseList.add(bookResponse);
        }
        return bookResponseList;
    }
}
