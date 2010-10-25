package progtest.view.student;

import java.io.IOException;
import java.util.Date;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import progtest.common.Evaluation;
import progtest.database.EvaluationDAO;
import progtest.execution.Runner;
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
			
			Runner.run(evaluation, file);
			
			evaluation.setSubmissionDate(new Date());
			
			EvaluationDAO.update(evaluation);
			
			return Constants.ACTION_SUCCESS;
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		return Constants.ACTION_FAILURE;

	}

	public String cancel() {
		String backPage = (String) ContextManager.getSession(Constants.SESSION_BACKPAGE);
		return backPage;
	}

}
