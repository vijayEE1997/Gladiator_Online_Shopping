package com.lti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.AdminDao;
import com.lti.dao.CartDao;
import com.lti.dao.UserDao;
import com.lti.dto.CartDTO;
import com.lti.dto.CartMyDTO;
import com.lti.dto.ProductDTO;
import com.lti.model.Cart;
import com.lti.model.Compare;
import com.lti.model.Product;
@Service("cartservice")
@Scope(scopeName="singleton")
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao cartdao = null;
	
	@Autowired
	private UserDao userdao=null; 

	@Override
	public int findaddToCart(int uId, int pId) {
		return cartdao.addToCart(uId, pId);
	}

	@Override
	public boolean findupdateCart(int cId, int addOrMinus) {
		return cartdao.updateCart(cId, addOrMinus);
	}

	@Override
	public boolean finddeleteCartBycId(int cId) {
		return cartdao.deleteCartBycId(cId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<CartMyDTO> findviewCart(int uId) {
		List<Cart> carts = cartdao.viewCart(uId);
		List<CartMyDTO> dto= new ArrayList<>();
		for(Cart c:carts)
		{
			CartDTO cartD=new CartDTO();
			cartD.setcId(c.getcId());
			cartD.setpId(c.getcProducts().getpId());
			cartD.setuId(c.getcUser().getuId());
			cartD.setQty(c.getpIdQty());
			
			CartMyDTO dtos=new CartMyDTO();
			
			Product p=userdao.findAllProductByPID(cartD.getpId());
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
			dtos.setCartdto(cartD);
			dtos.setProductdto(prod_dto1);
			dto.add(dtos);
		}
		return dto;
	}


	@Override
	public boolean finddeleteCartByuId(int uId) {
		return cartdao.deleteCartByuId(uId);
	}

	@Override
	public int addToCompare(int uId, int pId) {
		return cartdao.addToCompare(uId,pId);
	}

	@Override
	public Set<Compare> getCompare(int uId) {
		return cartdao.getCompare(uId);
	}

	@Override
	public Set<Compare> deleteFromComp(int compId) {
		return cartdao.removeFromComp(compId);
	}

}
