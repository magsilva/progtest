package progtest.database;

import org.hibernate.Session;

import progtest.common.StudentCourse;
import progtest.util.HibernateUtil;

public class StudentCourseDAO {
	
	public static void insert(StudentCourse studentCourse) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(studentCourse);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void update(StudentCourse studentCourse) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(studentCourse);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void delete(StudentCourse studentCourse) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(studentCourse);
		session.getTransaction().commit();
		session.close();
	}

}
