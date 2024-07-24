package com.practise.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFSingleton {
	static  EntityManagerFactory factory;  

	private EMFSingleton() {

	}

	public synchronized static EntityManagerFactory getFactory() {
		if (factory==null) {
			factory=Persistence.createEntityManagerFactory("cms");
		}
		return factory;
	}
}
