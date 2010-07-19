package progtest.view.instructor;

import java.util.Date;

import javax.faces.application.FacesMessage;

import progtest.common.Assignment;
import progtest.database.AssignmentDAO;
import progtest.util.Constants;
import progtest.util.ContextManager;

public class EditAssignment {
	
	private boolean advancedOptions = false;

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

	public boolean isAdvancedOptions() {
		return advancedOptions;
	}

	public void setAdvancedOptions(boolean advancedOptions) {
		this.advancedOptions = advancedOptions;
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

	public EditAssignment() {
		Assignment assignment = (Assignment) ContextManager
				.getSession(Constants.SESSION_ASSIGNMENT);
		advancedOptions = false;
		title = assignment.getTitle();
		description = assignment.getDescription();
		startDate = assignment.getStartDate();
		endDate = assignment.getEndDate();
		weightFunctional = String.valueOf(assignment.getWeightFunctional());
		weightAllNodes = String.valueOf(assignment.getWeightAllNodes());
		weightAllEdges = String.valueOf(assignment.getWeightAllEdges());
		weightAllUses = String.valueOf(assignment.getWeightAllUses());
		weightAllPotUses = String.valueOf(assignment.getWeightAllPotUses());
		weightPalTal = String.valueOf(assignment.getWeightPalTal());
		weightPinstTal = String.valueOf(assignment.getWeightPinstTal());
		weightPalTinst = String.valueOf(assignment.getWeightPalTinst());
	}

	public String edit() {

		if (validate()) {

			Assignment assignment = (Assignment) ContextManager
					.getSession(Constants.SESSION_ASSIGNMENT);
			
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
			
			AssignmentDAO.update(assignment);
			
			ContextManager.setSession(Constants.SESSION_ASSIGNMENT, assignment);

			return Constants.ACTION_SUCCESS;

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

	public String cancel() {
		return Constants.ACTION_CANCEL;
	}

}
