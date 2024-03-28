package com.example.unittestingproject.service;

import com.example.unittestingproject.entity.Book;
import com.example.unittestingproject.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllEntities(){
        return bookRepository.findAll();
    }

    public boolean isEmpty(){
        List<Book> all = bookRepository.findAll();
        return all.isEmpty();
    }


}
