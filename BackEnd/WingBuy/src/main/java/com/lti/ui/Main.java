package com.lti.ui;

import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Admin;
import com.lti.model.Order;
import com.lti.model.Payment;
import com.lti.model.ProductForApproval;
import com.lti.model.Retailer;
import com.lti.model.User;
import com.lti.model.Product;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager= factory.createEntityManager();

		Admin admin1 = new Admin();
		admin1.setaName("admin1");
        admin1.setaEmail("abc@gmail.com");
        admin1.setaPassword("123456");
	
       
        
        User user1 = new User();
		user1.setuName("admin1");
        user1.setuEmail("abc@gmail.com");
       user1.setuPassword("123456");
       user1.setuMobile(7896931);
       
    	Admin admin2 = new Admin();        
    	admin2.setaName("admin2");
        admin2.setaEmail("def@gmail.com");
        admin2.setaPassword("654321");
	
        Retailer retailer1=new Retailer();
        retailer1.setrName("Mobile pvt ltd");
        retailer1.setrEmail("aaa@gmail.com");
        retailer1.setrMobile(78953421);
        retailer1.setrPassword("14563");
        
        
        
       
       
        entityManager.getTransaction().begin();
        entityManager.persist(admin2);
        entityManager.getTransaction().commit();
        
        
        ProductForApproval pfa= new ProductForApproval();
	    pfa.setAdmin(admin1);
	    pfa.setpBrand("samsung");
	    pfa.setpCategory("mobile");
	    pfa.setpSubCategory("android");
	    pfa.setpDesc("good");
	    pfa.setpImage("image1");
	    pfa.setpName("M31");
	    pfa.setpPrice(19499);
	    pfa.setRetailer(retailer1);
	    pfa.setpStatus('p');
	    pfa.setpStock(2000);
	    
	    
        ProductForApproval pfa1= new ProductForApproval();
	    pfa1.setAdmin(admin1);
	    pfa1.setpBrand("MOTO");
	    pfa1.setpCategory("mobile");
	    pfa1.setpSubCategory("android");
	    pfa1.setpDesc("good");
	    pfa1.setpImage("image1");
	    pfa1.setpName("One Fusion Plus");
	    pfa1.setpPrice(19499);
	    pfa1.setRetailer(retailer1);
	    pfa1.setpStatus('p');
	    pfa1.setpStock(2000);
	    
	    
	    
	    entityManager.getTransaction().begin();
        entityManager.persist(admin1);
        entityManager.persist(pfa);
        entityManager.persist(pfa1);
        entityManager.persist(retailer1);
        entityManager.persist(user1);
        entityManager.getTransaction().commit();
	    
        Product product= new Product();
	    product.setAdmin(admin1);
	    product.setRetailer(pfa.getRetailer().getrId());
	    product.setpCategory(pfa.getpCategory());
	    product.setpSubCategory(pfa.getpSubCategory());
	    product.setpName(pfa.getpName());
	    product.setpPrice(pfa.getpPrice());
	    product.setpDesc(pfa.getpDesc());
	    product.setpBrand(pfa.getpBrand());
	    product.setpStock(pfa.getpStock());
	    product.setpImage(pfa.getpImage());
	    
	    Product product1= new Product();
	    product1.setAdmin(admin1);
	    product1.setRetailer(pfa1.getRetailer().getrId());
	    product1.setpCategory(pfa1.getpCategory());
	    product1.setpSubCategory(pfa1.getpSubCategory());
	    product1.setpName(pfa1.getpName());
	    product1.setpPrice(pfa1.getpPrice());
	    product1.setpDesc(pfa1.getpDesc());
	    product1.setpBrand(pfa1.getpBrand());
	    product1.setpStock(pfa1.getpStock());
	    product1.setpImage(pfa1.getpImage());
        
        entityManager.getTransaction().begin();
        ProductForApproval pfa2=entityManager.find(ProductForApproval.class,pfa.getpReqId());
        ProductForApproval pfa3=entityManager.find(ProductForApproval.class,pfa1.getpReqId());
        entityManager.remove(pfa2);
        entityManager.remove(pfa3);
        entityManager.persist(product1);
        entityManager.persist(product);
        entityManager.getTransaction().commit();
	    user1.setcProducts(new HashSet<Product>());
        
        user1.addProductToCart(product1);
        user1.addProductToCart(product);
        entityManager.getTransaction().begin();
        entityManager.persist(user1);
        entityManager.getTransaction().commit();
        
        Payment payment1=new Payment();
        payment1.setPayType("COD");
        user1.setPayments(new HashSet<Payment>());
        user1.addPayment(payment1);
        entityManager.getTransaction().begin();
        entityManager.persist(user1);
        entityManager.getTransaction().commit();
        Order order1= new Order();
        order1.setPayment(payment1);
        order1.setUser(user1);
        order1.setpOrderDetails(new HashSet<Product>());
        order1.addProductToOrder(product1);
        order1.setoAddress("mahape");
        entityManager.getTransaction().begin();
        
        entityManager.persist(order1);
        entityManager.getTransaction().commit();
	    
	}
	
    
     
}
//hello