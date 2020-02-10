package com.rakuten.first.demo.dal;
import java.util.List;

import com.rakuten.first.demo.domain.Book;
public interface BookDAO {
	Book save(Book tobeSaved);
	Book findById(int id);
	List<Book> findAll();
	void deleteById(int id);
}

