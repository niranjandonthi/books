//package com.rakuten.first.demo.dal;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import javax.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.rakuten.first.demo.domain.Book;
//@Repository
//@Transactional
//public class BookDAOJpaimpl implements BookDAO {
//	@Autowired
//	EntityManager em;
//	
//@Override
//	public Book save(Book tobeSaved) {
//		// TODO Auto-generated method stub
//		em.persist(tobeSaved);
//		return tobeSaved;
//	}
//@Override
//	public Book findById(int id) {
//		// TODO Auto-generated method stub
//		Book p=em.find(Book.class,id);
//		return em.find(Book.class,id);
//		
//	}
//@Override
//	public List<Book> findAll() {
//		// TODO Auto-generated method stub
//	Query q=em.createQuery("Select p from Book as p");	
//	List<Book> all=q.getResultList();
//		return all;
//	}
//
//	@Override
//	public void deleteById(int id) {
//		 //TODO Auto-generated method stub
//		Book p=em.getReference(Book.class,id);
//		em.remove(p);
////		Query q=em.createQuery("delete from Book as p where p.id=1");
////		q.setParameter(1,id);
////		q.executeUpdate();
//		
//		
//	}
//	
//
//
//}
