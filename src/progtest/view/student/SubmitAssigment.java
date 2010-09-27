package progtest.view.student;

import javax.faces.application.FacesMessage;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import progtest.common.Evaluation;
import progtest.database.EvaluationDAO;
import progtest.evaluation.Evaluator;
import progtest.exceptions.CompileException;
import progtest.exceptions.CompressException;
import progtest.exceptions.DecompressException;
import progtest.exceptions.EvaluationException;
import progtest.exceptions.FileException;
import progtest.exceptions.NotFoundApplicationException;
import progtest.exceptions.NotFoundTestCasesException;
import progtest.exceptions.TestingException;
import progtest.exceptions.UploadException;
import progtest.trash.Runner;
import progtest.util.Constants;
import progtest.util.ContextManager;

public class SubmitAssigment {

	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String upload() {

		Evaluation evaluation = (Evaluation) ContextManager
				.getSession(Constants.SESSION_EVALUATION);
		
		try {
			
			Runner.executePalTal(file, evaluation);
			Runner.executePinstTal(evaluation);
			Runner.executePalTinst(evaluation);
			Evaluator.evaluate(evaluation);
			EvaluationDAO.update(evaluation);
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
			
		} catch (EvaluationException e) {
			
			ContextManager.addMessage(Constants.KEY_ERROR_EVALUATING,
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

	public String cancel() {
		String backPage = (String) ContextManager.getSession(Constants.SESSION_BACKPAGE);
		return backPage;
	}

}
