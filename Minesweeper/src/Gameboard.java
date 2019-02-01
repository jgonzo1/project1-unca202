import java.util.Random;
/**
 * A class initializing the cells and managing the user inputs.
 *
 * @author  Jeremy Gonzales
 * @version February 1, 2019
 */


public class Gameboard {

	private Cell [][] board = new Cell[10][10];
	private Random generator = new Random();


	/**
	 * Initializes each cells and sets 10 random mines.
	 */
	public void run() {

		for (int i = 0; i < 10; i++ ) {
			System.out.println("");
			for (int j = 0; j < 10; j++ ) {
				board[i][j] = new Cell();
				
				//Sets borders
				if (i == 0 || j == 0 || i == 9 || j == 9) {
					board[i][j].setBorderState();
				}
				System.out.print(board[i][j] + " ");
			}
		}
		System.out.println("");

		//Sets 10 mines randomly
		for (int i = 0; i < 10;) {
			int rand1 = generator.nextInt(8) + 1;
			int rand2 = generator.nextInt(8) + 1;
			if (board[rand1][rand2].getCellvalue() != 'M') {
				board[rand1][rand2].setMineState();
				i++ ;
			}
		}
	}
	
	/**
	 * Calculates the amount of adjacent mines in the cell and saves it in the cell.
	 * @param x 	x-coordinate of the cell
	 * @param y 	y-coordinate of the cell
	 */
	private void adjacentMineCount(int x, int y) {
		int minecount = 48;
		//North
		if (board[y - 1][x].getMineState() == true) {
			minecount++;
		}

		//East
		if (board[y][x + 1].getMineState() == true) {
			minecount++;
		}

		//West
		if (board[y][x - 1].getMineState() == true) {
			minecount++;
		}

		//South
		if (board[y + 1][x].getMineState() == true) {
			minecount++;
		}

		//North East
		if (board[y - 1][x + 1].getMineState() == true) {
			minecount++;
		}

		//North West
		if (board[y - 1][x - 1].getMineState() == true) {
			minecount++;
		}

		//South East
		if (board[y + 1][x + 1].getMineState() == true) {
			minecount++;
		}

		//South West
		if (board[y + 1][x - 1].getMineState() == true) {
			minecount++;
		}


		if (board[y][x].getMineState() == false) {
			board[y][x].setCellvalue((char) minecount);
		}

	} 

	/**
	 * Reveals and the prints the played cell.
	 * @param x 	x-coordinate of the cell
	 * @param y 	y-coordinate of the cell
	 */
	public void play(int x,int y) {

		board[y][x].revealCellvalue();

		adjacentMineCount(x, y);
		setPlayedState(x, y);

		for (int i = 0; i < 10; i++ ) {
			System.out.println("");			
			for (int j = 0; j < 10; j++ ) {
				System.out.print(board[i][j] + " ");		
			}
		}	
		System.out.println("\n");
	}
	
	/**
	 * Returns true or false if the cell is played.
	 * @param x 	x-coordinate of the cell
	 * @param y 	y-coordinate of the cell
	 * @return the played state of the cell.
	 */
	public boolean getPlayedState(int x, int y) {
		return board[y][x].getPlayedState();
	}
	
	/**
	 * Changes the played state of the cell.
	 * @param x 	x-coordinate of the cell
	 * @param y 	y-coordinate of the cell
	 */
	private void setPlayedState(int x, int y) {
		board[y][x].setPlayedState();
	}
	
	/**
	 * Returns true or false if the cell contains a mine.
	 * @param x 	x-coordinate of the cell
	 * @param y 	y-coordinate of the cell
	 * @return the mine state of the cell.
	 */
	public boolean getMineState(int x, int y) {
		return board[y][x].getMineState();
	}
	
	/**
	 * Allows the player to peek and reveal the mines on the board.
	 */
	public void peek() {

		for (int i = 0; i < 10; i++ ) {
			System.out.println("");
			for (int j = 0; j < 10; j++ ) {
				board[i][j].revealCellvalue();
				System.out.print(board[i][j] + " ");
			}
		}
		System.out.println("");
	}

}
