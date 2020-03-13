package com.bookstore.controllers;

import com.bookstore.models.Book;
import com.bookstore.models.Publisher;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.impl.BooksServiceImpl;
import com.bookstore.service.impl.PublisherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookstore")

public class BookStoreController {
    @Autowired
    PublisherServiceImpl publisherService;
    @Autowired
    BooksServiceImpl booksService;

    @PostMapping("/createPublisher")
    public Publisher createPublisher (@RequestBody Publisher publisher) {
       Publisher publisherResponse = publisherService.add(publisher);
        return publisherResponse;
    }

    @PostMapping ("/createBook")
    public Book createBooks (@RequestBody Book book) {
       return booksService.add(book);

    }

}
