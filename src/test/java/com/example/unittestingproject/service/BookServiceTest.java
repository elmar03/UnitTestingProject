package com.example.unittestingproject.service;

import com.example.unittestingproject.entity.Book;
import com.example.unittestingproject.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void TestIsEmpty(){
        List<Book> books = new ArrayList<>();
        books.add(new Book());
        when(bookRepository.findAll()).thenReturn(books);
        boolean isEmpty = bookService.isEmpty();
        Assertions.assertTrue(isEmpty);

    }

}
