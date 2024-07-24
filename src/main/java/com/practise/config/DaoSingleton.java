package com.practise.config;

import com.practise.dao.ContactDao;
import com.practise.dao.UserDao;

public class DaoSingleton {
	private static UserDao userDao;
	private static ContactDao contactDao;

	public synchronized static UserDao getUserDao() {
		if(userDao==null)
			userDao=new UserDao();
		return userDao;
	}

	public static synchronized ContactDao getContactDao() {
		if (contactDao==null)
			contactDao=new ContactDao();
		return contactDao;
	}
}
