package progtest.reports;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TXTReport extends Report {

	private List<String> content = new ArrayList<String>();

	public TXTReport(File file) throws IOException {
		
		super(file);

		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader(file);
			br = new BufferedReader(fr);

			while (br.ready())
				content.add(br.readLine().replace("\t", "  "));

		} finally {

			if (br != null)
				br.close();

			if (fr != null)
				fr.close();

		}

	}

	public List<String> getContent() {
		return content;
	}

	public void setContent(List<String> content) {
		this.content = content;
	}

}
