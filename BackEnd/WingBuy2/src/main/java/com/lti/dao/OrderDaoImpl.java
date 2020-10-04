package com.lti.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.lti.model.Cart;
import com.lti.model.Order;
import com.lti.model.OrderDetail;
import com.lti.model.Payment;
import com.lti.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("orderdao")
public class OrderDaoImpl implements OrderDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private UserDao userdao=null;
	
	@Autowired
	private CartDao cartdao=null;
	
	@Autowired
	private PaymentDao paymentdao=null;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void order(long pay_Id, int uId) {
		int qsum = 0;
		double psum = 0;
		List<Cart> cart = cartdao.viewCart(uId);
		for (Cart c : cart) {
			System.out.println(c);
			qsum += c.getpIdQty();
			psum += (c.getpIdQty() * c.getcProducts().getpPrice());
		}
		Payment payment = paymentdao.getPaymentById(pay_Id);
		
		Order order = new Order();
		
		order.setoId((new Timestamp(System.currentTimeMillis())).getTime());
		order.setPayment(payment);
		order.setoPrice(psum);
		order.setoQty(qsum);
		order.setoDeliveryDate(new Date());
		order.setoPurchaseDate(new Date());
		order.setoAddress(userdao.getUserById(uId).getuAddress());
		
		List<OrderDetail> list=addOrderDetail(order,cart);
		for(OrderDetail od:list)
			order.addProductToOrder(od);
		entityManager.persist(order);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<OrderDetail> getOrderDetailById(long oId) {
		Order o=entityManager.find(Order.class,oId);
		List<OrderDetail> l=new ArrayList<OrderDetail>();
		Set<OrderDetail> odl=o.getpOrderDetails();
		for(OrderDetail od:odl)
			l.add(od);
		return l;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<OrderDetail> addOrderDetail(Order order,List<Cart> cart) {
		
		List<OrderDetail> list=new ArrayList<OrderDetail>();
		
		for (Cart c : cart) {
			OrderDetail orderdetail = new OrderDetail();
			
			orderdetail.setOdOrder(order);
			orderdetail.setOdProducts(c.getcProducts());
			orderdetail.setOdQty(c.getpIdQty());
			
			Product product = c.getcProducts();
			// updating product table
			product.setpStock(product.getpStock() - c.getpIdQty());
			// updating product table
			entityManager.merge(product);
			list.add(orderdetail);
		}
		// delete cart
		int uId = order.getPayment().getpUser().getuId();
		cartdao.deleteCartByuId(uId);

		return list;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Order> getOrders(int uId) {
		List<Payment> list=paymentdao.getallPayments(uId);
		List<Order> ol=new ArrayList<>();
		for(Payment p:list)
		{
//			long pId=p.getPayId();
//			String query="Select e from Order e where e.payment.payId=:pId";
//			TypedQuery<Order> t=entityManager.createQuery(query,Order.class);
//			t.setParameter("pId",pId);
//			Order o=t.getResultList().get(0);
//			if(o!=null)
			ol.add(p.getOrder());
		}
		return ol;
	}
}
