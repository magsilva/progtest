package progtest.database;

import org.hibernate.Session;

import progtest.common.AssignmentCriterion;
import progtest.util.HibernateUtil;

public class AssignmentCriterionDAO {

	public static void insert(AssignmentCriterion assignmentCriterion) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(assignmentCriterion);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void update(AssignmentCriterion assignmentCriterion) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(assignmentCriterion);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void delete(AssignmentCriterion assignmentCriterion) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(assignmentCriterion);
		session.getTransaction().commit();
		session.close();
	}

}
