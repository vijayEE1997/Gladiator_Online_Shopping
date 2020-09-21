package com.lti.ui;

import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.CSVReader;
import com.lti.CSVReaderUser;
import com.lti.model.Admin;
import com.lti.model.Order;
import com.lti.model.Payment;
import com.lti.model.ProductForApproval;
import com.lti.model.Retailer;
import com.lti.model.User;

import java.util.List;

import com.lti.model.Product;
public class Main {
	public static void main(String[] args) {
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager= factory.createEntityManager();
		Admin admin1 = new Admin();
		admin1.setaName("Vijay Dhakad");
		admin1.setaEmail("vijay.dhakad@gmail.com");
		admin1.setaPassword("v123456d");
		
	Admin admin2 = new Admin();
		admin2.setaName("Gnapika Ankam");
		admin2.setaEmail("gnapika.ankam@gmail.com");
	      	admin2.setaPassword("g123456a");
	      	
	      	/*User user1 = new User();
	    	user1.setuName("Arijeet B");
	    	user1.setuEmail("arijeet.b@gmail.com");
	    	user1.setuPassword("a123456b");
	    	user1.setuMobile(9874563210L);

	    User user2 = new User();
	    	user2.setuName("Ridhi A");
	    	user2.setuEmail("ridhi.a@gmail.com");
	    	user2.setuPassword("r123456a");
	    	user2.setuMobile(78902134566L);
	    	
	    User user3 = new User();
	    	user3.setuName("Mukul K");
	    	user3.setuEmail("mukul.k@gmail.com");
	    	user3.setuPassword("m123456k");
	    	user3.setuMobile(78901234554L);*/
	    	
	   /* User user4 = new User();
	    	user1.setuName("Deepak K");
	    	user1.setuEmail("deepak.k@gmail.com");
	    	user1.setuPassword("d123456k");
	    	//user1.setuMobile(7870123456);
	    	
	    User user5 = new User();
	    	user1.setuName("Roja K");
	    	user1.setuEmail("roja.k@gmail.com");
	    	user1.setuPassword("r123456k");
	    	//user1.setuMobile(889012345);
	    	
	    User user6 = new User();
	    	user1.setuName("Abhinav C");
	    	user1.setuEmail("abhinav.c@gmail.com");
	    	user1.setuPassword("a123456c");
	    	//user1.setuMobile(789912375);
	    User user7 = new User();
	    	user1.setuName("Arpan B");
	    	user1.setuEmail("arpan.b@gmail.com");
	    	user1.setuPassword("a123456b");
	    	//user1.setuMobile(989012345);

	    User user8 = new User();
	    	user1.setuName("Indranil M");
	    	user1.setuEmail("indranil.m@gmail.com");
	    	user1.setuPassword("i123456m");
	    	//user1.setuMobile(789021345);
	    	
	    User user9 = new User();
	    	user1.setuName("Saptrishi C");
	    	user1.setuEmail("saptrishi.c@gmail.com");
	    	user1.setuPassword("s123456c");
	    	//user1.setuMobile(789992395);
	    	
	    User user10 = new User();
	    	user1.setuName("Makarand B");
	    	user1.setuEmail("makarand.b@gmail.com");
	    	user1.setuPassword("m123456b");
	    	//user1.setuMobile(888012342);
	    	
	    User user11 = new User();
	    	user1.setuName("Divyue S");
	    	user1.setuEmail("divyue.s@gmail.com");
	    	user1.setuPassword("d123456s");
	    	//user1.setuMobile(889012377);
	    	
	    User user12 = new User();
	    	user1.setuName("Nitin P");
	    	user1.setuEmail("nitin.p@gmail.com");
	    	user1.setuPassword("n123456p");
	    	//user1.setuMobile(895612375);
	    	*/
	    	Retailer retailer1=new Retailer();
	    	retailer1.setrName("Vishal Kumar");
	    	retailer1.setrEmail("vishal.kumar@gmail.com");
	    	retailer1.setrPassword("va123456k");
	    	retailer1.setrMobile(7890852450L);

	    Retailer retailer2=new Retailer();
	    	retailer2.setrName("Pinto Bhagat");
	    	retailer2.setrEmail("pinto.bhagat@gmail.com");
	    	retailer2.setrPassword("p123456b");
	    	retailer2.setrMobile(7890217536L);
	    	 entityManager.getTransaction().begin();
		        entityManager.persist(admin1);
		        entityManager.persist(admin2);
		       // entityManager.persist(user1);
		       // entityManager.persist(user2);
		       // entityManager.persist(user3);
		        entityManager.persist(retailer1);
		        entityManager.persist(retailer2);
		        entityManager.getTransaction().commit();
	    	CSVReader csvreader = new CSVReader();
	    	CSVReaderUser csvreaderuser = new CSVReaderUser();
	    		List<ProductForApproval> list=csvreader.load(admin1, admin2, retailer1, retailer2);
	    		for(ProductForApproval p :list){
	    			 entityManager.getTransaction().begin();
	    		        entityManager.persist(p);
	    		        entityManager.getTransaction().commit();	
	    		}
	    		List<User> ulist = csvreaderuser.load();
	    		for(User u : ulist){
	    			 entityManager.getTransaction().begin();
	    		        entityManager.persist(u);
	    		        entityManager.getTransaction().commit();
	    		}

        
        
        
       
       
       /* entityManager.getTransaction().begin();
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
        ProductForApproval rpfa=entityManager.find(ProductForApproval.class,pfa.getpReqId());
        entityManager.remove(rpfa);
        ProductForApproval rpfa1=entityManager.find(ProductForApproval.class,pfa1.getpReqId());
        entityManager.remove(rpfa1);
      
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
        order1.addProductToOrderDetails(product1);
        order1.setoAddress("mahape");
        entityManager.getTransaction().begin();

        entityManager.persist(order1);
        entityManager.getTransaction().commit();
*/
	}
}
