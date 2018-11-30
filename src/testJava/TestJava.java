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
		System.out.println("���ô洢����");
		tx.commit();
		utils.close();*/
		TestJava testJava = new TestJava();
		testJava.callPtocedu("7934");
	}
	public void callPtocedu(String empno) {
		//1.���ô洢���̵����
		String sql = "{call empproc(?)}";
		OracleUtils utils = new OracleUtils();
		Session session = utils.getSession();
		Transaction tx = session.beginTransaction();
		//2.����createNativeQuery����������setParameter�������ò���
		 session.createNativeQuery(sql).setParameter(1, empno).executeUpdate();
		 System.out.println("excure");
		 //3.�ύ����
		 tx.commit();
		 utils.close();
	}

}
