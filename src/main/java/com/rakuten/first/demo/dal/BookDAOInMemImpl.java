package com.rakuten.first.demo.dal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rakuten.first.demo.domain.Book;
@Transactional
@Repository
public class BookDAOInMemImpl {
//	@Autowired
//	EntityManager em;
	Map<Integer,Book> db=new ConcurrentHashMap<>();
	AtomicInteger idSequence=new AtomicInteger(0);
  //@Override
  public Book save(Book toBeSaved) {
    // TODO Auto-generated method stub
    int id=idSequence.incrementAndGet();
    toBeSaved.setId(id);
    db.put(id,toBeSaved);
    return toBeSaved;
  }
  //@Override
  public Book findById(int id) {
    // TODO Auto-generated method stub
    return db.get(id);
  }
  //@Override
  public List<Book> findAll() {
    // TODO Auto-generated method stub
    return new ArrayList<>(db.values());
  }
  //@Override
  public void deleteById(int id) {
    // TODO Auto-generated method stub
db.remove(id);
    
  }
	
	
}



