package com.lti.dto;

import com.lti.model.Product;
import com.lti.model.WishList;

public class WishMyDTO {
	private WishListDTO wishlistdto;
	private ProductDTO productdto;
	public WishMyDTO() {
		super();
	}
	public WishMyDTO(WishListDTO wishlistdto, ProductDTO productdto) {
		super();
		this.wishlistdto = wishlistdto;
		this.productdto = productdto;
	}
	public WishListDTO getWishlistdto() {
		return wishlistdto;
	}
	public void setWishlistdto(WishListDTO wishlistdto) {
		this.wishlistdto = wishlistdto;
	}
	public ProductDTO getProductdto() {
		return productdto;
	}
	public void setProductdto(ProductDTO productdto) {
		this.productdto = productdto;
	}
	@Override
	public String toString() {
		return "WishMyDTO [wishlistdto=" + wishlistdto + ", productdto=" + productdto + "]";
	}
	
	
}
