package com.bookstore.service;

import java.util.List;

public interface IPublisherService <T> extends BaseBookStoreService <T> {
        public List <T> getPublisherById (int id);

}
