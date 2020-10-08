package com.lti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Admin;
import com.lti.model.Cart;
import com.lti.model.Compare;
import com.lti.model.Order;
import com.lti.model.OrderDetail;
import com.lti.model.Payment;
import com.lti.model.Product;
import com.lti.model.ProductForApproval;
import com.lti.model.Retailer;
import com.lti.model.User;
import com.lti.model.WishList;
import com.lti.service.AdminService;
import com.lti.service.CartService;
import com.lti.service.OrderService;
import com.lti.service.PaymentService;
import com.lti.service.ProductService;
import com.lti.service.RetailerService;
import com.lti.service.UserService;
import com.lti.service.WishListService;
import com.lti.dto.CartDTO;
import com.lti.dto.CartMyDTO;
import com.lti.dto.Login;
import com.lti.dto.PaymentDTO;
import com.lti.dto.ProductDTO;
import com.lti.dto.ProductForApprovalDTO;
import com.lti.dto.RetailerSignUp;
import com.lti.dto.UserSignUp;
import com.lti.dto.WishListDTO;

@RestController
@RequestMapping(path = "admin")
@CrossOrigin
public class AdminController {

	@Autowired
	private AdminService adminservice;
	@Autowired
	private RetailerService retailerservice;
	@Autowired
	private UserService userservice;
	@Autowired
	private CartService cartservice;
	@Autowired
	private WishListService wishlistservice;
	@Autowired
	private PaymentService paymentservice;
	@Autowired
	private OrderService orderservice;
	@Autowired
	private ProductService productservice;
	
	@GetMapping(path = "/getSubCatByCat/{Category}") 
	public List<String> fCategoryBySubCategory(@PathVariable String Category)
	{
		return this.productservice.findSubCategoryByCategory(Category);
	}
	
	@GetMapping(path = "/getProductBySubCategory/{pSubCategory}") 
	public List<Product> getProductBySubCategory(@PathVariable String pSubCategory)
	{
		return this.productservice.getProductBySearch(pSubCategory);
	}

	@GetMapping(path = "/getProductBySearch/{pCategory}") 
	public List<Product> getProductByCategory(@PathVariable String pCategory)
	{
		return this.productservice.findCategory(pCategory);
	}
	
	

	@GetMapping(path = "/getProductByBrand/{pCategory}") 
	public List<String> getProductByBrand(@PathVariable String pCategory)
	{
		return this.productservice.findSubBrandByCategory(pCategory);
	}
	
	@PostMapping(path = "/userlogin")
	public int userlogin(@RequestBody Login login) {
		return this.userservice.loginuser(login);
	} 

	@PostMapping(path = "/adminlogin")
	public int adminlogin(@RequestBody Login login) {
		System.out.println(login);
		return this.adminservice.loginadmin(login.getEmail(), login.getPassword());
	}

	@PostMapping(path = "/addNewUser")
	public int addNewUser(@RequestBody UserSignUp newUser) {
		System.out.println(newUser);
		return this.userservice.addUser(newUser);
	}

	@PostMapping(path = "/addNewRetailer")
	public int addNewRetailer(@RequestBody RetailerSignUp newRetailer) {
		return this.retailerservice.addRetailer(newRetailer);
	}
	
	@GetMapping(path="/getAdmin/{aId}")
	public Admin getAdminById(@PathVariable("aId") int aId) {
		System.out.println(aId);
		return adminservice.findAdminById(aId);
	}
	
	@GetMapping(path = "/requests/{aId}")
	public List<ProductForApprovalDTO> cviewProductstobeApproved(@PathVariable("aId") int aId)
	{
			List<ProductForApproval> prodforapps =adminservice.viewProductstobeApproved(aId);	
			List<ProductForApprovalDTO> dto = new ArrayList<ProductForApprovalDTO>();
			for(ProductForApproval p:prodforapps)
			{
				ProductForApprovalDTO prod_dto1 = new ProductForApprovalDTO();
				prod_dto1.setpReqId(p.getpReqId());
				prod_dto1.setpName(p.getpName());
				prod_dto1.setpCategory(p.getpCategory());
				prod_dto1.setpBrand(p.getpBrand());
				prod_dto1.setpDesc(p.getpDesc());
				prod_dto1.setpPrice(p.getpPrice());
				prod_dto1.setpSubCategory(p.getpSubCategory());
				prod_dto1.setpImage(p.getpImage());
				prod_dto1.setpStatus(p.getpStatus());
				prod_dto1.setpStock(p.getpStock());
				prod_dto1.setrId(p.getRetailer().getrId());
				dto.add(prod_dto1);
			}
			return dto;
		}
	@GetMapping(path = "allProducts/{aId}")
	public List<ProductDTO> cviewProducts(@PathVariable("aId") int aId){
		List<Product> prods =adminservice.viewProducts(aId);
		
		List<ProductDTO> dto = new ArrayList<>();
		for(Product p:prods)
		{
			ProductDTO prod_dto1 = new ProductDTO();
			prod_dto1.setrId(p.getRetailer());
			prod_dto1.setpId(p.getpId());
			prod_dto1.setpName(p.getpName());
			prod_dto1.setpCategory(p.getpCategory());
			prod_dto1.setpBrand(p.getpBrand());
			prod_dto1.setpDesc(p.getpDesc());
			prod_dto1.setpPrice(p.getpPrice());
			prod_dto1.setpSubCategory(p.getpSubCategory());
			prod_dto1.setpImage(p.getpImage());
			prod_dto1.setpStock(p.getpStock());
			dto.add(prod_dto1);	
		}
		return dto;
	}
	@PostMapping(path = "approveProduct/{aId}")
	public boolean approveProduct(@PathVariable("aId") int aId,@RequestBody ProductForApprovalDTO pfa){
		System.out.println(pfa.getpReqId());
			return adminservice.approveProductByrqID(aId,pfa.getpReqId());
	}
	@PostMapping(path = "rejectProduct/{aId}")
	public boolean rejectProduct(@PathVariable("aId") int aId,@RequestBody ProductForApprovalDTO pfa){
		System.out.println(pfa.getpReqId());
			return adminservice.rejectProductByrqID(aId,pfa.getpReqId());
	}
	
