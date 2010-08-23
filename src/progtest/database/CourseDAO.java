package progtest.database;

import org.hibernate.Session;

import progtest.common.Course;
import progtest.util.HibernateUtil;

public class CourseDAO {

	public static void insert(Course course) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(course);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void update(Course course) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(course);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void delete(Course course) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(course);
		session.getTransaction().commit();
		session.close();
	}

}
