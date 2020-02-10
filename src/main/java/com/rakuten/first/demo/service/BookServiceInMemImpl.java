package com.rakuten.first.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.transaction.Transactional;

import com.rakuten.first.demo.dal.BookDAO;
import com.rakuten.first.demo.domain.Book;
@Service
@Transactional
public class BookServiceInMemImpl implements BookService{
	@Autowired
	BookDAO dao  ;
	
	  public void setDao(BookDAO dao) {
	   this.dao = dao;
	   }
	
		@Override
		public Integer addbook(Book toBeAdded) {
			// TODO Auto-generated method stub
			 if(toBeAdded.getPages()>=100)
			  {
				  Book added =dao.save(toBeAdded);
				  return added.getId();
			  }
			  else
			  {
				  throw new IllegalArgumentException("Something");
			  }
		}
		@Override
		public void removebook(int id) {
			// TODO Auto-generated method stub
			 Book existing = dao.findById(id);
			  if(existing!=null)
			  {
				  if(existing.getPages()>=10000)
				  {
					  throw new IllegalStateException("U cant delete");
				  }
				  else
				  {
					  dao.deleteById(id);
				  }
			  }
			
		}
		@Override
		public List<Book> findByAll() {
			// TODO Auto-generated method stub
			return  dao.findAll();
		}
		@Override
		public Book findById(int id) {
			// TODO Auto-generated method stub
			return dao.findById(id);
		}
			
	}


