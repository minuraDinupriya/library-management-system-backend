package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor//lombok eken parameterized constructor ekt final fields tika dagen lombok constructor injection krnw
public class BookServiceImpl implements BookService {
    @Autowired
    final BookRepository bookRepository;

    ModelMapper modelMapper;
    @Bean
    public void setup(){
        this.modelMapper=new ModelMapper();
    }
    @Override
    public void addBook(Book book) {
        BookEntity bookEntity = modelMapper.map(book, BookEntity.class);
        bookRepository.save(bookEntity);
    }

    public List<Book> getBooks(){
        List<Book> bookDtoList=new ArrayList<>();
        Iterable<BookEntity> bookEntities = bookRepository.findAll();

        for (BookEntity bookEntity:bookEntities) {
            Book bookDto = modelMapper.map(bookEntity, Book.class);
            bookDtoList.add(bookDto);
        }

        return bookDtoList;
    }

    @Override
    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Book getBookById(Long id) {
        Optional<BookEntity> byId = bookRepository.findById(id);
        return modelMapper.map(byId, Book.class);
    }


}