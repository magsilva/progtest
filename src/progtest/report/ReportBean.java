package progtest.report;

public class ReportBean {
	
	private Report report;
	
	public void Report() {
		
		Object text1 = new Object(Object.TYPE_TEXT);
		text1.setTextValue("Testing text report!!!");
		text1.setTextColor("#000000");
		
		Object text2 = new Object(Object.TYPE_TEXT);
		text2.setTextValue("Testing text report!!!");
		text1.setTextColor("#FF0000");
		
		Object text3 = new Object(Object.TYPE_TEXT);
		text3.setTextValue("Testing text report!!!");
		text1.setTextColor("#00FF00");
		
		Section section1 = new Section();
		section1.setTitle("Section 1");
		
		Section section2 = new Section();
		section2.setTitle("Section 2");
		
		section1.getObjects().add(text1);
		
		section2.getObjects().add(text2);
		section2.getObjects().add(text3);
		
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

}
