package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.dao.OrderDao;
import com.lti.dao.PaymentDao;
import com.lti.model.Order;
import com.lti.model.OrderDetail;
import com.lti.model.Payment;

@Service("orderservice")
@Scope(scopeName="singleton")
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderdao = null;

	@Override
	public List<OrderDetail> findgetOrderDetailById(int odId) {
	 return	orderdao.getOrderDetailById(odId);
	}

	@Override
	public List<Order> getMyOrders(int uId) {
		return orderdao.getOrders(uId);
	}

	@Override
	public List<OrderDetail> getOrderDetail(long oId) {
		return orderdao.getOrderDetailById(oId);
	}

//	@Override
//	public List<OrderDetail> getOrderProfit(int rId) {
//		return orderdao.getProfit(rId);
//	}

}
