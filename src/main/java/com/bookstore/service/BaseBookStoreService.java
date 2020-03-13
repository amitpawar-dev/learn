package com.bookstore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseBookStoreService <T> {
    Page <T> getAll (Integer pageNo,Integer pageSize,String sortBy);
    T add (T o);
    T update (T o, int id);
    T getById (int id) throws Exception;
    T deleteById (int id);

}
