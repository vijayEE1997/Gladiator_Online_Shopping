package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.dao.OrderDao;
import com.lti.model.OrderDetail;

public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderdao = null;

	@Override
	public List<OrderDetail> findgetOrderDetailById(int odId) {
	 return	orderdao.getOrderDetailById(odId);
	}

}
