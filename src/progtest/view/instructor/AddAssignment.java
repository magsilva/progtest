package progtest.view.instructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;

import progtest.common.Assignment;
import progtest.common.AssignmentCriterion;
import progtest.common.Course;
import progtest.common.Criterion;
import progtest.common.Language;
import progtest.common.Oracle;
import progtest.database.AssignmentCriterionDAO;
import progtest.database.AssignmentDAO;
import progtest.database.Querier;
import progtest.exceptions.NotFoundApplicationException;
import progtest.exceptions.NotFoundTestCasesException;
import progtest.execution.Run;
import progtest.util.Constants;
import progtest.util.ContextManager;

public class AddAssignment {

	private int step = 1;

	private List<Language> languages = Querier.getLanguages();

	private Integer language = null;

	private List<Compiler> compilers = new ArrayList<Compiler>();

	private Integer compiler = null;

	private List<Oracle> oracles = new ArrayList<Oracle>();

	private Integer oracle = null;

	private String title = Constants.EMPTY;

	private String description = Constants.EMPTY;

	private Date startDate = new Date();

	private Date endDate = new Date();

	private List<Criterion> criteria = new ArrayList<Criterion>();

	private List<String> selectedCriteria = new ArrayList<String>();

	private List<AssignmentCriterion> assignmentCriteria = new ArrayList<AssignmentCriterion>();

	private UIData assignmentCriteriaTable;

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public Integer getLanguage() {
		return language;
	}

	public void setLanguage(Integer language) {
		this.language = language;
	}

	public List<Compiler> getCompilers() {
		return compilers;
	}

	public void setCompilers(List<Compiler> compilers) {
		this.compilers = compilers;
	}

	public Integer getCompiler() {
		return compiler;
	}

	public void setCompiler(Integer compiler) {
		this.compiler = compiler;
	}

	public List<Oracle> getOracles() {
		return oracles;
	}

	public void setOracles(List<Oracle> oracles) {
		this.oracles = oracles;
	}

	public Integer getOracle() {
		return oracle;
	}

	public void setOracle(Integer oracle) {
		this.oracle = oracle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Criterion> getCriteria() {
		return criteria;
	}

	public void setCriteria(List<Criterion> criteria) {
		this.criteria = criteria;
	}

	public List<String> getSelectedCriteria() {
		return selectedCriteria;
	}

	public void setSelectedCriteria(List<String> selectedCriteria) {
		this.selectedCriteria = selectedCriteria;
	}

	public List<AssignmentCriterion> getAssignmentCriteria() {
		return assignmentCriteria;
	}

	public void setAssignmentCriteria(
			List<AssignmentCriterion> assignmentCriteria) {
		this.assignmentCriteria = assignmentCriteria;
	}

	public UIData getAssignmentCriteriaTable() {
		return assignmentCriteriaTable;
	}

	public void setAssignmentCriteriaTable(UIData assignmentCriteriaTable) {
		this.assignmentCriteriaTable = assignmentCriteriaTable;
	}

	public String goToStep2() {

		compilers = Querier.getCompilers(language);
		step = 2;

		return Constants.ACTION_SELECT;

	}

	public String goToStep3() {

		oracles = Querier.getOracles(language);
		step = 3;

		return Constants.ACTION_SELECT;

	}

	public String goToStep4() {

		Oracle oracle = Querier.getOracle(this.oracle);

		title = oracle.getTitle();
		description = oracle.getDescription();

		ContextManager.setSession(Constants.SESSION_ORACLE, oracle);

		step = 4;

		return Constants.ACTION_SELECT;

	}

	public String goToStep5() {

		if (validate()) {

			Course course = (Course) ContextManager
					.getSession(Constants.SESSION_COURSE);

			Assignment assignment = new Assignment();
			assignment.setCourse(course);
			assignment.setTitle(title);
			assignment.setDescription(description);
			assignment.setStartDate(startDate);
			assignment.setEndDate(endDate);

			ContextManager.setSession(Constants.SESSION_ASSIGNMENT, assignment);

			criteria = Querier.getCriteria(language);
			step = 5;

		}

		return Constants.ACTION_SELECT;

	}

	public String goToStep6() {

		assignmentCriteria.clear();

		if (hasCriteria()) {

			Assignment assignment = (Assignment) ContextManager
					.getSession(Constants.SESSION_ASSIGNMENT);

			for (String selectedCriterion : selectedCriteria) {
				String ids[] = selectedCriterion.split("/");
				Criterion criterion = Querier.getCriterion(
						Integer.parseInt(ids[0]), Integer.parseInt(ids[1]));
				AssignmentCriterion assignmentCriterion = new AssignmentCriterion();
				assignmentCriterion.setAssignment(assignment);
				assignmentCriterion.setCriterion(criterion);
				assignmentCriteria.add(assignmentCriterion);
			}

			step = 6;

		}

		return Constants.ACTION_SELECT;

	}

	public String conclude() {

		Assignment assignment = (Assignment) ContextManager
				.getSession(Constants.SESSION_ASSIGNMENT);

		Oracle oracle = (Oracle) ContextManager
				.getSession(Constants.SESSION_ORACLE);

		try {

			Run.run(assignment, oracle);

			AssignmentDAO.insert(assignment);

			for (AssignmentCriterion assignmentCriterion : assignmentCriteria)
				AssignmentCriterionDAO.insert(assignmentCriterion);

			refresh();

			return Constants.ACTION_SUCCESS;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFoundTestCasesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFoundApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Constants.ACTION_FAILURE;

	}

	public String backToStep1() {
		step = 1;
		return Constants.ACTION_SELECT;
	}

	public String backToStep2() {
		step = 2;
		return Constants.ACTION_SELECT;
	}

	public String backToStep3() {
		step = 3;
		return Constants.ACTION_SELECT;
	}

	public String backToStep4() {
		step = 4;
		return Constants.ACTION_SELECT;
	}

	public String backToStep5() {
		step = 5;
		return Constants.ACTION_SELECT;
	}

	private void refresh() {
		step = 1;
		languages = Querier.getLanguages();
		language = null;
		compilers = new ArrayList<Compiler>();
		compiler = null;
		oracles = new ArrayList<Oracle>();
		oracle = null;
		title = Constants.EMPTY;
		description = Constants.EMPTY;
		startDate = new Date();
		endDate = new Date();
		criteria = new ArrayList<Criterion>();
		selectedCriteria = new ArrayList<String>();
		assignmentCriteria = new ArrayList<AssignmentCriterion>();
	}

	public String cancel() {
		refresh();
		return Constants.ACTION_CANCEL;
	}

	private boolean validate() {

		if (title.equals(Constants.EMPTY)
				|| description.equals(Constants.EMPTY)) {

			ContextManager.addMessage(Constants.KEY_ERROR_EMPTYBLANKS,
					FacesMessage.SEVERITY_ERROR);

		} else if (startDate.getTime() > endDate.getTime()) {

			ContextManager.addMessage(Constants.KEY_ERROR_DATEINCONSISTENT,
					FacesMessage.SEVERITY_ERROR);

		} else {

			return true;

		}

		return false;

	}

	private boolean hasCriteria() {
		if (selectedCriteria.isEmpty()) {

			ContextManager.addMessage(Constants.KEY_ERROR_ANYCRITERIONSELECTED,
					FacesMessage.SEVERITY_ERROR);

			return false;

		} else

			return true;

	}

}
