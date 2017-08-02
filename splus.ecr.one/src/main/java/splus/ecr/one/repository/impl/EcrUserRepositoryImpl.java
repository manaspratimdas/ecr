package splus.ecr.one.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import splus.ecr.one.model.User;
import splus.ecr.one.repository.EcrUserRepository;

public class EcrUserRepositoryImpl implements EcrUserRepository {
	
	@PersistenceContext
    EntityManager entitymanager;
	
	final static Logger logger = Logger.getLogger(EcrUserRepositoryImpl.class);

	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	public void deleteInBatch(Iterable<User> arg0) {
		// TODO Auto-generated method stub
		
	}

	public List<User> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends User> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends User> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public void flush() {
		// TODO Auto-generated method stub
		
	}

	public User getOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends User> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends User> S saveAndFlush(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<User> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(Long arg0) {
		// TODO Auto-generated method stub
		
	}

	public void delete(User arg0) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Iterable<? extends User> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public <S extends User> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public <S extends User> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public <S extends User> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends User> S findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public User findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public User save(User ecrUser) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public User findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findByCompanyId(Long companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public User login(User user) {
		
		Query query = entitymanager.createQuery("SELECT u FROM User u WHERE userName = :userName and password = :password");
		query.setParameter("userName", user.getUsername());
		query.setParameter("password", user.getPassword());
		try {
			user = (User)query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			logger.debug("No result found...");
		}
		
		return user;
	}


}
