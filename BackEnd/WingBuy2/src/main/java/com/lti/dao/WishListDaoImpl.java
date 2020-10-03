package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import com.lti.model.Cart;
import com.lti.model.Product;
import com.lti.model.User;
import com.lti.model.WishList;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("wishlistdao")
public class WishListDaoImpl implements WishListDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean addToWishList(int uId, int pId) {
		User user = entityManager.find(User.class, uId);
		Product product = entityManager.find(Product.class, pId);
		
		WishList w=new WishList();// by default set qty as 1
		w.setwUser(user);
		w.setwProducts(product);
		user.addProductToWishList(w);
		product.addProductToWishList(w);
		entityManager.persist(user);
		entityManager.persist(product);
		return true;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
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
	@Transactional(propagation=Propagation.REQUIRED)
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
