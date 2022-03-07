package com.example.mongoBookStore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongoBookStore.model.Book;

public interface BookRepository extends MongoRepository<Book,Integer>{

}
