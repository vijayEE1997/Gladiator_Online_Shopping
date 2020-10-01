package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Login;
import com.lti.dto.ProductDTO;
import com.lti.dto.ProductForApprovalDTO;
import com.lti.dto.RetailerSignUp;
import com.lti.model.Product;
import com.lti.model.ProductForApproval;
import com.lti.service.RetailerService;

@RestController
@RequestMapping(path ="Rbuy")
@CrossOrigin
public class RetailerController {
	
	@Autowired
	private RetailerService retailerservice;
	
	@PostMapping(path = "/retailerlogin") //-------------retailer login-------------------------------
	public int retailerlogin(@RequestBody Login login)
	{
			return this.retailerservice.loginRetailer(login.getEmail(), login.getPassword());
		} /*catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -100;
		}*/
	
	@PostMapping(path = "/addNewRetailer") //-------------retailer signup-------------------------------
	public int addNewRetailer(@RequestBody RetailerSignUp newRetailer)
	{
		return this.retailerservice.addRetailer(newRetailer);
	}
	
	@GetMapping(path = "rejected/{rId}")//-------------retailer rejected prod-------------------------------
	public List<ProductForApprovalDTO> cfindshowMyRejectedProducts(@PathVariable("rId") int rId) {
		List<ProductForApproval> rejectedProd = retailerservice.findshowMyRejectedProducts(rId);
		List<ProductForApprovalDTO> dto = new ArrayList<>();
		for(ProductForApproval p:rejectedProd)
		{
			ProductForApprovalDTO pdto = new ProductForApprovalDTO();
			pdto.setpReqId(p.getpReqId());
			pdto.setpName(p.getpName());
			pdto.setpCategory(p.getpCategory());
			pdto.setpBrand(p.getpBrand());
			pdto.setpDesc(p.getpDesc());
			pdto.setpPrice(p.getpPrice());
			pdto.setpSubCategory(p.getpSubCategory());
			pdto.setpImage(p.getpImage());
			pdto.setpStatus(p.getpStatus());
			pdto.setpStock(p.getpStock());
			pdto.setrId(p.getRetailer().getrId());
			dto.add(pdto);
		
	}
		return dto;
	}
	
	@GetMapping(path = "approved/{rId}")//-------------retailer approved prod-------------------------------
	public List<ProductDTO> cfindshowMyApprovedProducts(@PathVariable("rId") int rId) {
			List<Product> approvedProd = retailerservice.findshowMyApprovedProducts(rId);
			List<ProductDTO> dto = new ArrayList<>();
			for(Product p:approvedProd)
			{
				ProductDTO pdto = new ProductDTO();
				
				
				pdto.setpName(p.getpName());
				pdto.setpCategory(p.getpCategory());
				pdto.setpBrand(p.getpBrand());
				pdto.setpDesc(p.getpDesc());
				pdto.setpPrice(p.getpPrice());
				pdto.setpSubCategory(p.getpSubCategory());
				pdto.setpImage(p.getpImage());
				pdto.setpStock(p.getpStock());
				dto.add(pdto);
		
	}
			return dto;
}
	
	/*@GetMapping(path="/")// doubt
	public List<Product> cfindshowMyApprovedProducts(int rId) {
		List<Product> approvedProd = retailerservice.findshowMyApprovedProducts(rId);
		return approvedProd;
	}
	
	
}
	@GetMapping(path="/")//doubt
	public List<ProductForApproval> cfindshowMyRejectedProducts(int rId) {
		List<ProductForApproval> rejectedProd = retailerservice.findshowMyRejectedProducts(rId);
		return rejectedProd;
	}*/
}
