package progtest.view.instructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import progtest.common.Assignment;
import progtest.common.Course;
import progtest.common.Criterion;
import progtest.common.Requisite;
import progtest.common.Tool;
import progtest.database.AssignmentDAO;
import progtest.database.Querier;
import progtest.execution.Runner;
import progtest.execution.exceptions.EvaluationException;
import progtest.execution.exceptions.ExecutionException;
import progtest.execution.exceptions.ExtractionException;
import progtest.execution.exceptions.ReportException;
import progtest.execution.exceptions.RunDirectoriesException;
import progtest.execution.exceptions.SplitException;
import progtest.execution.exceptions.UploadException;
import progtest.util.Constants;
import progtest.util.FacesUtil;

public class CreateAssignment {

	private int step = 1;

	private List<String> languages = loadLanguages();

	private String language = null;

	private UploadedFile uploadedFile = null;

	private String title = Constants.EMPTY;

	private String description = Constants.EMPTY;

	private Date startDate = new Date();

	private Date endDate = new Date();

	private List<Criterion> criteria = new ArrayList<Criterion>();

	private List<String> selectedCriteria = new ArrayList<String>();

	private List<Requisite> requisites = new ArrayList<Requisite>();

	private UIData requisitesTable;

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLanguage() {
		return language;
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
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

	public List<Requisite> getRequisites() {
		return requisites;
	}

	public void setRequisites(List<Requisite> requisites) {
		this.requisites = requisites;
	}

	public UIData getRequisitesTable() {
		return requisitesTable;
	}

	public void setRequisitesTable(UIData requisitesTable) {
		this.requisitesTable = requisitesTable;
	}

	public String goToStep2() {

		step = 2;

		return Constants.ACTION_SELECT;

	}

	public String goToStep3() {

		step = 3;

		return Constants.ACTION_SELECT;

	}

	public String goToStep4() {

		if (validate()) {

			Course course = (Course) FacesUtil
					.getSession(Constants.SESSION_COURSE);

			Assignment assignment = new Assignment();
			assignment.setCourse(course);
			assignment.setTitle(title);
			assignment.setDescription(description);
			assignment.setStartDate(startDate);
			assignment.setEndDate(endDate);

			FacesUtil.setSession(Constants.SESSION_ASSIGNMENT, assignment);

			criteria = Querier.getCriteria(language);
			step = 4;

		}

		return Constants.ACTION_SELECT;

	}

	public String goToStep5() {

		Assignment assignment = (Assignment) FacesUtil
				.getSession(Constants.SESSION_ASSIGNMENT);

		requisites.clear();

		if (hasCriteria()) {

			for (String selectedCriterion : selectedCriteria) {
				String ids[] = selectedCriterion.split("/");
				Criterion criterion = Querier.getCriterion(
						Integer.parseInt(ids[0]), Integer.parseInt(ids[1]));
				Requisite requisite = new Requisite();
				requisite.setAssignment(assignment);
				requisite.setCriterion(criterion);
				requisites.add(requisite);
			}

			step = 5;

		}

		return Constants.ACTION_SELECT;

	}

	public String conclude() {

		Assignment assignment = (Assignment) FacesUtil
				.getSession(Constants.SESSION_ASSIGNMENT);
		
		assignment.setRequisites(requisites);

		AssignmentDAO.insert(assignment);

		try {
			Runner.run(assignment, uploadedFile);
		} catch (RunDirectoriesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExtractionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SplitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EvaluationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AssignmentDAO.update(assignment);

		refresh();

		return Constants.ACTION_SUCCESS;

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

	public String cancel() {
		refresh();
		return Constants.ACTION_CANCEL;
	}

	private void refresh() {
		step = 1;
		setLanguages(loadLanguages());
		language = null;
		uploadedFile = null;
		title = Constants.EMPTY;
		description = Constants.EMPTY;
		startDate = new Date();
		endDate = new Date();
		criteria = new ArrayList<Criterion>();
		selectedCriteria = new ArrayList<String>();
		requisites = new ArrayList<Requisite>();
	}

	private List<String> loadLanguages() {

		List<String> languages = new ArrayList<String>();

		for (Tool tool : Querier.getTools())
			if (!languages.contains(tool.getLanguage()))
				languages.add(tool.getLanguage());

		return languages;

	}

	private boolean validate() {

		if (title.equals(Constants.EMPTY)
				|| description.equals(Constants.EMPTY)) {

			FacesUtil.addMessage(Constants.KEY_ERROR_EMPTYBLANKS,
					FacesMessage.SEVERITY_ERROR);

		} else if (startDate.getTime() > endDate.getTime()) {

			FacesUtil.addMessage(Constants.KEY_ERROR_DATEINCONSISTENT,
					FacesMessage.SEVERITY_ERROR);

		} else {

			return true;

		}

		return false;

	}

	private boolean hasCriteria() {
		if (selectedCriteria.isEmpty()) {

			FacesUtil.addMessage(Constants.KEY_ERROR_ANYCRITERIONSELECTED,
					FacesMessage.SEVERITY_ERROR);

			return false;

		} else

			return true;

	}

}
