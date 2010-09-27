package progtest.view.instructor;

import java.util.Date;

import javax.faces.application.FacesMessage;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import progtest.common.Assignment;
import progtest.common.Course;
import progtest.database.AssignmentDAO;
import progtest.exceptions.CompileException;
import progtest.exceptions.CompressException;
import progtest.exceptions.DecompressException;
import progtest.exceptions.FileException;
import progtest.exceptions.NotFoundApplicationException;
import progtest.exceptions.NotFoundTestCasesException;
import progtest.exceptions.TestingException;
import progtest.exceptions.UploadException;
import progtest.trash.Runner;
import progtest.util.Constants;
import progtest.util.ContextManager;

public class CreateAssignment {
	
	private int step = 1;
	
	private boolean advancedOptions = false;

	private UploadedFile file;

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

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
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
		file = null;
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

	public String cancel() {
		refresh();
		return Constants.ACTION_CANCEL;
	}

	public String goToStep2() {

		Course course = (Course) ContextManager
				.getSession(Constants.SESSION_COURSE);

		if (validate()) {

			Assignment assigment = new Assignment();
			assigment.setCourse(course);
			assigment.setTitle(title);
			assigment.setDescription(description);
			assigment.setStartDate(startDate);
			assigment.setEndDate(endDate);
			assigment.setWeightFunctional(Integer.parseInt(weightFunctional));
			assigment.setWeightAllNodes(Integer.parseInt(weightAllNodes));
			assigment.setWeightAllEdges(Integer.parseInt(weightAllEdges));
			assigment.setWeightAllUses(Integer.parseInt(weightAllUses));
			assigment.setWeightAllPotUses(Integer.parseInt(weightAllPotUses));
			assigment.setWeightPalTal(Integer.parseInt(weightPalTal));
			assigment.setWeightPinstTal(Integer.parseInt(weightPinstTal));
			assigment.setWeightPalTinst(Integer.parseInt(weightPalTinst));

			ContextManager.setSession(Constants.SESSION_ASSIGNMENT, assigment);
			
			step = 2;

		}

		return Constants.ACTION_SELECT;

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

	public String backToStep1() {
		step = 1;
		return Constants.ACTION_SELECT;
	}

	public String conclude() {

		Assignment assignment = (Assignment) ContextManager
				.getSession(Constants.SESSION_ASSIGNMENT);

		try {
			
			Runner.executePinstTinst(file, assignment);

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
			
		} catch (UploadException e) {
			
			ContextManager.addMessage(Constants.KEY_ERROR_UPLOADING,
					FacesMessage.SEVERITY_ERROR);
			
		} catch (NotFoundTestCasesException e) {
			
			ContextManager.addMessage(Constants.KEY_ERROR_NOTFOUNDTESTCASES,
					FacesMessage.SEVERITY_ERROR);
		
		} catch (NotFoundApplicationException e) {
		
			ContextManager.addMessage(Constants.KEY_ERROR_NOTFOUNDAPPLICATION,
					FacesMessage.SEVERITY_ERROR);
		
		}

		return Constants.ACTION_FAILURE;

	}

}
