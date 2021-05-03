package com.project.lms.service;

import com.project.lms.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    Book getBookById(Long id);
    List<Book> getBooksByNameOrAuthorOrDesc(String name, String author, String description);
}
