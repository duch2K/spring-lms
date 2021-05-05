package com.project.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.project.lms.entity.Book;
import com.project.lms.service.implement.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    // GET
    @GetMapping("")
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/find")
    public List<Book> getByNameOrAuthorOrDescription(
            @RequestParam("name") String name,
            @RequestParam("author") String author,
            @RequestParam("description") String description)
    {
        return bookService.getBooksByNameOrAuthorOrDesc(name, author, description);
    }

    @DeleteMapping
    public void removeBookById(Long id) {
        bookService.removeBook(id);
    }
}
