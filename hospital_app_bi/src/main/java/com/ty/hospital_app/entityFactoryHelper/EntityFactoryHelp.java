package com.ty.hospital_app.entityFactoryHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityFactoryHelp {
	
	public static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ratna");
	public static EntityManager entityManager=entityManagerFactory.createEntityManager();
	public static EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public static EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory("ratna");
	}
	public static EntityManager entityManager() {
		return entityManagerFactory().createEntityManager();	
	}
	public static EntityTransaction entityTransaction() {
		return entityManager().getTransaction();
	}

}
