package progtest.database;

import org.hibernate.Session;

import progtest.common.Criterion;
import progtest.util.HibernateUtil;

public class CriterionDAO {

	public static void insert(Criterion criterion) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(criterion);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void update(Criterion criterion) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(criterion);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void delete(Criterion criterion) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(criterion);
		session.getTransaction().commit();
		session.close();
	}

}
