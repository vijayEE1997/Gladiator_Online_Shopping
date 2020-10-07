package com.lti.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.lti.model.Cart;
import com.lti.model.Compare;
import com.lti.model.Product;
import com.lti.model.User;
import com.lti.util.JpaUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("cartdao")
public class CartDaoImpl implements CartDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private UserDao userdao=null;
	
	@Autowired
	private ProductDao productdao=null;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int addToCart(int uId, int pId) {

		try {
			User user = entityManager.find(User.class, uId);
			
			Set<Cart> check=user.getCarts();
			for(Cart c:check)
			{
				if(c.getcUser().getuId()==uId && c.getcProducts().getpId()==pId)
					return 0;
			}
			
			Product product = entityManager.find(Product.class, pId);

			Cart cart = new Cart();
			cart.setpIdQty(1); // by default set qty as 1
			cart.setcUser(user);
			cart.setcProducts(product);
			user.addProductToCart(cart);
			product.addProductToCart(cart);
			entityManager.persist(user);
			entityManager.persist(product);
			
			return 1;
		}
		catch(Exception e) {
			return -1;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
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
			} else {
				System.out.println("out of stock");
				return false;
			}
		} else {
			if (cart.getpIdQty() - 1 >= 1) {
				// update it!
				cart.setpIdQty(cart.getpIdQty() - 1);
				;
				entityManager.merge(cart);
				return true;
			} else {
				System.out.println("quantity cannot be negative");
				return false;
			}
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Cart> viewCart(int uId) {
		String query = "Select e from Cart e where e.cUser.uId=:uId";
		List<Cart> cart = null;
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
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deleteCartBycId(int cId) {
		try {
			Cart cart = entityManager.find(Cart.class, cId);
			entityManager.remove(cart);

		} catch (Exception e) {
			System.out.println("no product deleted or no product there to delete");
		}
		return true;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deleteCartByuId(int uId) {
		String query = "Select e from Cart e where e.cUser.uId=:uId";
		List<Cart> cart = null;
		TypedQuery<Cart> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Cart.class);
			tquery.setParameter("uId", uId);
			cart = tquery.getResultList();
			for (Cart c : cart) {
				entityManager.remove(c);
			}
		}

		catch (Exception e) {
			System.out.println(" no products in cart");
		}
		return true;

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int addToCompare(int uId, int pId) {
		User user=userdao.getUserById(uId);
		Product product=entityManager.find(Product.class,pId);
		Set<Compare> list=user.getCompares();
		if(list.size()==4)
			return 2;
		for(Compare c:list)
		{
			if(c.getCompProducts()==product)
				return 0;
			System.out.print(c.getCompProducts().getpSubCategory());
			System.out.print(product.getpSubCategory());
			System.out.println();
			if((c.getCompProducts().getpSubCategory()).equals(product.getpSubCategory()))
			{
				System.out.println("In");
				Compare compare=new Compare();
				compare.setCompUser(user);
				compare.setCompProducts(product);
				user.addCompare(compare);
				product.addCompare(compare);
				entityManager.persist(compare);
				return 1;
			}
		}
		return -1;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Set<Compare> getCompare(int uId) {
		User user=entityManager.find(User.class,uId);
		return user.getCompares();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Set<Compare> removeFromComp(int compId) {
		Compare c=entityManager.find(Compare.class,compId);
		entityManager.remove(c);
		return c.getCompUser().getCompares();
	}

	

}
