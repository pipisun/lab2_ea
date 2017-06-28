package edu.mum.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	@PersistenceContext
    protected EntityManager entityManager;
	
	public UserDaoImpl() {
		super.setDaoType(User.class);
	}
	
	public User findByEmail(String email) {
	     
		Query query = entityManager.createQuery("select u from User u  where u.email =:email");
		return (User) query.setParameter("email", email).getSingleResult();
			     

	}
 }