	@GetMapping(path = "getAllRetailers")
	public List<Retailer> getAllRetailers(){
		List<Retailer> dto=adminservice.viewAllRetailers();
		return dto;
	}
	@GetMapping(path = "deleteRetailer/{rId}")
	public List<Retailer> deleteRetailer(@PathVariable("rId") int rId){
		List<Retailer> dto=adminservice.deleteRetailer(rId);
		return dto;
	}
	@PostMapping(path = "addRetailer/{aId}")
	public boolean addRetailer(@PathVariable("aId") int aId,@RequestBody RetailerSignUp retailer){
		return adminservice.addRetailer(retailer);
	}
	
	@PostMapping(path = "/generateOTP") //-------------generateOTP-------------------------------
	public int generateOTP(@RequestBody String email)
	{
		return userservice.generateOTP(email);
	}
	
	@PostMapping(path = "/generateOTPById") //-------------generateOTP-------------------------------
	public int generateOTP(@RequestBody int uId)
	{
		System.out.println(uId);
		return userservice.generateOTPById(uId);
	}
	
	@PostMapping(path = "/resetPassword") //-------------generateOTP-------------------------------
	public int resetPassword(@RequestBody Login login)
	{
		return userservice.resetPass(login);
	}
	
	/*@GetMapping(path = "getProductBySearch/{keyword}")
	public List<Product> getAllProduct(@PathVariable("keyword") String keyword){
		List<Product> dto=userservice.getAllProductByCat(keyword);
		return dto;
	}*/
	
	@GetMapping(path = "getProductById/{pId}")
	public Product getAllProduct(@PathVariable("pId") int pId){
		Product dto=userservice.getAllProductByPID(pId);
		return dto;
	}

	@PostMapping(path = "/addToCart") //-------------generateOTP-------------------------------
	public int addToCart(@RequestBody CartDTO cart)
	{
		return cartservice.findaddToCart(cart.getuId(), cart.getpId());
	}
	
	@GetMapping(path = "/addToCompare/{uId}/{pId}") //-------------generateOTP-------------------------------
	public int addToCompare(@PathVariable("pId") int pId,@PathVariable("uId") int uId)
	{
		return cartservice.addToCompare(uId,pId);
	}

	
	@GetMapping(path = "getCart/{uId}")
	public List<CartMyDTO> getMyCart(@PathVariable("uId") int uId){
		List<CartMyDTO> dto = cartservice.findviewCart(uId);
		return dto;
	}
	
	@GetMapping(path = "getAddress/{uId}")
	public User getAddress(@PathVariable("uId") int uId){
		return userservice.findgetUserById(uId);
	}
	
	@PutMapping(path = "updateAddress")
	public User updateAddress(@RequestBody User user){
		return userservice.findupdateUser(user.getuId(), user);
	}
	
	@PostMapping(path = "makePayment") //-------------placing order-------------------------------
	public long makePayment(@RequestBody PaymentDTO payment)
	{
		System.out.println(payment);
		return userservice.makePayment(payment);
	}
	
	@GetMapping(path = "getOrders/{uId}")
	public List<Order> getOrders(@PathVariable("uId") int uId){
		System.out.println(uId);
		List<Order> dto = orderservice.getMyOrders(uId);
		return dto;
	}
	
	@GetMapping(path = "getOrderDetails/{oId}")
	public List<OrderDetail> getOrderDetails(@PathVariable("oId") long oId){
		System.out.println(oId);
		List<OrderDetail> dto = orderservice.getOrderDetail(oId);
		return dto;
	}
	@GetMapping(path = "getUserById/{uId}")
	public User getUserById(@PathVariable("uId") int uId){
		System.out.println(uId);
		User dto = userservice.findgetUserById(uId);
		System.out.println(dto);
		return dto;
	}
	
	@GetMapping(path = "deleteFromCart/{cId}")
	public boolean deleteFromCart(@PathVariable("cId") int cId){
		return cartservice.finddeleteCartBycId(cId);
	}
	
	@GetMapping(path = "updateMyCart/{cId}/{addOrMinus}")
	public boolean updateCart(@PathVariable("cId") int cId,@PathVariable("addOrMinus") int addOrMinus){
		return cartservice.findupdateCart(cId, addOrMinus);
	}
	
	@GetMapping(path = "getCompare/{uId}")
	public Set<Compare> getCompare(@PathVariable("uId") int uId){
		System.out.println(uId);
		return cartservice.getCompare(uId);
	}
	
	@GetMapping(path = "removeFromComp/{compId}")
	public Set<Compare> deleteFromComp(@PathVariable("compId") int compId){
		return cartservice.deleteFromComp(compId);
	}
}
