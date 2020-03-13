package com.bookstore.service.impl;

import com.bookstore.models.Author;
import com.bookstore.models.Book;
import com.bookstore.models.Publisher;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.PublisherRepository;
import com.bookstore.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PublisherServiceImpl  implements IPublisherService <Publisher> {

    @Autowired
    PublisherRepository publisherRepository;
    @Autowired
    BookRepository  bookRepository;

    @Override
    public Page<Publisher> getAll(Integer pageNo,Integer pageSize,String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
       return publisherRepository.findAll(paging);
     }

    @Override
    public Publisher add(Publisher publisher) {

        System.out.println ("Printing Publisher model in ::"+this.getClass().getName() + "::"+publisher);
        Publisher pubEntity = new Publisher();
        List <Book> bookListEntity = new ArrayList<Book>();

        pubEntity.setName(publisher.getName());
        pubEntity.setAddress(publisher.getAddress());

        List <Book> reqBookList = publisher.getBookList();
        for (Book book:reqBookList) {
            Author reqAuthor = book.getAuthor();
            Book bookEntity = new Book();
            Author authorEntity = new Author();

            authorEntity.setName(reqAuthor.getName());
            authorEntity.setAddress(reqAuthor.getAddress());

            bookEntity.setName(book.getName());
            bookEntity.setAuthor(authorEntity);
            bookEntity.setPublisher(pubEntity);
            bookListEntity.add(bookEntity);
        }

        pubEntity.setBookList(bookListEntity);
        return publisherRepository.save(pubEntity);
    }
    @Override
    public Publisher update(Publisher o, int id) {
        try {
            Publisher publisher = checkifPublisherPresent(id);

            publisher.setAddress(o.getAddress());
            publisher.setName(o.getName());
            return publisherRepository.save(publisher);

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Publisher getById(int id) throws Exception {
        return checkifPublisherPresent (id);
    }

    @Override
    public Publisher deleteById(int id) {
        return null;
    }


    @Override
    public List<Publisher> getPublisherById(int id) {
        return null;
    }

    private Publisher checkifPublisherPresent (int id) throws Exception {
        if (!publisherRepository.findById(id).isPresent()) {
            throw new Exception("Record not found for ID"+id);
        } else {
            return publisherRepository.findById(id).get();
        }

    }

}
