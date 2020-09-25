package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Cart;
import com.lti.model.User;
import com.lti.model.Product;

public class CartDaoImpl implements CartDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager entityManager = factory.createEntityManager();

	public void begin() {
		entityManager.getTransaction().begin();
	}

	public void commit() {
		entityManager.getTransaction().commit();
	}

	@Override
	public boolean addToCart(int uId, int pId) {
try{
		begin();
		User user = entityManager.find(User.class, uId);
		Product product = entityManager.find(Product.class, pId);
		Cart cart = new Cart();
		cart.setpIdQty(1); // by default set qty as 1
		cart.setcUser(user);
		cart.setcProducts(product);
		entityManager.persist(cart);
		commit();
		
}

catch(Exception e)
	{
		System.out.println("no product added");
	}
return true;
	}


	@Override
	public boolean updateCart(int cId, int addorminus) {
		
		
		return false;
	}

	@Override
	public boolean deleteCart(int cId) {
		// TODO Auto-generated method stub
		return false;
	}

}
