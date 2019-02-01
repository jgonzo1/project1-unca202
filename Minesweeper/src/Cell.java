/**
 * A class storing the properties of a cell.
 *
 * @author  Jeremy Gonzales
 * @version February 1, 2019
 */

public class Cell {

	
	private char cellvalue;
	private char concealedcellvalue;
	private boolean containsmine;
	private boolean border;
	private boolean concealed;
	private boolean played;
	
	/**
	 * Constructs a cell with the default values.
	 */
	public Cell() {
		cellvalue = '-';
		concealedcellvalue = '-';
		concealed = true;
		border = false;
		containsmine = false;
		played = false;
	}
	
	/**
	 * Changes the cell into a border.
	 */
	public void setBorderState() {
		border = true;
		concealedcellvalue = ' ';
		cellvalue = ' ';
	}
	
	/**
	 * Returns true or false if the cell is a border.
	 * @return the border state of a cell.
	 */
	public boolean getBorderState() {
		return border;
	}
	
	/**
	 * Activates a mine in the cell.
	 */
	public void setMineState() {
		cellvalue = 'M';
		containsmine = true;
	}
	
	/**
	 * Returns true or false if the cell contains a mine.
	 * @return the mine state of the cell.
	 */
	public boolean getMineState() {
		return containsmine;
	}
	
	/**
	 * Returns the value of the cell.
	 * @return the value of the cell.
	 */
	public char getCellvalue() {
		return cellvalue;
	}
	
	/**
	 * Changes the cell value to the given value.
	 * @param a the new value of the cell.
	 */
	public void setCellvalue(char a) {
		cellvalue = a;
	}
	
	/**
	 * Reveals the value of the cell.
	 */
	public void revealCellvalue() {
		concealed = false;
	}
	
	/**
	 * Conceals the value of the cell.
	 */
	public void concealCellvalue() {
		concealed = true;
	}
	
	/**
	 * Sets the played state of the cell to true.
	 */
	public void setPlayedState() {
		played = true;
	}
	
	/**
	 * Returns true or false if the cell has been played.
	 * @return the played state of the cell.
	 */
	public boolean getPlayedState() {
		return played;
	}
	
	@Override
	public String toString() {
		if (concealed == false) {
			return String.valueOf(cellvalue);
		}
	
		return String.valueOf(concealedcellvalue);
		
		
	}

}
