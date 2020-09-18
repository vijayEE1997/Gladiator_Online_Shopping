package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Admin;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager= factory.createEntityManager();

		Admin admin1 = new Admin();
		admin1.setaName("admin1");
        admin1.setaEmail("abc@gmail.com");
        admin1.setaPassword("123456");
	
        entityManager.getTransaction().begin();
        entityManager.persist(admin1);
        entityManager.getTransaction().commit();
        
    	Admin admin2 = new Admin();        
    	admin2.setaName("admin2");
        admin2.setaEmail("def@gmail.com");
        admin2.setaPassword("654321");
	
        entityManager.getTransaction().begin();
        entityManager.persist(admin2);
        entityManager.getTransaction().commit();
	}
	

}
