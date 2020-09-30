package com.lti.dao;

import java.util.List;

import com.lti.model.OrderDetail;

public interface OrderDao {
	public List<OrderDetail> getOrderDetailById(int odId);
	
	

}
