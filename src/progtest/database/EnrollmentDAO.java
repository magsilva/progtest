package progtest.database;

import org.hibernate.Session;

import progtest.common.Assignment;
import progtest.common.Submission;
import progtest.common.Enrollment;
import progtest.util.HibernateUtil;

public class EnrollmentDAO {
	
	public static void insert(Enrollment enrollment) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(enrollment);
		session.getTransaction().commit();
		session.close();
		insertEvaluations(enrollment);
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
		deleteEvaluations(enrollment);
	}

	private static void insertEvaluations(Enrollment enrollment) {
		for(Assignment assignment : Querier.getAssignments(enrollment.getCourse())) {
			Submission submission = new Submission();
			submission.setAssignment(assignment);
			submission.setStudent(enrollment.getStudent());
			SubmissionDAO.insert(submission);
		}
	}

	private static void deleteEvaluations(Enrollment enrollment) {
		for(Assignment assignment : Querier.getAssignments(enrollment.getCourse())) {
			Submission submission = Querier.getEvaluation(enrollment.getStudent(), assignment);
			SubmissionDAO.delete(submission);
		}
	}

}
