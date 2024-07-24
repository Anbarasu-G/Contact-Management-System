package com.practise.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.practise.config.EMFSingleton;
import com.practise.entity.Contact;
import com.practise.entity.User;

public class ContactDao {
	public boolean saveContact(Contact contact) {
		EntityManager manager = EMFSingleton.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(contact);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			manager.close();
		}

	}

	public Contact findContact(int customerId) {
		EntityManager manager = EMFSingleton.getFactory().createEntityManager();
		Contact contact=null;
		try {
			contact = manager.find(Contact.class,customerId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			manager.close();
		}
		return contact;
	}
	public boolean updateContact(Contact contact) {
		EntityManager manager = EMFSingleton.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(contact);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			manager.close();
		}
	}

	public boolean deleteContact(int  customerId) {

		EntityManager manager = EMFSingleton.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction(); 

		try {
			transaction.begin();
			Contact contact = manager.find(Contact.class, customerId);
			manager.remove(contact);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			manager.close();
		}
	}

}