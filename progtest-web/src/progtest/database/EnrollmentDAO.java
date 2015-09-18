package progtest.database;

import org.hibernate.Session;

import progtest.common.Enrollment;
import progtest.util.HibernateUtil;

public class EnrollmentDAO {
	
	public static void insert(Enrollment enrollment) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(enrollment);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void update(Enrollment enrollment) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(enrollment);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void delete(Enrollment enrollment) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(enrollment);
		session.getTransaction().commit();
		session.close();
	}

}
