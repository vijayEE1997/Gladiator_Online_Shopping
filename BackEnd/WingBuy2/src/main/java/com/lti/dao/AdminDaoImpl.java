package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Admin;
import com.lti.model.Product;
import com.lti.model.ProductForApproval;
import com.lti.model.Retailer;

@Repository("admindao")
public class AdminDaoImpl implements AdminDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Admin getAdminById(int aId) {
		String query = "SELECT E FROM Admin E WHERE E.aId=:aId";
		Admin admin = null;
		TypedQuery<Admin> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Admin.class);
			tquery.setParameter("aId", aId);
			admin = tquery.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Admin not exists.");
		}
		return admin;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int getAdminByEmailAndPassword(String email, String password) {
		String query = "SELECT E FROM Admin E WHERE E.aEmail=:email AND E.aPassword=:password";
		int aId = -1;
		TypedQuery<Admin> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Admin.class);
			tquery.setParameter("email", email);
			tquery.setParameter("password", password);

			aId = tquery.getResultList().get(0).getaId();

		}

		catch (Exception e) {
			System.out.println("Admin not exists.");
		}
		return aId;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Admin getAdminByEmail(String email) {
		String query = "SELECT E FROM Admin E WHERE E.aEmail=:email";
		Admin admin = null;
		TypedQuery<Admin> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Admin.class);
			tquery.setParameter("email", email);
			admin = tquery.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Admin not exists.");
		}
		return admin;
	}

	@Override
	public List<ProductForApproval> getProductstobeApproved(int aId) {
			String query = "SELECT E FROM ProductForApproval E WHERE E.admin.aId=:aId AND E.pStatus='P'";
			System.out.println("DAO");
			List<ProductForApproval> product = null;
			TypedQuery<ProductForApproval> tquery = null;
//			try {
				System.out.println("INSIDE DAO");
				tquery = entityManager.createQuery(query, ProductForApproval.class);
				tquery.setParameter("aId", aId);
				product = tquery.getResultList();
//				System.out.println(product);
//				for(ProductForApproval p:product)
//					System.out.println(p);
//			} catch (Exception e) {
//				System.out.println("No pending requests or some error");
//			}
			return product;
		
	}

	@Override
	public List<Product> getProducts(int aId) {
		String query = "SELECT E FROM Product E WHERE E.admin.aId=:aId";
		List<Product> product = null;
		TypedQuery<Product> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Product.class);
			tquery.setParameter("aId", aId);
			product = tquery.getResultList();
		} catch (Exception e) {
			System.out.println("No products or some error");
		}
		return product;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addProductByrqID(int aId, int rqId) {
		Admin admin=entityManager.find(Admin.class,aId);
		ProductForApproval pfa=entityManager.find(ProductForApproval.class,rqId);
		Product p=new Product();
		p.setpCategory(pfa.getpCategory());
		p.setpSubCategory(pfa.getpSubCategory());
		p.setpName(pfa.getpName());
		p.setpPrice(pfa.getpPrice());
		p.setpDesc(pfa.getpDesc());
		p.setpBrand(pfa.getpBrand());
		p.setpStock(pfa.getpStock());
		p.setpImage(pfa.getpImage());
		p.setAdmin(admin);
		p.setRetailer(pfa.getRetailer().getrId());
		admin.addProduct(p);
		pfa.setpStatus('A');
		entityManager.merge(admin);
		return true;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean rejectProductByrqIdd(int aId, int rqId) {
		ProductForApproval pfa=entityManager.find(ProductForApproval.class,rqId);
		pfa.setpStatus('R');
		entityManager.merge(pfa);
		return true;
	}

}
