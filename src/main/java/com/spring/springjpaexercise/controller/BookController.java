package com.spring.springjpaexercise.controller;

import com.spring.springjpaexercise.domain.dto.BookResponse;
import com.spring.springjpaexercise.domain.entity.Book;
import com.spring.springjpaexercise.repository.AuthorRepository;
import com.spring.springjpaexercise.repository.BookRepository;
import com.spring.springjpaexercise.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ApiOperation(value = "Book 리스트 받기")
    @GetMapping("/list")
    public ResponseEntity<List<BookResponse>> listAll(){
        List<BookResponse> bookList = bookService.find();
        return ResponseEntity.ok().body(bookList);
    }
}
