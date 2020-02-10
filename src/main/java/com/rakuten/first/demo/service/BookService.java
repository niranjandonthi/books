package com.rakuten.first.demo.service;

import java.util.List;

import com.rakuten.first.demo.domain.Book;

public interface BookService {
	Integer addbook(Book toBeAdded);
	void removebook(int id);
	List<Book> findByAll();
	Book findById(int id);
}
