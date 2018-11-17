package test;

import javax.persistence.criteria.Order;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import pojo.Customer;
import pojo.MyOrder;
import utils.OracleUtils;

public class Onemanytest {
	Session session = OracleUtils.getSession();
	Transaction tx = session.beginTransaction();
	@Test
	public void savedemo() {
		
		Customer customer = new Customer();
		customer.setName("“ª∂‘∂‡”≥…‰");
		customer.setAge(2);
		MyOrder myOrder = new MyOrder();
		myOrder.setTotalprice(1121.0);
		customer.getOrders().add(myOrder);
		myOrder.setCustomer(customer);
		session.save(customer);
//		session.save(myOrder);
		tx.commit();
	}
	
	@Test
	public void deletedemo() {
		MyOrder order = session.get(MyOrder.class, 70);
		session.delete(order);
		tx.commit();
		
	}
	
}
