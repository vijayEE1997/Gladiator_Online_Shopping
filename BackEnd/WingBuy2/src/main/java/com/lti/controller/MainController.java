package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Admin;
import com.lti.model.Cart;
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
import com.lti.service.RetailerService;
import com.lti.service.UserService;
import com.lti.service.WishListService;
import com.lti.dto.Login;

@RestController
@RequestMapping(path = "buy")
@CrossOrigin
public class MainController {
	
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
	
	@PostMapping(path = "login")
	public int login(@RequestBody Login login)
	{
		System.out.println(login);
			return this.userservice.login(login);
			
		} /*catch (CustomerException e) {
			
			e.printStackTrace();
			return -100;
		}*/
	
//	@PostMapping(path = "/retailerLogin") 
//	public int retailerLogin(@RequestBody Login login)
//	{
//			return this.retailerservice.loginRetailer(login.getEmail(), login.getPassword());
//		} /*catch (CustomerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return -100;
//		}*/
//
//	@GetMapping(path = "{aId}")
//	public Admin cgetAdminById(@PathVariable("aId") int aId) {
//		Admin admin = adminservice.findAdminById(aId);
//		return admin;
//	}
//
//	@GetMapping(path = "{aEmail,aPassword}")
//	public int cfindAdminByEmailAndPassword(@PathVariable("aEmail") String email,
//			@PathVariable("aPassword") String password) {
//		return (adminservice.findAdminByEmailAndPassword(email, password));
//
//	}
//
//	@GetMapping(path = "{aEmail}")
//	public Admin cfindAdminByEmail(@PathVariable("aId") String email) {
//		Admin admin = adminservice.findAdminByEmail(email);
//		return admin;
//	}
//	
//	@GetMapping(path = "{rId}")
//	public Retailer cfindgetRetailerById(@PathVariable("aId") int rId){
//		Retailer retailer = retailerservice.findgetRetailerById(rId);
//		return retailer;
//	}
//
//	@GetMapping(path = "{rEmail,rPassword}")
//	public int cfindgetRetailerByEmailAndPassword(String email, String password){
//		return (retailerservice.findgetRetailerByEmailAndPassword(email, password));
//	}
//	
//	@GetMapping(path = "{rEmail}")
//	public Retailer cfindgetRetailerByEmail(@PathVariable("rId")String email) {
//		Retailer retailer = retailerservice.findgetRetailerByEmail(email);
//		return retailer;
//	}
//	@GetMapping(path="/")// doubt
//	public List<Product> cfindshowMyApprovedProducts(int rId) {
//		List<Product> approvedProd = retailerservice.findshowMyApprovedProducts(rId);
//		return approvedProd;
//	}
//	
//	@GetMapping(path="/")//doubt
//	public List<Retailer> cfindshowAllRetailers() {
//		List<Retailer> retailers = retailerservice.findshowAllRetailers();
//		return retailers;
//}
//	@GetMapping(path="/")//doubt
//	public List<ProductForApproval> cfindshowMyRejectedProducts(int rId) {
//		List<ProductForApproval> rejectedProd = retailerservice.findshowMyRejectedProducts(rId);
//		return rejectedProd;
//	}
	
//	@GetMapping(path = "{uId}")
//	public User cfindgetUserById(@PathVariable("uId") int uId) {
//		User user = userservice.findgetUserById(uId);
//		return user;
//	}
//	
//	@GetMapping(path = "{uEmail,uPassword}")
//	public int ufindgetUserByEmailAndPassword(@PathVariable("uEmail")String email, @PathVariable("uPassword")String password) {
//		return (userservice.findgetUserByEmailAndPassword(email, password));
//	}
//	
//	@GetMapping(path = "{uEmail}")
//	public User cfindgetUserByEmail(@PathVariable("uEmail") String email) {
//		User user = userservice.findgetUserByEmail(email);
//		return user;
//	}
//	
//	@GetMapping(path = "{uId,uAddress}")
//	public boolean findaddAddress(@PathVariable("uId") int uId, @PathVariable("uAddress") String address) {
//		return (userservice.findaddAddress(uId, address));
//	}
//	
//	@GetMapping(path = "{uId}")
//	public List<Cart> cfindgetCartOfUser(@PathVariable("uId") int uId) {
//		List<Cart> carts = userservice.findgetCartOfUser(uId);
//		return carts;
//	}
//	
//	@GetMapping(path = "{uId}")
//	public List<WishList> cfindgetWishlistOfUser(@PathVariable("uId") int uId) {
//		List<WishList> wishlists = userservice.findgetWishlistOfUser(uId);
//		return wishlists;
//	}
//	
//	@GetMapping(path = "{uId,pId}")
//	public boolean cfindaddToCart(@PathVariable("uId") int uId, @PathVariable("pId")int pId) {
//		return cartservice.findaddToCart(uId, pId);
//	}
//	
//	@GetMapping(path = "{cId,addOrMinus}")
//	public boolean cfindupdateCart(@PathVariable("cId")int cId, @PathVariable("addOrMinus")int addOrMinus) {
//		return cartservice.findupdateCart(cId, addOrMinus);
//	}
//	
//	@GetMapping(path = "{cId}")
//	public boolean cfinddeleteCartBycId(@PathVariable("cId") int cId) {
//	return cartservice.finddeleteCartBycId(cId);
//	}
//	
//	@GetMapping(path = "{uId}")
//	public boolean cfinddeleteCartByuId(@PathVariable("uId") int uId) {
//	return cartservice.finddeleteCartByuId(uId);
//	}
//	
//	@GetMapping(path = "{uId}")
//	public List<Cart> cfindviewCart(@PathVariable("uId") int uId) {
//	List<Cart> carts = cartservice.findviewCart(uId);
//	return carts;
//}
//	@GetMapping(path = "{uId,pId}")
//	public boolean cfindaddToWishList(@PathVariable("uId")int uId, @PathVariable("pId")int pId) {
//		return wishlistservice.findaddToWishList(uId, pId);
//	}
//
//	@GetMapping(path = "{wId}")
//	public boolean cfinddeleteWishList(@PathVariable("wId") int wId) {
//		return wishlistservice.finddeleteWishList(wId);
//	}
//
//	@GetMapping(path = "{wId}")
//	public List<WishList> cfindviewWishList(@PathVariable("uId")int uId) {
//		List<WishList> wishlists= wishlistservice.findviewWishList(uId);
//		return wishlists;
//	}
//	
//	@GetMapping(path = "{uId,payType}")
//	public long cfindmakePayment(@PathVariable("uId")int uId,@PathVariable("payType")String payType) {
//		return paymentservice.findmakePayment(uId, payType);
//			}
//	
//	@GetMapping(path = "{pay_Id}")
//	public Payment cfindgetPaymentById(@PathVariable("pay_Id") long pay_Id) {
//		Payment payment = paymentservice.findgetPaymentById(pay_Id);
//		return payment;
//	}
//	
//	@GetMapping(path = "{odId}")
//	public List<OrderDetail> cfindgetOrderDetailById(@PathVariable("odId")int odId) {
//	List<OrderDetail> orderdetails=	orderservice.findgetOrderDetailById(odId);
//	return orderdetails;
//	}
}
