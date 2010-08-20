package progtest.database;

import org.hibernate.Session;

import progtest.common.Assignment;
import progtest.common.Evaluation;
import progtest.common.StudentCourse;
import progtest.util.HibernateUtil;

public class StudentCourseDAO {
	
	public static void insert(StudentCourse studentCourse) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(studentCourse);
		session.getTransaction().commit();
		session.close();
		insertEvaluations(studentCourse);
	}
	
	public static void update(StudentCourse studentCourse) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(studentCourse);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void delete(StudentCourse studentCourse) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(studentCourse);
		session.getTransaction().commit();
		session.close();
		deleteEvaluations(studentCourse);
	}

	private static void insertEvaluations(StudentCourse studentCourse) {
		for(Assignment assignment : Querier.getAssignments(studentCourse.getCourse())) {
			Evaluation evaluation = new Evaluation();
			evaluation.setAssignment(assignment);
			evaluation.setStudent(studentCourse.getStudent());
			EvaluationDAO.insert(evaluation);
		}
	}

	private static void deleteEvaluations(StudentCourse studentCourse) {
		for(Assignment assignment : Querier.getAssignments(studentCourse.getCourse())) {
			Evaluation evaluation = Querier.getEvaluation(studentCourse.getStudent(), assignment);
			EvaluationDAO.delete(evaluation);
		}
	}

}
