package progtest.database;

import org.hibernate.Session;

import progtest.common.Submission;
import progtest.util.HibernateUtil;

public class SubmissionDAO {

	public static void insert(Submission submission) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(submission);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void update(Submission submission) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(submission);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void delete(Submission submission) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(submission);
		session.getTransaction().commit();
		session.close();
	}

}
