package com.bookstore.service.impl;

import com.bookstore.models.Book;
import com.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service

public class BooksServiceImpl<Book>  implements IBooksService <com.bookstore.models.Book>{

    @Autowired
    BookRepository bookRepository;

    @Override
    public Page<com.bookstore.models.Book> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public com.bookstore.models.Book add(com.bookstore.models.Book o) {
        return bookRepository.save(o);
    }

    @Override
    public com.bookstore.models.Book update(com.bookstore.models.Book o, int id) {
        return null;
    }

    @Override
    public com.bookstore.models.Book getById(int id) throws Exception {
        return null;
    }

    @Override
    public com.bookstore.models.Book deleteById(int id) {
        return null;
    }
}
