package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.model.Cart;
import com.lti.model.Product;
import com.lti.model.User;
import com.lti.model.WishList;

public class WishListDaoImpl implements WishListDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager entityManager = factory.createEntityManager();

	public void begin() {
		entityManager.getTransaction().begin();
	}

	public void commit() {
		entityManager.getTransaction().commit();
	}

	@Override
	public boolean addToWishList(int uId, int pId) {
		try {
			begin();
			User user = entityManager.find(User.class, uId);
			Product product = entityManager.find(Product.class, pId);
			WishList wishlist = new WishList();
			wishlist.setwUser(user);
			wishlist.setwProducts(product);
			entityManager.persist(wishlist);
			commit();

		}

		catch (Exception e) {
			System.out.println("no product added");
		}
		return true;
	}

	@Override
	public boolean deleteWishList(int wId) {
		try {
			WishList wishlist = entityManager.find(WishList.class, wId);
			entityManager.remove(wishlist);

		} catch (Exception e) {
			System.out.println("no product deleted or no product there to delete");
		}
		return true;
	}

	@Override
	public List<WishList> viewWishList(int uId) {

		String query = "Select e from WishList e where e.wUser.uId=:uId";
		List<WishList> wishlist=null;
		TypedQuery<WishList> tquery = null;
		try {
			tquery = entityManager.createQuery(query, WishList.class);
			tquery.setParameter("uId", uId);
			 wishlist = tquery.getResultList();
		}

		catch (Exception e) {
			System.out.println(" no products in wishlist");
		}
		return wishlist;

	}
}
