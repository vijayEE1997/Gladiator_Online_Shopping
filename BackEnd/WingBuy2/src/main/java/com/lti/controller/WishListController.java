package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.lti.dto.CartMyDTO;
import com.lti.dto.WishListDTO;
import com.lti.dto.WishMyDTO;
import com.lti.model.WishList;
import com.lti.service.WishListService;

@RestController
@RequestMapping(path = "admin")
@CrossOrigin
public class WishListController {
	@Autowired
	private WishListService wishlistservice;

	@PostMapping(path = "addToWishlist") 
	public int addToWishList(@RequestBody WishListDTO wishlist)
	{
		System.out.println(wishlist);
		return wishlistservice.findaddToWishList(wishlist.getuId(),wishlist.getpId());
	}
	
	@DeleteMapping(path = "deleteFromWishlist//{wId}")
	public boolean cfinddeleteWishList(@PathVariable("wId") int wId) {
		System.out.println(wId);
		return wishlistservice.finddeleteWishList(wId);
	}
	
	@GetMapping(path = "getWishlist/{uId}")
	public List<WishMyDTO> getMyCart(@PathVariable("uId") int uId){
		List<WishMyDTO> dto = wishlistservice.findviewWishList(uId);
		return dto;
	}
	
//	@GetMapping(path = "deleteMyWishList/{uId}")
//	public boolean cfinddeleteMyWishList(@PathVariable("uId") int uId) {
//		return wishlistservice.finddeleteWishListByuId(uId);
//	}
	
//	@GetMapping(path = "getMyWishlist/{uId}")
//	public List<WishListDTO> getMyWishlist(@PathVariable("uId") int uId){
//		List<WishList> wishlists = wishlistservice.findviewWishList(uId);
//		List<WishListDTO> dto = new ArrayList<>();
//		for(WishList w:wishlists){
//			WishListDTO dto1 = new WishListDTO();
//			dto1.setpId(w.getwProducts().getpId());
//			dto1.setpBrand(w.getwProducts().getpBrand());
//			dto1.setpName(w.getwProducts().getpName());
//			dto1.setpPrice(w.getwProducts().getpPrice());
//			dto1.setuId(w.getwUser().getuId());
//			dto.add(dto1);
//		}
//		return dto;
//	}
}
