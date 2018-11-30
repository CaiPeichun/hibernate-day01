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
	
	@Test
	public void savedemo() {
		
		Customer customer = new Customer();
		customer.setName("һ�Զ�ӳ��");
		customer.setAge(2);
		MyOrder myOrder = new MyOrder();
		myOrder.setTotalprice(1121.0);
		customer.getOrders().add(myOrder);
		myOrder.setCustomer(customer);
		Transaction tx = session.beginTransaction();
//		session.save(customer);
		session.save(myOrder);
		tx.commit();
	}
	
	//����������caacadeɾ��ʱ��ɾ������Ҳ��ɾ���˿���Ϣ
	@Test
	public void deletedemo() {
		MyOrder order = session.get(MyOrder.class, 73);
		Transaction tx = session.beginTransaction();
		session.delete(order);
		tx.commit();
		
	}
	
	//һ�����ü���ɾ����ʱ��ɾ���˿�Ҳ��ɾ��������Ϣ��
	@Test
	public void deleteCustomer() {
//		Customer customer = session.get(Customer.class,213);
//		Transaction tx = session.beginTransaction();
//		session.delete(customer);
//		tx.commit();
		
		Transaction tx = session.beginTransaction();
		Customer customer = session.load(Customer.class, 215);
		session.delete(customer);
		tx.commit();
	}
	
	//����inverse����
	@Test
	public void testinverse() {
		Transaction tx = session.beginTransaction();
		Customer customer = new Customer();
		customer.setName("aaa");
		MyOrder order = new MyOrder();
		order.setTotalprice(2000.0);
		customer.getOrders().add(order);
		session.save(customer);
		tx.commit();
	}
}
