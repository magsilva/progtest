package progtest.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import progtest.util.XMLUtil;

public class XMLReport extends Report {
	
	private Record header = new Record();
	
	private List<Record> records = new ArrayList<Record>();

	public XMLReport(File f) throws Exception {
		
		super(f);
		
		try {

		String data[][] = XMLUtil.parse(f);
		
		for (int j = 0; j < data[0].length; j++) {
			
			switch (j) {
			case 0:
				header.setColumn1(data[0][j]);
				break;
			case 1:
				header.setColumn2(data[0][j]);
				break;
			case 2:
				header.setColumn3(data[0][j]);
				break;
			case 3:
				header.setColumn4(data[0][j]);
				break;
			case 4:
				header.setColumn5(data[0][j]);
				break;
			case 5:
				header.setColumn6(data[0][j]);
				break;
			case 6:
				header.setColumn7(data[0][j]);
				break;
			case 7:
				header.setColumn8(data[0][j]);
				break;
			case 8:
				header.setColumn10(data[0][j]);
				break;
			}
			
		}

		for (int i = 1; i < data.length; i++) {

			Record record = new Record();

			for (int j = 0; j < data[0].length; j++) {

				switch (j) {
				case 0:
					record.setColumn1(data[i][j]);
					break;
				case 1:
					record.setColumn2(data[i][j]);
					break;
				case 2:
					record.setColumn3(data[i][j]);
					break;
				case 3:
					record.setColumn4(data[i][j]);
					break;
				case 4:
					record.setColumn5(data[i][j]);
					break;
				case 5:
					record.setColumn6(data[i][j]);
					break;
				case 6:
					record.setColumn7(data[i][j]);
					break;
				case 7:
					record.setColumn8(data[i][j]);
					break;
				case 8:
					record.setColumn9(data[i][j]);
					break;
				case 9:
					record.setColumn10(data[i][j]);
					break;
				}

			}
			
			records.add(record);

		}
		
		} catch(Throwable e) {
			
			throw new Exception();
			
		}

	}

	public Record getHeader() {
		return header;
	}

	public List<Record> getRecords() {
		return records;
	}

}
