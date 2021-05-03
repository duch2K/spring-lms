package com.project.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.project.lms.entity.Book;
import com.project.lms.entity.Collection;
import com.project.lms.service.implement.BookService;
import com.project.lms.service.implement.CollectionService;

import java.util.List;

@RestController
@RequestMapping("/collections")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private BookService bookService;

    // GET
    @GetMapping("")
    public List<Collection> getAllCollections() {
        return collectionService.getAll();
    }

    // POST
    @PostMapping("")
    public Collection saveNewCollection(@RequestBody Collection collection) {
        return collectionService.save(collection);
    }

    // PUT
    @PutMapping("")
    public Collection putCollection(@RequestBody Collection collection) {
        return collectionService.save(collection);
    }

    // PATCH
    @PatchMapping("/{id}")
    public Collection addBookInCollection(@PathVariable("id") Long collectionId, @RequestParam("bookId") Long bookId) {
        Book book = bookService.getBookById(bookId);
        Collection collection = collectionService.getById(collectionId);
        collection.getBooks().add(book);
        return collectionService.save(collection);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteCollection(@PathVariable Long id) {
        collectionService.delete(id);
    }
}
