package progtest.view.instructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import progtest.common.Assignment;
import progtest.common.Course;
import progtest.common.Criterion;
import progtest.common.Operator;
import progtest.common.Oracle;
import progtest.common.Requisite;
import progtest.common.Tool;
import progtest.database.AssignmentDAO;
import progtest.database.Querier;
import progtest.execution.Runner;
import progtest.util.Constants;
import progtest.util.FacesUtil;

public class EditAssignment {

	private int step = 1;

	private List<String> languages;

	private String language;

	private List<Oracle> oracles;
	
	private boolean current;

	private boolean upload;
	
	private String downloadable;

	private Integer oracle;

	private UploadedFile uploadedFile;
	
	private String title;
	
	private String description;
	
	private Date startDate;
	
	private Date endDate;

	private List<Tool> tools;

	private List<String> selectedTools;

	private List<Criterion> criteria;

	private List<String> selectedCriteria;

	private List<Operator> requiredOperators;

	private List<String> selectedRequiredOperators;

	private List<Operator> operators;

	private List<String> selectedOperators;

	private List<Requisite> requisites;
	
	private double pstsWeight;
	
	private double pitsWeight;
	
	private double pstiWeight;
	
	private boolean pstsVisible;
	
	private boolean pitsVisible;
	
	private boolean pstiVisible;
	
	private int timeout;
	
	private double minimumCoverage;

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

	public List<Oracle> getOracles() {
		return oracles;
	}

