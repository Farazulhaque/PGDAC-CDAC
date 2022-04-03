package com.boot.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.boot.entity.Users;
import com.boot.repository.UserRepository;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

	// An EntityManager will be automatically injected from entityManagerFactory
	// setup on DatabaseConfig class.
	@PersistenceContext
	private EntityManager entityManager;

	public void save(Users user) {
		entityManager.persist(user);
	}

	public Users findByEmailAndPassword(String email, String password) {
		try {
			return (Users) entityManager.createQuery("from Users where email = :email and password = :password")
					.setParameter("email", email).setParameter("password", password).getSingleResult();
		} catch (NoResultException e) {
		}
		return null;

	}

	public Users findByEmail(String email) {
		try {
			return (Users) entityManager.createQuery("from Users where email = :email").setParameter("email", email)
					.getSingleResult();
		} catch (NoResultException e) {
		}
		return null;

	}

}
