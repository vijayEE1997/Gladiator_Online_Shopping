package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.model.Cart;
import com.lti.model.Product;
import com.lti.model.User;
import com.lti.util.JpaUtility;

public class CartDaoImpl implements CartDao {
	/*private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager entityManager = factory.createEntityManager();*/
	EntityManager entityManager = null;
	public CartDaoImpl(){
		entityManager = JpaUtility.getEntityManager();
	}

	public void begin() {
		entityManager.getTransaction().begin();
	}

	public void commit() {
		entityManager.getTransaction().commit();
	}

	@Override
	public boolean addToCart(int uId, int pId) {
		
			
			User user = entityManager.find(User.class, uId);
			Product product = entityManager.find(Product.class, pId);
			System.out.println(user);
			System.out.println(product);
			Cart cart = new Cart();
			cart.setpIdQty(1); // by default set qty as 1
			cart.setcUser(user);
			cart.setcProducts(product);
			begin();
			entityManager.persist(cart);
			commit();

		return true;
	}
	

	@Override
	public boolean updateCart(int cId, int addOrMinus) {

		Cart cart = entityManager.find(Cart.class, cId);

		if (addOrMinus == 1) {
			Product product = entityManager.find(Product.class, cart.getcProducts().getpId());
			int pStock = product.getpStock();
			if (cart.getpIdQty() + 1 <= pStock) {
				// update it!
				cart.setpIdQty(cart.getpIdQty() + 1);
				entityManager.merge(cart);
				return true;
			} 
			else {
				System.out.println("out of stock");
				return false;
			}
		} 
		else {
			if (cart.getpIdQty() - 1 >= 1) {
				// update it!
				cart.setpIdQty(cart.getpIdQty() - 1);
				;
				entityManager.merge(cart);
				return true;
			}
			else {
				System.out.println("quantity cannot be negative");
				return false;
			}
		}
	}
	
	@Override
	public List<Cart> viewCart(int uId) {
		String query = "Select e from Cart e where e.cUser.uId=:uId";
		List<Cart> cart=null;
		TypedQuery<Cart> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Cart.class);
			tquery.setParameter("uId", uId);
			 cart = tquery.getResultList();
		}

		catch (Exception e) {
			System.out.println(" no products in cart");
		}
		return cart;
	}

	@Override
			public boolean deleteCartBycId(int cId) {
			try
			{
				Cart cart = entityManager.find(Cart.class, cId);
				entityManager.remove(cart);
				
			}
			catch(Exception e)
			{
				System.out.println("no product deleted or no product there to delete");
			}
			return true;
		}

	@Override
	public boolean deleteCartByuId(int uId) {
		String query = "Select e from Cart e where e.cUser.uId=:uId";
		List<Cart> cart=null;
		TypedQuery<Cart> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Cart.class);
			tquery.setParameter("uId", uId);
			 cart = tquery.getResultList();
			 for(Cart c:cart){
				 entityManager.remove(c);
			 }
		}

		catch (Exception e) {
			System.out.println(" no products in cart");
		}
		return true;
	
	}

}
