package progtest.report;

public class ReportBean {
	
	private Report report = new Report();
	
	public ReportBean() {
		
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
		
		report.setName("Report 1");
		
		report.getSections().add(section1);
		report.getSections().add(section2);
		
		Object table1 = new Object(Object.TYPE_TABLE);
		table1.getTableHeader().setColumn1("Header 1");
		table1.getTableHeader().setColumn2("Header 2");
		table1.getTableHeader().setColumn3("Header 3");
		table1.getTableHeader().setColumn4("Header 4");
		
		Row row1 = new Row();
		row1.setColumn1("row1 / column1");
		row1.setColumn2("row1 / column2");
		row1.setColumn3("row1 / column3");
		row1.setColumn4("row1 / column4");
		
		Row row2 = new Row();
		row2.setColumn1("row2 / column1");
		row2.setColumn2("row2 / column2");
		row2.setColumn3("row2 / column3");
		row2.setColumn4("row2 / column4");
		
		Row row3 = new Row();
		row3.setColumn1("row3 / column1");
		row3.setColumn2("row3 / column2");
		row3.setColumn3("row3 / column3");
		row3.setColumn4("row3 / column4");
		
		Row row4 = new Row();
		row4.setColumn1("row4 / column1");
		row4.setColumn2("row4 / column2");
		row4.setColumn3("row4 / column3");
		row4.setColumn4("row4 / column4");
		
		table1.getTableRows().add(row1);
		table1.getTableRows().add(row2);
		table1.getTableRows().add(row3);
		table1.getTableRows().add(row4);
		
		Section section3 = new Section();
		section3.setTitle("Section 3");
		section3.getObjects().add(table1);
		
		report.getSections().add(section3);
		
		Object figure1 = new Object(Object.TYPE_FIGURE);
		figure1.setFigurePath("/figures/test.jpg");
		
		Section section4 = new Section();
		section4.setTitle("Section 4");
		section4.getObjects().add(figure1);
		
		report.getSections().add(section4);
		
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

}
