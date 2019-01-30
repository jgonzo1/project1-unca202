
public class Cell {

	
	private char cellvalue;
	private char concealedcellvalue;
	private boolean containsmine;
	private boolean border;
	private boolean concealed;
	private boolean played;
	
	public Cell() {
		cellvalue = '-';
		concealedcellvalue = '-';
		concealed = true;
		border = false;
		containsmine = false;
		played = false;
	}
	
	public void setBorderState() {
		border = true;
		concealedcellvalue = ' ';
		cellvalue = ' ';
	}
	
	public boolean getBorderState() {
		return border;
	}
	
	public void setMineState() {
		cellvalue = 'M';
		containsmine = true;
	}
	
	public boolean getMineState() {
		return containsmine;
	}
	
	public char getCellvalue() {
		return cellvalue;
	}
	
	public void setCellvalue(char a) {
		cellvalue = a;
	}
	
	public void revealCellvalue() {
		concealed = false;
	}
	
	public void concealCellvalue() {
		concealed = true;
	}
	
	public void setPlayedState() {
		played = true;
	}
	
	public boolean getPlayedState() {
		return played;
	}
	
	public String toString() {
		if (concealed == false) {
			return String.valueOf(cellvalue);
		}
	
		return String.valueOf(concealedcellvalue);
		
		
	}

}
