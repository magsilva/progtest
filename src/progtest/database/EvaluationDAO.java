package progtest.database;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import progtest.common.Assignment;
import progtest.common.Evaluation;
import progtest.common.Course;
import progtest.common.User;
import progtest.util.HibernateUtil;

public class EvaluationDAO {
	
	private static final String GET_EVALUATION = "from Evaluation evaluation where evaluation.student = ? and evaluation.course = ? and evaluation.assignment = ?";
	
	private static final String GET_EVALUATIONS = "from Evaluation evaluation where evaluation.student = ? order by evaluation.assignment.endDate";

	private static final String GET_EVALUATIONS_BY_COURSE = "from Evaluation evaluation where evaluation.student = ? and evaluation.assignment.course = ? order by evaluation.assignment.endDate";

	private static final String GET_OUTSTANDING_EVALUATIONS_BY_COURSE = "from Evaluation evaluation where evaluation.student = ? and evaluation.assignment.course = ? and evaluation.submissionDate = NULL order by evaluation.assignment.endDate";

	private static final String GET_OUTSTANDING_EVALUATIONS = "from Evaluation evaluation where evaluation.student = ? and evaluation.submissionDate = NULL order by evaluation.assignment.endDate";

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

	public static Evaluation getEvaluation(User user, Assignment assignment) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(GET_EVALUATION);
		query.setInteger(0, user.getIdCode());
		query.setInteger(1, assignment.getCourse().getIdCode());
		query.setInteger(2, assignment.getIdCode());
		Evaluation evaluation = (Evaluation) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return evaluation;
	}

	@SuppressWarnings("unchecked")
	public static List<Evaluation> getEvaluations(User user) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(GET_EVALUATIONS);
		query.setInteger(0, user.getIdCode());
		List<Evaluation> evaluations = (List<Evaluation>) query.list();
		session.getTransaction().commit();
		session.close();
		return evaluations;
	}

	@SuppressWarnings("unchecked")
	public static List<Evaluation> getEvaluations(User user, Course course) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(GET_EVALUATIONS_BY_COURSE);
		query.setInteger(0, user.getIdCode());
		query.setInteger(1, course.getIdCode());
		List<Evaluation> evaluations = (List<Evaluation>) query.list();
		session.getTransaction().commit();
		session.close();
		return evaluations;
	}

	@SuppressWarnings("unchecked")
	public static List<Evaluation> getOutstandingEvaluations(User user, Course course) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(GET_OUTSTANDING_EVALUATIONS_BY_COURSE);
		query.setInteger(0, user.getIdCode());
		query.setInteger(1, course.getIdCode());
		List<Evaluation> evaluations = (List<Evaluation>) query.list();
		session.getTransaction().commit();
		session.close();
		return evaluations;
	}

	@SuppressWarnings("unchecked")
	public static List<Evaluation> getOutstandingEvaluations(User user) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(GET_OUTSTANDING_EVALUATIONS);
		query.setInteger(0, user.getIdCode());
		List<Evaluation> avaliations = (List<Evaluation>) query.list();
		session.getTransaction().commit();
		session.close();
		return avaliations;
	}

}
