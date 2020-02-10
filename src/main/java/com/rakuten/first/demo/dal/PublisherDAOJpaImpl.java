package com.rakuten.first.demo.dal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rakuten.first.demo.domain.Publisher;
@Repository
@Transactional
public class PublisherDAOJpaImpl implements PublisherDAO {
@Autowired EntityManager em;
	@Override
	public Publisher findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Publisher.class, id);
	}

	@Override
	public Publisher save(Publisher toBeSaved) {
		// TODO Auto-generated method stub
		em.persist(toBeSaved);
	    return toBeSaved;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Publisher p = em.find(Publisher.class, id);
	    em.remove(p);
	}

	@Override
	public List<Publisher> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publisher> findByBookId(int BookId) {
		// TODO Auto-generated method stub
		TypedQuery<Publisher> q = em.createQuery("select p from Publisher p where p.id=:id", Publisher.class) ;
	    q.setParameter("id", BookId);
	    return q.getResultList();
	}

}
