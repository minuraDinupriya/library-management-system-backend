package org.example.controller;

import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }
    @GetMapping("/get")
    public Iterable<BookEntity> getBooks(){
        return bookService.getBooks();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        return bookService.deleteBook(id)?ResponseEntity.ok("Deleted"):ResponseEntity.notFound().build();
    }

    @GetMapping("/search/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }
}