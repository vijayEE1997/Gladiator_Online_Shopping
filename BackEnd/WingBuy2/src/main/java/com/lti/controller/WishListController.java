package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.lti.model.WishList;
import com.lti.service.WishListService;

@RestController
@RequestMapping(path = "Wbuy")
@CrossOrigin
public class WishListController {
	@Autowired
	private WishListService wishlistservice;

	@GetMapping(path = "{uId,pId}")
	public boolean cfindaddToWishList(@PathVariable("uId") int uId, @PathVariable("pId") int pId) {
		return wishlistservice.findaddToWishList(uId, pId);
	}

	@GetMapping(path = "{wId}")
	public boolean cfinddeleteWishList(@PathVariable("wId") int wId) {
		return wishlistservice.finddeleteWishList(wId);
	}

	@GetMapping(path = "{wId}")
	public List<WishList> cfindviewWishList(@PathVariable("uId") int uId) {
		List<WishList> wishlists = wishlistservice.findviewWishList(uId);
		return wishlists;
	}
}
