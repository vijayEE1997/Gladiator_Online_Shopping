package com.lti.ui;

import java.util.Date;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.CSVReader;
import com.lti.CSVReaderUser;
import com.lti.model.Admin;
import com.lti.model.Cart;
import com.lti.model.Order;
import com.lti.model.Payment;
import com.lti.model.ProductForApproval;
import com.lti.model.Retailer;
import com.lti.model.User;

import java.util.List;

import com.lti.model.Product;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = factory.createEntityManager();
		Admin admin1 = new Admin();
		admin1.setaName("Vijay Dhakad");
		admin1.setaEmail("vijay.dhakad@gmail.com");
		admin1.setaPassword("v123456d");

		Admin admin2 = new Admin();
		admin2.setaName("Gnapika Ankam");
		admin2.setaEmail("gnapika.ankam@gmail.com");
		admin2.setaPassword("g123456a");

		Retailer retailer1 = new Retailer();
		retailer1.setrName("Vishal Kumar");
		retailer1.setrEmail("vishal.kumar@gmail.com");
		retailer1.setrPassword("va123456k");
		retailer1.setrMobile(7890852450L);

		Retailer retailer2 = new Retailer();
		retailer2.setrName("Pinto Bhagat");
		retailer2.setrEmail("pinto.bhagat@gmail.com");
		retailer2.setrPassword("p123456b");
		retailer2.setrMobile(7890217536L);
		entityManager.getTransaction().begin();
		entityManager.persist(admin1);
		entityManager.persist(admin2);
		entityManager.persist(retailer1);
		entityManager.persist(retailer2);
		entityManager.getTransaction().commit();
		CSVReader csvreader = new CSVReader();
		CSVReaderUser csvreaderuser = new CSVReaderUser();
		List<ProductForApproval> list = csvreader.load(admin1, admin2, retailer1, retailer2);
		for (ProductForApproval p : list) {
			entityManager.getTransaction().begin();
			entityManager.persist(p);
			entityManager.getTransaction().commit();
		}
		List<User> ulist = csvreaderuser.load();
		for (User u : ulist) {
			entityManager.getTransaction().begin();
			entityManager.persist(u);
			entityManager.getTransaction().commit();
		}
		int i = 0;
		for (ProductForApproval p : list) {
			i++;
			if (i % 3 == 0) {
				p.setpStatus('R');
				continue;
			}
			Product product1 = new Product();
			product1.setAdmin(p.getAdmin());
			product1.setRetailer(p.getRetailer().getrId());
			product1.setpCategory(p.getpCategory());
			product1.setpSubCategory(p.getpSubCategory());
			product1.setpName(p.getpName());
			product1.setpPrice(p.getpPrice());
			product1.setpDesc(p.getpDesc());
			product1.setpBrand(p.getpBrand());
			product1.setpImage(p.getpImage());
			product1.setpStock(p.getpStock());
			entityManager.getTransaction().begin();
			entityManager.persist(product1);
			entityManager.getTransaction().commit();
			entityManager.getTransaction().begin();
			ProductForApproval pfa = entityManager.find(ProductForApproval.class, p.getpReqId());
			entityManager.remove(pfa);
			entityManager.getTransaction().commit();
		}

//		entityManager.getTransaction().begin();
//		User user1 = entityManager.find(User.class, 52);
//		Product product1 = entityManager.find(Product.class, 63);
//		Product product2 = entityManager.find(Product.class, 71);
//		Product product3 = entityManager.find(Product.class, 69);
//		
		
		
		
//		user1.setCarts(new HashSet<Cart>());
//		user1.addProductToCart(new Cart(2,product1,user1));//likh
//		user1.addProductToCart(new cart(3,product2,user2));
//		user1.addProductToCart(product2);
//		user1.addProductToCart(product3);
//		entityManager.persist(user1);
//		entityManager.getTransaction().commit();
//
//		entityManager.getTransaction().begin();
//		user1.setwProducts(new HashSet<Product>());
//		user1.addProductToWishList(product1);
//		user1.addProductToWishList(product2);
//		user1.addProductToWishList(product3);
//		entityManager.persist(user1);
//		entityManager.getTransaction().commit();
//
//		entityManager.getTransaction().begin();
//		user1.setComProducts(new HashSet<Product>());
//		user1.addProductToCompare(product1);
//		user1.addProductToCompare(product2);
//		user1.addProductToCompare(product3);
//		entityManager.persist(user1);
//		entityManager.getTransaction().commit();
//
//		entityManager.getTransaction().begin();
//		Payment payment1 = new Payment();
//		payment1.setPayType("Cod");
//		payment1.setUser(user1);
//		user1.setPayments(new HashSet<Payment>());
//		user1.addPayment(payment1);
//		entityManager.persist(user1);
//		entityManager.getTransaction().commit();
//		
//		Order order1 = new Order();
//		int sum=0;
//		
//		order1.setPayment(payment1);
//		for (Product p : user1.getcProducts()) {
//			sum+=p.getpPrice();
//			
//		}
//	order1.setoPrice(sum);
//	order1.setoQty(user1.getcProducts().size());
//	order1.setoPurchaseDate(new Date());
//	//order1.setoDeliveryDate(new Date());
//	user1.setuAddress("BHOPAL");
//	order1.setUser(user1);
//	order1.setoAddress(user1.getuAddress());
//	entityManager.getTransaction().begin();
//	entityManager.persist(order1);
//	entityManager.getTransaction().commit();
//	
//		
//	
//	}
}}
