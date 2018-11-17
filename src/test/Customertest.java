package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import pojo.Customer;

public class Customertest {

	@Test
	public void demo1() {
		
		Configuration configuration = new Configuration().configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		System.out.println("jianli");
		Customer customer = new Customer();

		customer.setName("Ð¡²Ë");
		customer.setAge(22);
		session.save(customer);
//		System.out.println("ï¿½ï¿½ï¿½Ó³É¹ï¿½");
//		Customer customer = (Customer)session.get(Customer.class,63);
//		System.out.println(customer.getName());
		
		tx.commit();
		
		session.close();
//		sessionFactory.close();
	}
}
