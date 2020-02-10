package com.rakuten.first.demo.service;
import java.util.List;

import com.rakuten.first.demo.domain.Publisher;
public interface PublisherService {
	public int addPublisherToBook(Publisher toBeAdded);
	public Publisher getByBookId(int bookId);
	public void removePublisher(int bookId);
	public List<Publisher> findAll();
	
}