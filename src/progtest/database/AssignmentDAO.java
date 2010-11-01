package progtest.database;

import org.hibernate.Session;

import progtest.common.Assignment;
import progtest.common.Submission;
import progtest.common.User;
import progtest.util.HibernateUtil;

public class AssignmentDAO {

	public static void insert(Assignment assignment) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(assignment);
		session.getTransaction().commit();
		session.close();
		insertEvaluations(assignment);
	}

	public static void update(Assignment assignment) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(assignment);
		session.getTransaction().commit();
		session.close();
	}

	public static void delete(Assignment assignment) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(assignment);
		session.getTransaction().commit();
		session.close();
	}

	private static void insertEvaluations(Assignment assignment) {
		for(User student : Querier.getStudents(assignment.getCourse())) {
			Submission submission = new Submission();
			submission.setAssignment(assignment);
			submission.setStudent(student);
			SubmissionDAO.insert(submission);
		}
	}

}
