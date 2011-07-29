package progtest.report;

public class Object {
	
	public final static int TYPE_TEXT = 0;
	
	public final static int TYPE_TABLE = 1;
	
	public final static int TYPE_FIGURE = 2;
	
	private int type;

	private String textValue = null;
	
	private String textColor = null;

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

}