	public void setOracles(List<Oracle> oracles) {
		this.oracles = oracles;
	}

	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}

	public boolean isUpload() {
		return upload;
	}

	public void setUpload(boolean upload) {
		this.upload = upload;
	}

	public String getDownloadable() {
		return downloadable;
	}

	public void setDownloadable(String downloadable) {
		this.downloadable = downloadable;
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

	public List<Tool> getTools() {
		return tools;
	}

	public void setTools(List<Tool> tools) {
		this.tools = tools;
	}

	public List<String> getSelectedTools() {
		return selectedTools;
	}

	public void setSelectedTools(List<String> selectedTools) {
		this.selectedTools = selectedTools;
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

	public List<Operator> getRequiredOperators() {
		return requiredOperators;
	}

	public void setRequiredOperators(List<Operator> requiredOperators) {
		this.requiredOperators = requiredOperators;
	}

	public List<String> getSelectedRequiredOperators() {
		return selectedRequiredOperators;
	}

	public void setSelectedRequiredOperators(
			List<String> selectedRequiredOperators) {
		this.selectedRequiredOperators = selectedRequiredOperators;
	}

	public List<Operator> getOperators() {
		return operators;
	}

	public void setOperators(List<Operator> operators) {
		this.operators = operators;
	}

	public List<String> getSelectedOperators() {
		return selectedOperators;
	}

	public void setSelectedOperators(List<String> selectedOperators) {
		this.selectedOperators = selectedOperators;
	}

	public List<Requisite> getRequisites() {
		return requisites;
	}

	public void setRequisites(List<Requisite> requisites) {
		this.requisites = requisites;
	}

	public double getPstsWeight() {
		return pstsWeight;
	}

	public void setPstsWeight(double pstsWeight) {
		this.pstsWeight = pstsWeight;
	}

	public double getPitsWeight() {
		return pitsWeight;
	}

	public void setPitsWeight(double pitsWeight) {
		this.pitsWeight = pitsWeight;
	}

	public double getPstiWeight() {
		return pstiWeight;
	}

	public void setPstiWeight(double pstiWeight) {
		this.pstiWeight = pstiWeight;
	}

	public boolean isPstsVisible() {
		return pstsVisible;
	}

	public void setPstsVisible(boolean pstsVisible) {
		this.pstsVisible = pstsVisible;
	}

	public boolean isPitsVisible() {
		return pitsVisible;
	}

	public void setPitsVisible(boolean pitsVisible) {
		this.pitsVisible = pitsVisible;
	}

	public boolean isPstiVisible() {
		return pstiVisible;
	}

	public void setPstiVisible(boolean pstiVisible) {
		this.pstiVisible = pstiVisible;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public double getMinimumCoverage() {
		return minimumCoverage;
	}

	public void setMinimumCoverage(double minimumCoverage) {
		this.minimumCoverage = minimumCoverage;
	}
	
	public EditAssignment() {
		refresh();
	}

	public String goToStep2() {

		oracles = Querier.getOracles(language);
		step = 2;

		return Constants.ACTION_SELECT;

	}

	public String goToStep3() {
		
		Assignment assignment = new Assignment();

		Course course = (Course) FacesUtil
				.getSession(Constants.SESSION_COURSE);
		
		assignment.setCourse(course);

		if (isUpload()) {

			if (uploaded())
				step = 3;

		} else {

			Oracle oracle = Querier.getOracle(this.oracle);
			
			title = oracle.getTitle();
			description = oracle.getDescription();

			FacesUtil.setSession(Constants.SESSION_ORACLE, oracle);

			step = 3;

		}
		
		FacesUtil.setSession(Constants.SESSION_ASSIGNMENT, assignment);

		return Constants.ACTION_SELECT;

	}

	public String goToStep4() {
		
		Assignment assignment = (Assignment) FacesUtil.getSession(Constants.SESSION_ASSIGNMENT);

		if (validate()) {
			
			assignment.setTitle(title);
			assignment.setDescription(description);
			assignment.setStartDate(startDate);
			assignment.setEndDate(endDate);

			criteria = Querier.getCriteria(language);

			step = 4;

		}
		
		FacesUtil.setSession(Constants.SESSION_ASSIGNMENT, assignment);

		return Constants.ACTION_SELECT;

	}

	public String goToStep5() {
		
		Assignment assignment = (Assignment) FacesUtil.getSession(Constants.SESSION_ASSIGNMENT);

		requisites.clear();

		if (hasCriteria()) {

			for (String selectedCriterion : selectedCriteria) {
				String ids[] = selectedCriterion.split("/");
				Criterion criterion = Querier.getCriterion(
						Integer.parseInt(ids[0]), Integer.parseInt(ids[1]));
				Requisite requisite = new Requisite();
				requisite.setAssignment(assignment);
				requisite.setCriterion(criterion);
				requisite.setExecutionParameters(generateExecInfo(criterion));
				requisite.setPstsRequired(true);
				requisite.setPitsRequired(true);
				requisite.setPstiRequired(true);
				requisites.add(requisite);
			}

			step = 5;

		}

		return Constants.ACTION_SELECT;

	}

	public String conclude() {
		
		Assignment assignment = (Assignment) FacesUtil.getSession(Constants.SESSION_ASSIGNMENT);

		assignment.setPstsWeight(pstsWeight);
		assignment.setPitsWeight(pitsWeight);
		assignment.setPstiWeight(pstiWeight);
		assignment.setPstsVisible(pstsVisible);
		assignment.setPitsVisible(pitsVisible);
		assignment.setPstiVisible(pstiVisible);
		assignment.setTimeout(timeout * 1000);
		assignment.setMinimumCoverage((double)(minimumCoverage / 100));
		assignment.setRequisites(requisites);

		AssignmentDAO.insert(assignment);

		try {

			Runner.makeDirectories(assignment);

			if (isUpload()) {

				Runner.upload(assignment, uploadedFile);

			} else {

				Oracle oracle = (Oracle) FacesUtil
						.getSession(Constants.SESSION_ORACLE);

				Runner.useOracle(assignment, oracle);

			}

			Runner.execute(assignment);
			Runner.evaluate(assignment);

		} catch (Throwable t) {

			t.printStackTrace();

		}

		AssignmentDAO.update(assignment);
		
		FacesUtil.setSession(Constants.SESSION_ASSIGNMENT, assignment);

		refresh();
		
		FacesUtil.removeSession("instructorAssignment");

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

	public String back() {
		refresh();
		return Constants.ACTION_BACK;
	}

	private void refresh() {
		
		Assignment assignment = (Assignment) FacesUtil.getSession(Constants.SESSION_ASSIGNMENT);
		
		step = 1;
		current = true;
		upload = false;
		
		try {
			downloadable = Runner.getDownloadable(assignment);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		setLanguages(loadLanguages());
		language = assignment.getTools().get(0).getLanguage();
		uploadedFile = null;
		title = Constants.EMPTY;
		description = Constants.EMPTY;
		startDate = new Date();
		endDate = new Date();
		pstsWeight = 1;
		pitsWeight = 1;
		pstiWeight = 1;
		pstsVisible = true;
		pitsVisible = true;
		pstiVisible = true;
		timeout = 60;
		minimumCoverage = 50;
		criteria = new ArrayList<Criterion>();
		selectedCriteria = new ArrayList<String>();
		requisites = new ArrayList<Requisite>();
		operators = new ArrayList<Operator>();
		requiredOperators = new ArrayList<Operator>();
		selectedOperators = new ArrayList<String>();
		selectedRequiredOperators = new ArrayList<String>();
	}

	public void change(ValueChangeEvent vce) throws IOException {

	}

	public void changeCriteria(ValueChangeEvent event) throws IOException {

		PhaseId phaseId = event.getPhaseId();

		if (phaseId.equals(PhaseId.ANY_PHASE)) {

			event.setPhaseId(PhaseId.UPDATE_MODEL_VALUES);
			event.queue();

		} else {

			requiredOperators.clear();
			operators.clear();

			for (String selectedCriterion : selectedCriteria) {
				String ids[] = selectedCriterion.split("/");
				Criterion criterion = Querier.getCriterion(
						Integer.parseInt(ids[0]), Integer.parseInt(ids[1]));
				for (Operator operator : Querier.getOperators(criterion)) {
					if (operator.isRequired()) {
						requiredOperators.add(operator);
						selectedRequiredOperators.add(operator.getCriterion()
								.getTool().getIdCode()
								+ "/"
								+ operator.getCriterion().getIdCode()
								+ "/" + operator.getIdCode());
					} else {
						operators.add(operator);
					}
				}

			}

		}

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

	private boolean uploaded() {
		if (uploadedFile == null) {

			FacesUtil.addMessage(Constants.KEY_ERROR_ANYFILEUPLOADED,
					FacesMessage.SEVERITY_ERROR);

			return false;

		} else

			return true;

	}

	private String generateExecInfo(Criterion criterion) {

		String execInfo = "";

		for (String selectedOperator : selectedRequiredOperators) {

			int toolId = Integer.parseInt(selectedOperator.split("/")[0]);
			int criterionId = Integer.parseInt(selectedOperator.split("/")[1]);
			int idCode = Integer.parseInt(selectedOperator.split("/")[2]);

			if (toolId == criterion.getTool().getIdCode()
					&& criterionId == criterion.getIdCode()) {

				Operator operator = Querier.getOperator(toolId, criterionId,
						idCode);

				String parameter = operator.getParameter();

				if (parameter != null && !parameter.isEmpty())
					execInfo += " " + parameter;

			}

		}

		for (String selectedOperator : selectedOperators) {

			int toolId = Integer.parseInt(selectedOperator.split("/")[0]);
			int criterionId = Integer.parseInt(selectedOperator.split("/")[1]);
			int idCode = Integer.parseInt(selectedOperator.split("/")[2]);
			
			if (toolId == criterion.getTool().getIdCode()
					&& criterionId == criterion.getIdCode()) {

				Operator operator = Querier.getOperator(toolId, criterionId,
						idCode);

				String parameter = operator.getParameter();

				if (parameter != null && !parameter.isEmpty())
					execInfo += " " + parameter;

			}

		}

		return execInfo;
	}

}
