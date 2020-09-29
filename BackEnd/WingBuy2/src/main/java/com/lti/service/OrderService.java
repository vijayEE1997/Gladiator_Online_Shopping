package com.lti.service;

import java.util.List;

import com.lti.model.OrderDetail;

public interface OrderService {
	public List<OrderDetail> findgetOrderDetailById(int odId);
}
