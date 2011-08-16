package progtest.reports;

import java.util.ArrayList;
import java.util.List;

public class Object {
	
	public final static int TYPE_TEXT = 0;
	
	public final static int TYPE_TABLE = 1;
	
	public final static int TYPE_FIGURE = 2;
	
	private int type;

	private String textValue = "";
	
	private String textColor = "";
	
	private Row tableHeader = new Row();
	
	private List<Row> tableRows = new ArrayList<Row>();
	
	private String figurePath = "/figures/test.jpg";

	public Object(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public String getTextValue() {
		return textValue;
	}

	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	public Row getTableHeader() {
		return tableHeader;
	}

	public List<Row> getTableRows() {
		return tableRows;
	}

	public String getFigurePath() {
		return figurePath;
	}

	public void setFigurePath(String figurePath) {
		this.figurePath = figurePath;
	}

}
