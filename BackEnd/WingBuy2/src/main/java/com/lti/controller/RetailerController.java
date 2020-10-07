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
import com.lti.model.Admin;
import com.lti.model.Product;
import com.lti.model.ProductForApproval;
import com.lti.model.Retailer;
import com.lti.service.RetailerService;

@RestController
@RequestMapping(path ="retailer")
@CrossOrigin
public class RetailerController {
	
	@Autowired
	private RetailerService retailerservice;
	
	@PostMapping(path = "/retailerlogin")
	public int retailerlogin(@RequestBody Login login) {
		return this.retailerservice.loginRetailer(login.getEmail(), login.getPassword());

	}
	
	@GetMapping(path="/getRetailer/{rId}")
	public Retailer getRetailerById(@PathVariable("rId") int rId) {
		return retailerservice.findgetRetailerById(rId);
	}
	
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
	public List<ProductForApprovalDTO> cfindshowMyApprovedProducts(@PathVariable("rId") int rId) {
			List<ProductForApproval> approvedProd = retailerservice.findshowMyApprovedProducts(rId);
			List<ProductForApprovalDTO> dto = new ArrayList<>();
			for(ProductForApproval p:approvedProd)
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
	@GetMapping(path = "pending/{rId}")//-------------retailer pending prod-------------------------------
	public List<ProductForApprovalDTO> cfindshowMyPendingProducts(@PathVariable("rId") int rId) {
		List<ProductForApproval> rejectedProd = retailerservice.findshowMyPendingProducts(rId);
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
	
	@PostMapping(path = "/generateOTP") //-------------retailer signup-------------------------------
	public int generateOTP(@RequestBody String email)
	{
		return retailerservice.generateOTP(email);
	}
	
	@PostMapping(path = "/resetPassword") //-------------generateOTP-------------------------------
	public int resetPassword(@RequestBody Login login)
	{
		return retailerservice.resetPass(login);
	}
	
	
	@PostMapping(path = "/addProduct/{rId}") //-------------retailer signup-------------------------------
	public boolean addProduct(@RequestBody ProductForApprovalDTO pfa,@PathVariable("rId") int rId)
	{
		pfa.setrId(rId);
		System.out.println(pfa);
		return retailerservice.addProductFA(pfa);
	}
	
	
}
