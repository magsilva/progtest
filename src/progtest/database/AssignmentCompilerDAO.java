package progtest.database;

import org.hibernate.Session;

import progtest.common.AssignmentCompiler;
import progtest.util.HibernateUtil;

public class AssignmentCompilerDAO {

	public static void insert(AssignmentCompiler assignmentCompiler) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(assignmentCompiler);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void update(AssignmentCompiler assignmentCompiler) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(assignmentCompiler);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void delete(AssignmentCompiler assignmentCompiler) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(assignmentCompiler);
		session.getTransaction().commit();
		session.close();
	}

}
