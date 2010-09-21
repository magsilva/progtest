package progtest.view.instructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;
import javax.faces.model.SelectItem;

import progtest.common.Assignment;
import progtest.common.AssignmentCriterion;
import progtest.common.Course;
import progtest.common.Criterion;
import progtest.common.Oracle;
import progtest.database.Querier;
import progtest.util.Constants;
import progtest.util.ContextManager;

public class AddAssignment {

	private int step = 1;

	private SelectItem[] languages = loadLanguages();

	private String language = null;

	private SelectItem[] oracles = new SelectItem[0];

	private String oracle = null;

	private String title = Constants.EMPTY;

	private String description = Constants.EMPTY;

	private Date startDate = new Date();

	private Date endDate = new Date();

	private SelectItem[] criteria = new SelectItem[0];

	private List<String> selectedCriteria = new ArrayList<String>();

	private List<AssignmentCriterion> assignmentCriteria = new ArrayList<AssignmentCriterion>();

	private UIData assignmentCriteriaTable;

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public SelectItem[] getLanguages() {
		return languages;
	}

	public void setLanguages(SelectItem[] languages) {
		this.languages = languages;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public SelectItem[] getOracles() {
		return oracles;
	}

	public void setOracles(SelectItem[] oracles) {
		this.oracles = oracles;
	}

	public String getOracle() {
		return oracle;
	}

	public void setOracle(String oracle) {
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

	public SelectItem[] getCriteria() {
		return criteria;
	}

	public void setCriteria(SelectItem[] criteria) {
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

	public void setAssignmentCriteriaTable(UIData assignmentCriteriaTable) {
		this.assignmentCriteriaTable = assignmentCriteriaTable;
	}

	public UIData getAssignmentCriteriaTable() {
		return assignmentCriteriaTable;
	}

	public String goToStep2() {

		oracles = loadOracles();
		step = 2;

		return Constants.ACTION_SELECT;

	}

	public String goToStep3() {

		Oracle oracle = Querier.getOracle(Integer.parseInt(this.oracle
				.substring(0, this.oracle.indexOf(" "))));

		title = oracle.getTitle();
		description = oracle.getDescription();

		ContextManager.setSession(Constants.SESSION_ORACLE, oracle);

		step = 3;

		return Constants.ACTION_SELECT;

	}

	public String goToStep4() {

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

			criteria = loadCriteria();
			step = 4;

		}

		return Constants.ACTION_SELECT;

	}

	public String goToStep5() {

		if (hasCriteria()) {

			Assignment assignment = (Assignment) ContextManager
					.getSession(Constants.SESSION_ASSIGNMENT);
			
			assignmentCriteria.clear();

			for (String selectedCriterion : selectedCriteria) {
				String[] str = selectedCriterion.split("/");
				Criterion criterion = Querier.getCriterion(str[0], str[1]);
				AssignmentCriterion assignmentCriterion = new AssignmentCriterion();
				assignmentCriterion.setAssignment(assignment);
				assignmentCriterion.setCriterion(criterion);
				assignmentCriteria.add(assignmentCriterion);
			}

			step = 5;

		}

		return Constants.ACTION_SELECT;

	}

	public String conclude() {

		/*
		 * if (validate()) {
		 * 
		 * Assignment assignment = (Assignment) ContextManager
		 * .getSession(Constants.SESSION_ASSIGNMENT);
		 * 
		 * for (AssignmentCriterion assignmentCriterion : assignmentCriteria)
		 * AssignmentCriterionDAO.insert(assignmentCriterion);
		 * 
		 * Oracle oracle = (Oracle) ContextManager
		 * .getSession(Constants.SESSION_ORACLE);
		 * 
		 * try {
		 * 
		 * Runner.executePinstTinst(oracle, assignment);
		 * 
		 * AssignmentDAO.insert(assignment);
		 * 
		 * refresh();
		 * 
		 * return Constants.ACTION_SUCCESS;
		 * 
		 * } catch (DecompressException e) {
		 * 
		 * ContextManager.addMessage(Constants.KEY_ERROR_DECOMPRESSING,
		 * FacesMessage.SEVERITY_ERROR);
		 * 
		 * } catch (TestingException e) {
		 * 
		 * ContextManager.addMessage(Constants.KEY_ERROR_TESTING,
		 * FacesMessage.SEVERITY_ERROR);
		 * 
		 * } catch (CompileException e) {
		 * 
		 * ContextManager.addMessage(Constants.KEY_ERROR_COMPILING,
		 * FacesMessage.SEVERITY_ERROR);
		 * 
		 * } catch (CompressException e) {
		 * 
		 * ContextManager.addMessage(Constants.KEY_ERROR_COMPRESSING,
		 * FacesMessage.SEVERITY_ERROR);
		 * 
		 * } catch (FileException e) {
		 * 
		 * ContextManager.addMessage(Constants.KEY_ERROR_RUNNING,
		 * FacesMessage.SEVERITY_ERROR);
		 * 
		 * } catch (NotFoundTestCasesException e) {
		 * 
		 * ContextManager.addMessage( Constants.KEY_ERROR_NOTFOUNDTESTCASES,
		 * FacesMessage.SEVERITY_ERROR);
		 * 
		 * } catch (NotFoundApplicationException e) {
		 * 
		 * ContextManager.addMessage( Constants.KEY_ERROR_NOTFOUNDAPPLICATION,
		 * FacesMessage.SEVERITY_ERROR);
		 * 
		 * }
		 * 
		 * }
		 */

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

	private void refresh() {
		step = 1;
		languages = loadLanguages();
		language = null;
		oracles = new SelectItem[0];
		oracle = null;
		title = Constants.EMPTY;
		description = Constants.EMPTY;
		startDate = new Date();
		endDate = new Date();
		criteria = new SelectItem[0];
		selectedCriteria = new ArrayList<String>();
		assignmentCriteria = new ArrayList<AssignmentCriterion>();
	}

	public String cancel() {
		refresh();
		return Constants.ACTION_CANCEL;
	}

	private SelectItem[] loadLanguages() {

		List<Oracle> oracles = Querier.getOracles();

		List<String> languages = new ArrayList<String>();

		for (Oracle oracle : oracles)
			if (!languages.contains(oracle.getLanguage()))
				languages.add(oracle.getLanguage());

		SelectItem[] itens = new SelectItem[languages.size()];

		for (int i = 0; i < languages.size(); i++)
			itens[i] = new SelectItem(languages.get(i));

		return itens;

	}

	private SelectItem[] loadOracles() {

		List<Oracle> oracles = Querier.getOracles(language);
		SelectItem[] itens = new SelectItem[oracles.size()];

		for (int i = 0; i < oracles.size(); i++)
			itens[i] = new SelectItem(oracles.get(i).getIdCode() + " - "
					+ oracles.get(i).getTitle());

		return itens;

	}

	private SelectItem[] loadCriteria() {

		List<Criterion> criteria = Querier.getCriteria(language);
		SelectItem[] itens = new SelectItem[criteria.size()];

		for (int i = 0; i < criteria.size(); i++)
			itens[i] = new SelectItem(criteria.get(i).getTool() + "/"
					+ criteria.get(i).getName());

		return itens;

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
