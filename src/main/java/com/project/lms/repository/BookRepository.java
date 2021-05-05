package com.project.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.lms.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> getBooksBy();
    Book getBookById(Long id);
    List<Book> getBooksByNameContainsOrAuthorContainsOrDescriptionContains(String name, String author, String description);
}
