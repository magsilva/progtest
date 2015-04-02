package progtest.database;

import org.hibernate.Session;

import progtest.common.User;
import progtest.util.HibernateUtil;

public class UserDAO {
	
	public static void insert(User user) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void update(User user) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void delete(User user) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	}

}
