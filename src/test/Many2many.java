package test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import pojo.Course;
import pojo.Student;
import utils.OracleUtils;

public class Many2many {
	
	@Test
	public void saveMany2many() {
		OracleUtils utils = new OracleUtils();
		Session session = utils.getSession();
		Course c1 = new Course("语文");
		Course c2 = new Course("数学");
		Student s1 = new Student("小明");
		Student s2 = new Student("小红");
		c1.getStus().add(s2);
		c1.getStus().add(s1);
		c2.getStus().add(s2);
		c2.getStus().add(s1);
		
		s1.getCourse().add(c2);
		s1.getCourse().add(c1);
		s2.getCourse().add(c1);
		s2.getCourse().add(c2);
		Transaction tx = session.beginTransaction();
		session.save(s2);
		session.save(s1);
		session.save(c1);
		session.save(c2);
		tx.commit();
		utils.close();
		
	}
	
	@Test
	public void removeMany2many() {
		OracleUtils utils = new OracleUtils();
		Session session = utils.getSession();
		Transaction tx = session.beginTransaction();
		Student student = (Student)session.get(Student.class, 218);
		Course course = (Course)session.get(Course.class, 220);
		student.getCourse().remove(course);
		course.getStus().remove(student);
		tx.commit();
		utils.close();
	}
}
