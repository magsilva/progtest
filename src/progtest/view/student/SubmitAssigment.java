package progtest.view.student;

import java.util.Date;

import javax.faces.application.FacesMessage;

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

		if (uploaded()) {

			Submission submission = (Submission) FacesUtil
					.getSession(Constants.SESSION_EVALUATION);

			try {

				Runner.makeDirectories(submission);
				Runner.upload(submission, file);
				Runner.psts(submission);
				Runner.pits(submission);
				Runner.psti(submission);
				Runner.evaluate(submission);
				Runner.report(submission);

			} catch (Throwable t) {

				t.printStackTrace();

			}

			submission.setSubmissionDate(new Date());

			SubmissionDAO.update(submission);

			FacesUtil.removeSession("studentAssignmentInfo");

			return Constants.ACTION_SUCCESS;

		}

		return Constants.ACTION_FAILURE;

	}

	private boolean uploaded() {

		if (file == null) {

			FacesUtil.addMessage(Constants.KEY_ERROR_ANYFILEUPLOADED,
					FacesMessage.SEVERITY_ERROR);

			return false;

		} else

			return true;

	}

	public String cancel() {
		return Constants.ACTION_CANCEL;
	}

}
