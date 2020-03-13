package com.bookstore.controllers;

import com.bookstore.models.Book;
import com.bookstore.models.Publisher;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.impl.BooksServiceImpl;
import com.bookstore.service.impl.PublisherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping ("/getPublishers")
    public Page<Publisher> getAllPublishers (
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "publisherid") String sort){
        return publisherService.getAll(pageNo,pageSize,sort);
    }

    @PostMapping ("/createBook")
    public Book createBooks (@RequestBody Book book) {
       return booksService.add(book);

    }

}
