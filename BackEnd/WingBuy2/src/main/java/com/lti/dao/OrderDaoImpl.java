package com.lti.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.lti.model.Cart;
import com.lti.model.Order;
import com.lti.model.OrderDetail;
import com.lti.model.Payment;
import com.lti.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("orderdao")
public class OrderDaoImpl implements OrderDao {

	@PersistenceContext
	private EntityManager entityManager;

	CartDao cartdao = new CartDaoImpl();
	PaymentDao paymentdao = new PaymentDaoImpl();
	UserDao userdao = new UserDaoImpl();
	Cart delcart = new Cart();
	Payment payment = null;

	private List<Cart> cart = null;

	@Transactional(propagation = Propagation.REQUIRED)
	public void order(long pay_Id, int uId) {
		int qsum = 0;
		double psum = 0;
		cart = cartdao.viewCart(uId);
		for (Cart c : cart) {
			System.out.println(c);
			qsum += c.getpIdQty();
			psum += (c.getpIdQty() * c.getcProducts().getpPrice());
		}
		payment = paymentdao.getPaymentById(pay_Id);
		Order order = new Order();
		order.setoQty(qsum);
		order.setoPrice(psum);
		order.setPayment(payment);
		order.setoAddress(userdao.getUserById(uId).getuAddress());

		order.setoPurchaseDate(new Date());
		/*
		 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); Calendar c
		 * = Calendar.getInstance(); c.add(Calendar.DAY_OF_MONTH, 7); String
		 * newDate = sdf.format(c.getTime());
		 * System.out.println("7 days later: " + cal.getTime());
		 */
		order.setoId((new Timestamp(System.currentTimeMillis())).getTime());
		order.setoDeliveryDate(new Date());
		long oId = order.getoId();

		entityManager.persist(order);
		entityManager.find(Order.class, oId);
		addOrderDetail(order);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<OrderDetail> getOrderDetailById(int odId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void addOrderDetail(Order order) {

		for (Cart c : cart) {
			OrderDetail orderdetail = new OrderDetail();
			orderdetail.setOdOrder(order);
			orderdetail.setOdProducts(c.getcProducts());
			orderdetail.setOdQty(c.getpIdQty());
			Product product = c.getcProducts();
			// updating product table
			product.setpStock(product.getpStock() - c.getpIdQty());
			// updating product table

			entityManager.persist(orderdetail);
			entityManager.merge(product);

		}
		// delete cart
		int uId = payment.getpUser().getuId();
		cartdao.deleteCartByuId(uId);

	}
}
