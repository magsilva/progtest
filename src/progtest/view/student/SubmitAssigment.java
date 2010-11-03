package progtest.view.student;

import java.util.Date;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import progtest.common.Submission;
import progtest.database.SubmissionDAO;
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

public class SubmitAssigment {

	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String upload() {

		Submission submission = (Submission) FacesUtil
				.getSession(Constants.SESSION_EVALUATION);

		try {
			Runner.run(submission, file);
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

		submission.setSubmissionDate(new Date());

		SubmissionDAO.update(submission);

		return Constants.ACTION_SUCCESS;

	}

	public String cancel() {
		String backPage = (String) FacesUtil
				.getSession(Constants.SESSION_BACKPAGE);
		return backPage;
	}

}
