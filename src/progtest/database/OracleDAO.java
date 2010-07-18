package progtest.database;

import org.hibernate.Session;

import progtest.common.Oracle;
import progtest.util.HibernateUtil;

public class OracleDAO {

	public static void insert(Oracle oracle) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(oracle);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void update(Oracle oracle) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(oracle);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void delete(Oracle oracle) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(oracle);
		session.getTransaction().commit();
		session.close();
	}

}
