package com.practise.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.practise.config.EMFSingleton;
import com.practise.entity.User;

public class UserDao {

	public boolean saveUser(User user) {
		EntityManager manager = EMFSingleton.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(user);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			manager.close();
		}

	}

	public User findUser(int userId) {
		EntityManager manager = EMFSingleton.getFactory().createEntityManager();
		User user=null;
		try {
			user = manager.find(User.class,userId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			manager.close();
		}
		return user;
	}
	public boolean updateUser(User user) {
		EntityManager manager = EMFSingleton.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(user);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			manager.close();
		}
	}

	public boolean deleteUser(int  userId) {

		EntityManager manager = EMFSingleton.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction(); 

		try {
			transaction.begin();
			User user = manager.find(User.class, userId);
			manager.remove(user);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			manager.close();
		}
	}

	public User findUserByEmailAndPassword(String email,String password) {
		EntityManager manager = EMFSingleton.getFactory().createEntityManager();
		User user=null;
		try {
			TypedQuery<User> query = manager.createQuery("FROM User WHERE email= :email AND password= :pwd",User.class);
			query.setParameter("email", email);
			query.setParameter("pwd", password);
			user = query.getSingleResult();			
		} catch (Exception e) {
          e.printStackTrace();
		}finally {
			manager.close();
		}
		return user;
	}
}
