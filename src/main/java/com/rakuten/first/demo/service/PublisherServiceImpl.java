package com.rakuten.first.demo.service;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.first.demo.dal.BookDAO;
import com.rakuten.first.demo.dal.PublisherDAO;
import com.rakuten.first.demo.domain.Book;
import com.rakuten.first.demo.domain.Publisher;
@Service
@Transactional
public class PublisherServiceImpl implements PublisherService{
	PublisherDAO dao;
	@Autowired
	public void setDAO(PublisherDAO dao)
	{
		this.dao=dao;
	}
	@Override
	public int addPublisherToBook(Publisher toBeAdded) {
		// TODO Auto-generated method stub
		Publisher p=dao.save(toBeAdded);
		return p.getId();
		
	}

	@Override
	public Publisher getByBookId(int bookId) {
		// TODO Auto-generated method stub
		return dao.findById(bookId);
		}

	@Override
	public void removePublisher(int bookId) {
		// TODO Auto-generated method stub
		dao.deleteById(bookId);
		
	}
	public List<Publisher> findAll()
	{
		return dao.findAll();
	}
}
