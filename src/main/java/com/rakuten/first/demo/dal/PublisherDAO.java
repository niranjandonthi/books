package com.rakuten.first.demo.dal;
import java.util.List;
import com.rakuten.first.demo.domain.Publisher;

public interface PublisherDAO {
	Publisher findById(int bookId);
	Publisher save(Publisher toBeSaved);
	void deleteById(int id);
	List<Publisher> findAll();
	List<Publisher> findByBookId(int bookId);

}
