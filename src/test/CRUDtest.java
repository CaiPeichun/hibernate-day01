package test;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.common.util.impl.Log;
import org.hibernate.query.Query;
import org.junit.Test;

import pojo.Customer;
import utils.OracleUtils;

public class CRUDtest {
	OracleUtils mUtils  = new OracleUtils();
	Session session = mUtils.getSession();
	
	//ÔøΩÔøΩ
	@Test
	public void insert() {
		Customer customer = new Customer();
		customer.setName("≤‚ ‘");
		customer.setAge(8);	
//		Logger log = Logger.getLogger(CRUDtest.class);
//		log.error("testing");
//		log.error("begin to parse category:"+string);
		//log.info("begin to parse category:"+string);
		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit();
		mUtils.close();
	}
	
	//ÔøΩÔøΩ
	@Test
	public void update1() {
		Customer customer = session.get(Customer.class, 58);
		customer.setName("Â®ÅÂªâ");
		Transaction tx = session.beginTransaction();
//		session.update(customer);
		tx.commit();
		mUtils.close();
	}
	
	//…æ
	@Test
	public void delete1() {
		Customer customer = session.get(Customer.class,5);
		Transaction tx = session.beginTransaction();
		session.delete(customer);
		tx.commit();
		mUtils.close();
		
	}
	
	//ÔøΩÔøΩ-HQL
	@Test
	public void query() throws UnsupportedEncodingException {
		Query query = session.createQuery("from Customer where id=?");
		query.setParameter(0, 58);
		String string ;
		List<Customer> list =(List<Customer>)query.list();
		for(Customer customer:list) {
//			string=new String(customer.getName().getBytes("UTF-8"), "GBK");
			System.out.println(customer.getName());
			System.out.println("ÊâìÂç∞");
//			System.out.println(string);
		}
		mUtils.close();
	}
	
	
}
