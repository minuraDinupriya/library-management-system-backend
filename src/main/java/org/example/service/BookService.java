package org.example.service;

import org.example.dto.Book;
import org.example.entity.BookEntity;

public interface BookService {
    void addBook(Book book);
    public Iterable<BookEntity> getBooks();

    boolean deleteBook(Long id);
    Book getBookById(Long id);
}