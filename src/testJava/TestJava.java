package testJava;

import java.sql.Connection;

import javax.persistence.ParameterMode;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;

import utils.OracleUtils;

public class TestJava {

	public static void main(String[] args) {
		/*OracleUtils utils = new OracleUtils();
		Session session = utils.getSession();
		Transaction tx = session.beginTransaction();
		ProcedureCall pCall = session.createStoredProcedureCall("empproc");
		pCall.registerParameter("7934", String.class, ParameterMode.IN);
		pCall.execute();
		System.out.println("调用存储过程");
		tx.commit();
		utils.close();*/
		TestJava testJava = new TestJava();
		testJava.callPtocedu("7934");
	}
	public void callPtocedu(String empno) {
		//1.调用存储过程的语句
		String sql = "{call empproc(?)}";
		OracleUtils utils = new OracleUtils();
		Session session = utils.getSession();
		Transaction tx = session.beginTransaction();
		//2.调用createNativeQuery（）方法，setParameter（）设置参数
		 session.createNativeQuery(sql).setParameter(1, empno).executeUpdate();
		 System.out.println("excure");
		 //3.提交事务
		 tx.commit();
		 utils.close();
	}

}
