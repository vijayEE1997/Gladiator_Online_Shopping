package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.dao.CartDao;
import com.lti.dao.UserDao;
import com.lti.dao.WishListDao;
import com.lti.dto.CartDTO;
import com.lti.dto.CartMyDTO;
import com.lti.dto.ProductDTO;
import com.lti.dto.WishListDTO;
import com.lti.dto.WishMyDTO;
import com.lti.model.Cart;
import com.lti.model.Product;
import com.lti.model.WishList;
@Service("wishlistservice")
@Scope(scopeName="singleton")
public class WishListServiceImpl implements WishListService{
	
	@Autowired
	private WishListDao wishlistdao = null;
	
	@Autowired
	private UserDao userdao = null;

	@Override
	public int findaddToWishList(int uId, int pId) {
		return wishlistdao.addToWishList(uId, pId);
	}

	@Override
	public boolean finddeleteWishList(int wId) {
		return wishlistdao.deleteWishList(wId);
	}

	@Override
	public List<WishMyDTO> findviewWishList(int uId) {
		List<WishList> wishes = wishlistdao.viewWishList(uId);
		List<WishMyDTO> dto= new ArrayList<>();
		for(WishList w:wishes)
		{
			WishMyDTO dtos=new WishMyDTO();
			
			WishListDTO wishdto=new WishListDTO();
			wishdto.setpId(w.getwProducts().getpId());
			wishdto.setuId(uId);
			wishdto.setwId(w.getwId());
			
			Product p=userdao.findAllProductByPID(wishdto.getpId());
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
			
			dtos.setWishlistdto(wishdto);
			dtos.setProductdto(prod_dto1);
			dto.add(dtos);
		}
		return dto;
	}

}
