package progtest.reports;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TXTReport extends Report {

	private String content = "";

	public TXTReport(File file) throws IOException {
		
		super(file);

		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader(file);
			br = new BufferedReader(fr);

			while (br.ready())
				content += br.readLine() + "/n";

		} finally {

			if (br != null)
				br.close();

			if (fr != null)
				fr.close();

		}

	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
