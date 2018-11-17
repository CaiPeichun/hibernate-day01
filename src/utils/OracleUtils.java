package utils;
//抽取hibernate的工具类

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OracleUtils {
	public static Configuration configuration;
	public static SessionFactory sessionFactory;
	public static Session session;
	
	static {
		configuration =  new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	//获取一个session
	public static Session getSession() {
		session = sessionFactory.openSession();
		return session;
	}
	
	public void close() {
		session.close();
		sessionFactory.close();
	}
}
