package progtest.view.instructor;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.model.SelectItem;

import progtest.common.Assignment;
import progtest.common.Course;
import progtest.common.Oracle;
import progtest.database.AssignmentDAO;
import progtest.database.Querier;
import progtest.exceptions.CompileException;
import progtest.exceptions.CompressException;
import progtest.exceptions.DecompressException;
import progtest.exceptions.FileException;
import progtest.exceptions.NotFoundApplicationException;
import progtest.exceptions.NotFoundTestCasesException;
import progtest.exceptions.TestingException;
import progtest.execution.Runner;
import progtest.util.Constants;
import progtest.util.ContextManager;

public class AddAssignment {

	private int step = 1;

	private boolean advancedOptions = false;

	private SelectItem[] oracles = loadOracles();

	private String oracle = oracles[0].toString();

	private String title = Constants.EMPTY;

	private String description = Constants.EMPTY;

	private Date startDate = new Date();

	private Date endDate = new Date();

	private String weightFunctional = String.valueOf(1);

	private String weightAllNodes = String.valueOf(1);

	private String weightAllEdges = String.valueOf(1);

	private String weightAllUses = String.valueOf(1);

	private String weightAllPotUses = String.valueOf(1);

	private String weightPalTal = String.valueOf(1);

	private String weightPinstTal = String.valueOf(1);

	private String weightPalTinst = String.valueOf(1);

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public boolean isAdvancedOptions() {
		return advancedOptions;
	}

	public void setAdvancedOptions(boolean advancedOptions) {
		this.advancedOptions = advancedOptions;
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

	public String getWeightFunctional() {
		return weightFunctional;
	}

	public void setWeightFunctional(String weightFunctional) {
		this.weightFunctional = weightFunctional;
	}

	public String getWeightAllNodes() {
		return weightAllNodes;
	}

	public void setWeightAllNodes(String weightAllNodes) {
		this.weightAllNodes = weightAllNodes;
	}

	public String getWeightAllEdges() {
		return weightAllEdges;
	}

	public void setWeightAllEdges(String weightAllEdges) {
		this.weightAllEdges = weightAllEdges;
	}

	public String getWeightAllUses() {
		return weightAllUses;
	}

	public void setWeightAllUses(String weightAllUses) {
		this.weightAllUses = weightAllUses;
	}

	public String getWeightAllPotUses() {
		return weightAllPotUses;
	}

	public void setWeightAllPotUses(String weightAllPotUses) {
		this.weightAllPotUses = weightAllPotUses;
	}

	public String getWeightPalTal() {
		return weightPalTal;
	}

	public void setWeightPalTal(String weightPalTal) {
		this.weightPalTal = weightPalTal;
	}

	public String getWeightPinstTal() {
		return weightPinstTal;
	}

	public void setWeightPinstTal(String weightPinstTal) {
		this.weightPinstTal = weightPinstTal;
	}

	public String getWeightPalTinst() {
		return weightPalTinst;
	}

	public void setWeightPalTinst(String weightPalTinst) {
		this.weightPalTinst = weightPalTinst;
	}
	
	public String turnOnAdvancedOptions() {
		advancedOptions = true;
		return Constants.ACTION_SELECT;
	}
	
	public String turnOffAdvancedOptions() {
		advancedOptions = false;
		return Constants.ACTION_SELECT;
	}

	private void refresh() {
		step = 1;
		advancedOptions = false;
		oracles = loadOracles();
		oracle = oracles[0].toString();
		title = Constants.EMPTY;
		description = Constants.EMPTY;
		startDate = new Date();
		endDate = new Date();
		weightFunctional = String.valueOf(1);
		weightAllNodes = String.valueOf(1);
		weightAllEdges = String.valueOf(1);
		weightAllUses = String.valueOf(1);
		weightAllPotUses = String.valueOf(1);
		weightPalTal = String.valueOf(1);
		weightPinstTal = String.valueOf(1);
		weightPalTinst = String.valueOf(1);
	}

	private SelectItem[] loadOracles() {

		List<Oracle> oracles = Querier.getOracles();
		SelectItem[] itens = new SelectItem[oracles.size()];

		for (int i = 0; i < oracles.size(); i++)
			itens[i] = new SelectItem(oracles.get(i).getIdCode() + " - "
					+ oracles.get(i).getTitle());

		return itens;

	}

	public String cancel() {
		refresh();
		return Constants.ACTION_CANCEL;
	}

	public String goToStep2() {

		Oracle oracle = Querier.getOracle(Integer.parseInt(this.oracle
				.substring(0, this.oracle.indexOf(" "))));

		title = oracle.getTitle();
		description = oracle.getDescription();

		ContextManager.setSession(Constants.SESSION_ORACLE, oracle);
		
		step = 2;

		return Constants.ACTION_SELECT;

	}

	public String backToStep1() {
		step = 1;
		return Constants.ACTION_SELECT;
	}

	public String conclude() {

		if (validate()) {

			Course course = (Course) ContextManager
					.getSession(Constants.SESSION_COURSE);

			Assignment assignment = new Assignment();
			assignment.setCourse(course);
			assignment.setTitle(title);
			assignment.setDescription(description);
			assignment.setStartDate(startDate);
			assignment.setEndDate(endDate);
			assignment.setWeightFunctional(Integer.parseInt(weightFunctional));
			assignment.setWeightAllNodes(Integer.parseInt(weightAllNodes));
			assignment.setWeightAllEdges(Integer.parseInt(weightAllEdges));
			assignment.setWeightAllUses(Integer.parseInt(weightAllUses));
			assignment.setWeightAllPotUses(Integer.parseInt(weightAllPotUses));
			assignment.setWeightPalTal(Integer.parseInt(weightPalTal));
			assignment.setWeightPinstTal(Integer.parseInt(weightPinstTal));
			assignment.setWeightPalTinst(Integer.parseInt(weightPalTinst));

			Oracle oracle = (Oracle) ContextManager
					.getSession(Constants.SESSION_ORACLE);

			try {

				Runner.executePinstTinst(oracle, assignment);

				AssignmentDAO.insert(assignment);

				refresh();

				return Constants.ACTION_SUCCESS;

			} catch (DecompressException e) {

				ContextManager.addMessage(Constants.KEY_ERROR_DECOMPRESSING,
						FacesMessage.SEVERITY_ERROR);

			} catch (TestingException e) {

				ContextManager.addMessage(Constants.KEY_ERROR_TESTING,
						FacesMessage.SEVERITY_ERROR);

			} catch (CompileException e) {

				ContextManager.addMessage(Constants.KEY_ERROR_COMPILING,
						FacesMessage.SEVERITY_ERROR);

			} catch (CompressException e) {

				ContextManager.addMessage(Constants.KEY_ERROR_COMPRESSING,
						FacesMessage.SEVERITY_ERROR);

			} catch (FileException e) {

				ContextManager.addMessage(Constants.KEY_ERROR_RUNNING,
						FacesMessage.SEVERITY_ERROR);

			} catch (NotFoundTestCasesException e) {

				ContextManager.addMessage(
						Constants.KEY_ERROR_NOTFOUNDTESTCASES,
						FacesMessage.SEVERITY_ERROR);

			} catch (NotFoundApplicationException e) {

				ContextManager.addMessage(
						Constants.KEY_ERROR_NOTFOUNDAPPLICATION,
						FacesMessage.SEVERITY_ERROR);

			}

		}

		return Constants.ACTION_FAILURE;

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

}
