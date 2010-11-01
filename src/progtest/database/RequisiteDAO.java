package progtest.database;

import org.hibernate.Session;

import progtest.common.Requisite;
import progtest.util.HibernateUtil;

public class RequisiteDAO {

	public static void insert(Requisite requisite) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(requisite);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void update(Requisite requisite) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(requisite);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void delete(Requisite requisite) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(requisite);
		session.getTransaction().commit();
		session.close();
	}

}
