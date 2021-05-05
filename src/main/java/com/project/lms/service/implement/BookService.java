package com.project.lms.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.lms.entity.Book;
import com.project.lms.repository.BookRepository;
import com.project.lms.service.IBookService;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.getBooksBy();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.getBookById(id);
    }

    @Override
    public List<Book> getBooksByNameOrAuthorOrDesc(String name, String author, String description) {
        return bookRepository.getBooksByNameContainsOrAuthorContainsOrDescriptionContains(name, author, description);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public void decBookQuantitySave(Book book) {
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);
    }

    public void incBookQuantitySave(Book book) {
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
    }

    public void removeBook(Long id) {
        bookRepository.deleteById(id);
    }
}
