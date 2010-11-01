package progtest.execution;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

import org.apache.myfaces.custom.fileupload.UploadedFile;

public class Uploader {

	public static File upload(UploadedFile uf, File dst) throws IOException,
			IllegalArgumentException {
		
		if (uf == null)
			throw new IllegalArgumentException("No file to write from");

		InputStream is = null;
		FileOutputStream fos = null;

		try {

			if (!dst.exists())
				dst.mkdirs();

			String token = null;
			StringTokenizer st = new StringTokenizer(uf.getName(),
					File.separator);
			while (st.hasMoreTokens()) {
				token = st.nextToken(File.separator);
			}

			File savedFile = null;
			if (!token.equals(uf.getName())) {
				savedFile = new File(dst + File.separator + token);
			} else {
				savedFile = new File(dst + File.separator + uf.getName());
			}

			is = uf.getInputStream();
			fos = new FileOutputStream(savedFile);
			int c;
			while ((c = is.read()) != -1) {
				fos.write(c);
			}

			return savedFile;

		} finally {
			if (is != null)
				is.close();
			if (fos != null)
				fos.close();
		}

	}

}
