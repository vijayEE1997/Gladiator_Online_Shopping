package com.lti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;

import com.lti.model.Admin;
import com.lti.model.ProductForApproval;
import com.lti.model.Retailer;

public class CSVReader {

	public static void load(Admin admin1, Admin admin2, Retailer retailer1, Retailer retailer2,EntityManager em) {

		String csvFile = "C:/Users/91830/Downloads/v.csv";/// likh bhai
		String line = "";
		String cvsSplitBy = ",";
		List<ProductForApproval> list = new ArrayList<>();
		admin1.setProducts_f_a(new HashSet<>());
		admin2.setProducts_f_a(new HashSet<>());
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			int c = 0;
			while ((line = br.readLine()) != null) {
				if (c == 0) {
					c++;
					continue;
				}
				// use comma as separator
				String[] product = line.split(cvsSplitBy);

				ProductForApproval pfa2 = new ProductForApproval();
				pfa2.setpCategory(product[2]);
				pfa2.setpSubCategory(product[3]);
				pfa2.setpBrand(product[4]);
				pfa2.setpName(product[5]);
				pfa2.setpDesc(product[6]);
				pfa2.setpImage(product[7]);
				// System.out.println(product[8]);
				pfa2.setpPrice(Integer.parseInt(product[8]));
				pfa2.setpStatus('P');
				pfa2.setpStock(Integer.parseInt(product[9]));
				pfa2.setAdmin(admin1);
				pfa2.setRetailer(retailer1);
				admin1.addProductForA(pfa2);
				retailer1.addProductForA(pfa2);
//				if (product[0].equals("admin1"))
//					admin1.addProductForA(pfa2);
//				else
//					admin2.addProductForA(pfa2);
				
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		em.getTransaction().begin();
		em.persist(admin1);
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.persist(retailer1);
		em.getTransaction().commit();
		
	}

}
