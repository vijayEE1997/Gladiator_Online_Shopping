package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.lti.dto.UserSignUp;
import com.lti.model.Cart;
import com.lti.model.Product;
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
		User user = getUserByEmail(newUser.getuEmail());
		if(user!=null)
			return 0;
		else
		{
			try {
				user = new User();
				user.setuName(newUser.getuName());
				user.setuPassword(newUser.getuPassword());
				user.setuAddress(newUser.getuAddress());
				user.setuEmail(newUser.getuEmail());
				user.setuMobile(newUser.getuMobile());
				this.entityManager.persist(user);
			}
			catch(Exception e)
			{
				System.out.println("Unable to add");
				return -1;
			}
			return 1;
		}
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
			return user;
		} catch (Exception e) {
			System.out.println("User not exists.");
		}
		return null;
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
	  return entityManager.merge(user); 
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

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int resetPassword(User user) {
		try {
			entityManager.persist(user);
			return 1;
		}
		catch(Exception e)
		{
			return -1;
		}
	}

	@Override
	public List<Product> findAllProductByCat(String keyword) {
		String query = "SELECT E FROM Product E WHERE E.pCategory=:keyword";
		TypedQuery<Product> tquery = null;
		List<Product> products = null;
		try {

			tquery = entityManager.createQuery(query, Product.class);
			tquery.setParameter("keyword", keyword);
			products = tquery.getResultList();
			
		} catch (Exception e) {
			System.out.println("No data Available");

		}
		return products;

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Product findAllProductByPID(int pId) {
		Product product =entityManager.find(Product.class,pId);
		return product;
	}

	

}
