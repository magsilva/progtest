package progtest.view.student;

import java.util.Date;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import progtest.common.Submission;
import progtest.database.SubmissionDAO;
import progtest.execution.Runner;
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

		Runner.run(submission, file);

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
