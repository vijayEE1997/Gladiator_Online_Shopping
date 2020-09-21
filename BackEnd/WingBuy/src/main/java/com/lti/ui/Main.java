package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Admin;
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
	    
	   
	    
	    
	    entityManager.getTransaction().begin();
        entityManager.persist(admin1);
        entityManager.persist(pfa);
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
	    
	    
        
        entityManager.getTransaction().begin();
        ProductForApproval pfa1=entityManager.find(ProductForApproval.class,pfa.getpReqId());
        entityManager.remove(pfa1);
        entityManager.persist(product);
        entityManager.getTransaction().commit();
	    
        
	    
	}
	
    
     
}
//hello