package com.lti.dao;

import java.util.List;

import com.lti.model.Order;
import com.lti.model.OrderDetail;

public interface OrderDao {
	public List<OrderDetail> getOrderDetailById(long oId);  //By Order ID
//	public List<Order> getOrders()
	public void order(long pay_Id, int uId);
	public List<Order> getOrders(int uId);
	public List<OrderDetail> getProfit(int rId);
	

}
