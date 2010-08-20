package progtest.database;

import org.hibernate.Session;

import progtest.common.Evaluation;
import progtest.util.HibernateUtil;

public class EvaluationDAO {

	public static void insert(Evaluation evaluation) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(evaluation);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void update(Evaluation evaluation) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(evaluation);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void delete(Evaluation evaluation) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(evaluation);
		session.getTransaction().commit();
		session.close();
	}

}
