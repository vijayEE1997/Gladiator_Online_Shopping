package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.lti.dto.UserSignUp;
import com.lti.model.Cart;
import com.lti.model.Retailer;
import com.lti.model.User;
import com.lti.model.WishList;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;

@Repository("userdao")
public class UserDaoImpl implements UserDao {
	
	

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int addUser(UserSignUp newUser) {

		User user = new User();
		user.setuName(newUser.getuName());
		user.setuPassword(newUser.getuPassword());
		user.setuAddress(newUser.getuAddress());
		user.setuEmail(newUser.getuEmail());
		user.setuMobile(newUser.getuMobile());
		this.entityManager.persist(user);
		String q1 = "select max(uid) from user_t";
		Query query1 = (Query) this.entityManager.createNativeQuery(q1);
		Number id = (Number) query1.getSingleResult();
		int uId = id.intValue();
		return uId;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public User getUserById(int uId) {
		String query = "SELECT E FROM User E WHERE E.uId=:uId";
		User user = null;
		TypedQuery<User> tquery = null;
		try {
			tquery = entityManager.createQuery(query, User.class);
			tquery.setParameter("uId", uId);
			user = tquery.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("User not exists.");
		}
		return user;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int getUserByEmailAndPassword(String email, String password) {
		String query = "SELECT E FROM User E WHERE E.uEmail=:email AND E.uPassword=:password";
		int uId = -1;
		TypedQuery<User> tquery = null;
		try {
			tquery = entityManager.createQuery(query, User.class);
			tquery.setParameter("email", email);
			tquery.setParameter("password", password);
			uId = tquery.getResultList().get(0).getuId();
		} catch (Exception e) {
			System.out.println("User not exists.");
		}
		return uId;

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public User getUserByEmail(String email) {

		String query = "SELECT E FROM User E WHERE E.uEmail=:email";
		User user = null;
		TypedQuery<User> tquery = null;
		try {
			tquery = entityManager.createQuery(query, User.class);
			tquery.setParameter("email", email);
			user = tquery.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("User not exists.");
		}
		return user;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addAddress(int uId, String address) {
		try {

			User user = entityManager.find(User.class, uId);
			user.setuAddress(address);
			entityManager.persist(user);

		} catch (Exception e) {
			System.out.println("unable to update address");
			return false;
		}
		return true;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	 public User updateUser(int uId, User user) {	  
	  return null; 
	  }
	 
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Cart> getCartOfUser(int uId) {
		String query = "SELECT E FROM Cart E WHERE E.uId=:uId";
		TypedQuery<Cart> tquery = null;
		List<Cart> carts = null;
		try {

			tquery = entityManager.createQuery(query, Cart.class);
			tquery.setParameter("uId", uId);
			carts = tquery.getResultList();
		} catch (Exception e) {
			System.out.println("unable to fetch cart data");

		}
		return carts;

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<WishList> getWishlistOfUser(int uId) {
		String query = "SELECT E FROM WishList E WHERE E.uId=:uId";
		TypedQuery<WishList> tquery = null;
		List<WishList> wishlists = null;
		try {

			tquery = entityManager.createQuery(query, WishList.class);
			tquery.setParameter("uId", uId);
			wishlists = tquery.getResultList();
		} catch (Exception e) {
			System.out.println("unable to fetch wishlist data");

		}
		return wishlists;

	}

	

	

}
