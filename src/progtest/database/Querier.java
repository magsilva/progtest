package progtest.database;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import progtest.common.Assignment;
import progtest.common.Course;
import progtest.common.Criterion;
import progtest.common.Evaluation;
import progtest.common.Oracle;
import progtest.common.Tool;
import progtest.common.User;
import progtest.util.HibernateUtil;

public class Querier {

	private static final String SELECT_USER_BY_USERNAME = "from User user where user.userName = ?";

	private static final String SELECT_USER_BY_EMAIL = "from User user where user.email = ?";

	private static final String SELECT_USER_BY_EMAIL_AND_NOT_USERNAME = "from User user where user.email = ? and user.userName != ?";

	private static final String SELECT_USER_BY_USERNAME_AND_PASSWORD = "from User user where user.userName = ? and user.password = ?";

	private static final String SELECT_COURSES_BY_INSTRUCTOR = "from Course course where instructor = ?";

	private static final String SELECT_COURSES_BY_STUDENT = "select studentCourse.course from StudentCourse studentCourse where studentCourse.student = ?";

	private static final String SELECT_ASSIGNMENTS_BY_COURSE = "from Assignment assignment where assignment.course = ?";

	private static final String SELECT_STUDENTS_BY_COURSE = "select studentCourse.student from StudentCourse studentCourse where studentCourse.course = ?";

	private static final String SELECT_STUDENTS_NOT_COURSE = "select studentCourse.student from StudentCourse studentCourse where studentCourse.course != ?";

	private static final String SELECT_ORACLE = "from Oracle oracle where oracle.idCode = ?";

	private static final String SELECT_ORACLES = "from Oracle";

	private static final String SELECT_ORACLES_BY_LANGUAGE = "from Oracle oracle where oracle.language = ?";

	private static final String SELECT_EVALUATION = "from Evaluation evaluation where evaluation.student = ? and evaluation.assignment.course = ? and evaluation.assignment = ? order by evaluation.assignment.endDate";

	private static final String SELECT_EVALUATIONS_BY_STUDENT = "from Evaluation evaluation where evaluation.student = ? order by evaluation.assignment.endDate";

	private static final String SELECT_EVALUATIONS_BY_ASSIGNMENT = "from Evaluation evaluation where evaluation.assignment.course = ? and evaluation.assignment.idCode = ? order by evaluation.assignment.endDate";

	private static final String SELECT_EVALUATIONS_BY_STUDENT_AND_COURSE = "from Evaluation evaluation where evaluation.student = ? and evaluation.assignment.course = ? order by evaluation.assignment.endDate";

	private static final String SELECT_EVALUATIONS_BY_STUDENT_AND_COURSE_AND_SUBMISSIONDATE = "from Evaluation evaluation where evaluation.student = ? and evaluation.assignment.course = ? and evaluation.submissionDate = NULL order by evaluation.assignment.endDate";

	private static final String SELECT_EVALUATIONS_BY_STUDENT_AND_SUBMISSIONDATE = "from Evaluation evaluation where evaluation.student = ? and evaluation.submissionDate = NULL order by evaluation.assignment.endDate";

	private static final String SELECT_MAX_IDCODE_ASSIGNMENT = "select max(assignment.idCode) from Assignment assignment";

	private static final String SELECT_CRITERIA_BY_LANGUAGE = "select tool.criteria from Tool tool where tool.language = ?";

	private static final String SELECT_CRITERION_BY_TOOL_AND_ID = "from Criterion criterion where criterion.tool = ? and criterion.idCode = ?";

	private static final String SELECT_TOOLS = "from Tool";

	public static boolean checkUserName(String userName) {
		boolean result;
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(SELECT_USER_BY_USERNAME);
		query.setString(0, userName);
		if (query.list().size() == 0)
			result = false;
		else
			result = true;
		session.getTransaction().commit();
		session.close();
		return result;
	}

	public static boolean checkPassword(String userName, String password) {
		boolean result;
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(SELECT_USER_BY_USERNAME_AND_PASSWORD);
		query.setString(0, userName);
		query.setString(1, password);
		if (query.list().size() == 0)
			result = false;
		else
			result = true;
		session.getTransaction().commit();
		session.close();
		return result;
	}

	public static boolean checkEmail(String email, String userName) {
		boolean result;
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session
				.createQuery(SELECT_USER_BY_EMAIL_AND_NOT_USERNAME);
		query.setString(0, email);
		query.setString(1, userName);
		if (query.list().size() == 0)
			result = false;
		else
			result = true;
		session.getTransaction().commit();
		session.close();
		return result;
	}

