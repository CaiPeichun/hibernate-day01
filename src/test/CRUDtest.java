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
	
	//增加
	@Test
	public void insert() {
		Customer customer = new Customer();
		customer.setName("测试");
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
	
	//更新
	@Test
	public void update1() {
		Customer customer = session.get(Customer.class,71);
		customer.setName("更新");
		Transaction tx = session.beginTransaction();
		session.update(customer);
		tx.commit();
		mUtils.close();
	}
	
	//删
	@Test
	public void delete1() {
		Customer customer = session.get(Customer.class,153);
		Transaction tx = session.beginTransaction();
		session.delete(customer);
		tx.commit();
		mUtils.close();
		
	}
	
	//查找-HQL
	@Test
	public void query() throws UnsupportedEncodingException {
		Query query = session.createQuery("from Customer where id=?");
		query.setParameter(0, 58);
		String string ;
		List<Customer> list =(List<Customer>)query.list();
		for(Customer customer:list) {
//			string=new String(customer.getName().getBytes("UTF-8"), "GBK");
			System.out.println(customer.getName());
			System.out.println("查找");
//			System.out.println(string);
		}
		mUtils.close();
	}
	
	
}