	public static User getUser(String userName) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(SELECT_USER_BY_USERNAME);
		query.setString(0, userName);
		User user = (User) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return user;
	}

	public static User getStudent(String email) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(SELECT_USER_BY_EMAIL);
		query.setString(0, email);
		User user = (User) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return user;
	}

	@SuppressWarnings("unchecked")
	public static List<Course> getCoursesAsInstructor(User user) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(SELECT_COURSES_BY_INSTRUCTOR);
		query.setInteger(0, user.getIdCode());
		List<Course> courses = (List<Course>) query.list();
		session.getTransaction().commit();
		session.close();
		return courses;
	}

	@SuppressWarnings("unchecked")
	public static List<Course> getCoursesAsStudent(User user) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(SELECT_COURSES_BY_STUDENT);
		query.setInteger(0, user.getIdCode());
		List<Course> courses = (List<Course>) query.list();
		session.getTransaction().commit();
		session.close();
		return courses;
	}

	@SuppressWarnings("unchecked")
	public static List<User> getStudents(Course course) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(SELECT_STUDENTS_BY_COURSE);
		query.setInteger(0, course.getIdCode());
		List<User> users = (List<User>) query.list();
		session.getTransaction().commit();
		session.close();
		return users;
	}

	@SuppressWarnings("unchecked")
	public static List<User> getStudentsNotCourse(Course course) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(SELECT_STUDENTS_NOT_COURSE);
		query.setInteger(0, course.getIdCode());
		List<User> users = (List<User>) query.list();
		session.getTransaction().commit();
		session.close();
		return users;
	}

	@SuppressWarnings("unchecked")
	public static List<Evaluation> getEvaluations(User user) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(SELECT_EVALUATIONS_BY_STUDENT);
		query.setInteger(0, user.getIdCode());
		List<Evaluation> evaluations = (List<Evaluation>) query.list();
		session.getTransaction().commit();
		session.close();
		return evaluations;
	}

	@SuppressWarnings("unchecked")
	public static List<Assignment> getAssignments(Course course) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(SELECT_ASSIGNMENTS_BY_COURSE);
		query.setInteger(0, course.getIdCode());
		List<Assignment> assignments = (List<Assignment>) query.list();
		session.getTransaction().commit();
		session.close();
		return assignments;
	}

	@SuppressWarnings("unchecked")
	public static List<Evaluation> getEvaluations(Assignment assignment) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(SELECT_EVALUATIONS_BY_ASSIGNMENT);
		query.setInteger(0, assignment.getCourse().getIdCode());
		query.setInteger(1, assignment.getIdCode());
		List<Evaluation> evaluations = (List<Evaluation>) query.list();
		session.getTransaction().commit();
		session.close();
		return evaluations;
	}

	public static Oracle getOracle(int idCode) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(SELECT_ORACLE);
		query.setInteger(0, idCode);
		Oracle oracle = (Oracle) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return oracle;
	}

	@SuppressWarnings("unchecked")
	public static List<Oracle> getOracles() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(SELECT_ORACLES);
		List<Oracle> oracles = (List<Oracle>) query.list();
		session.getTransaction().commit();
		session.close();
		return oracles;
	}

	public static Evaluation getEvaluation(User user, Assignment assignment) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(SELECT_EVALUATION);
		query.setInteger(0, user.getIdCode());
		query.setInteger(1, assignment.getCourse().getIdCode());
		query.setInteger(2, assignment.getIdCode());
		Evaluation evaluation = (Evaluation) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return evaluation;
	}

	@SuppressWarnings("unchecked")
	public static List<Evaluation> getEvaluations(User user, Course course) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session
				.createQuery(SELECT_EVALUATIONS_BY_STUDENT_AND_COURSE);
		query.setInteger(0, user.getIdCode());
		query.setInteger(1, course.getIdCode());
		List<Evaluation> evaluations = (List<Evaluation>) query.list();
		session.getTransaction().commit();
		session.close();
		return evaluations;
	}

	@SuppressWarnings("unchecked")
	public static List<Evaluation> getOutstandingEvaluations(User user,
			Course course) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session
				.createQuery(SELECT_EVALUATIONS_BY_STUDENT_AND_COURSE_AND_SUBMISSIONDATE);
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
		Query query = session
				.createQuery(SELECT_EVALUATIONS_BY_STUDENT_AND_SUBMISSIONDATE);
		query.setInteger(0, user.getIdCode());
		List<Evaluation> avaliations = (List<Evaluation>) query.list();
		session.getTransaction().commit();
		session.close();
		return avaliations;
	}

	public static Integer getNewId() {
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			Query query = session.createQuery(SELECT_MAX_IDCODE_ASSIGNMENT);
			Integer idCode = (Integer) query.uniqueResult();
			session.getTransaction().commit();
			session.close();
			if (idCode == 0 || idCode == null)
				return 1;
			else
				return idCode + 1;
		} catch (Throwable e) {
			return 1;
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Criterion> getCriteria(String language) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(SELECT_CRITERIA_BY_LANGUAGE);
		query.setString(0, language);
		List<Criterion> criteria = (List<Criterion>) query.list();
		session.getTransaction().commit();
		session.close();
		return criteria;
	}

	public static Criterion getCriterion(int i, int j) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(SELECT_CRITERION_BY_TOOL_AND_ID);
		query.setInteger(0, i);
		query.setInteger(1, j);
		Criterion criterion = (Criterion) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return criterion;
	}

	@SuppressWarnings("unchecked")
	public static List<Oracle> getOracles(String language) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(SELECT_ORACLES_BY_LANGUAGE);
		query.setString(0, language);
		List<Oracle> oracles = (List<Oracle>) query.list();
		session.getTransaction().commit();
		session.close();
		return oracles;
	}

	@SuppressWarnings("unchecked")
	public static List<Tool> getTools() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(SELECT_TOOLS);
		List<Tool> tools = (List<Tool>) query.list();
		session.getTransaction().commit();
		session.close();
		return tools;
	}

}
