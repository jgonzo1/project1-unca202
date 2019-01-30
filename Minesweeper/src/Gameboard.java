import java.util.Random;

public class Gameboard {

	private Cell [][] board = new Cell[10][10];
	
	private Random generator = new Random();

	
	public void run() {
		
		for (int i = 0; i < 10; i++ ) {
			
			System.out.println("");
			
			for (int j = 0; j < 10; j++ ) {
				
				board[i][j] = new Cell();
				
				if (i == 0 || j == 0 || i == 9 || j == 9) {
					board[i][j].setBorderState();
				}

				System.out.print(board[i][j] + " ");
				
			}
			
		}
		
		System.out.println("");
		
		for (int i = 0; i < 10;) {
			
				int rand1 = generator.nextInt(8) + 1;
				int rand2 = generator.nextInt(8) + 1;
			
			if (board[rand1][rand2].getCellvalue() != 'M') {
				board[rand1][rand2].setMineState();
				i++ ;
				System.out.println("Mine set in position " + rand2 + ", " + rand1 );
			}
			
		}
		

	}
	
	public boolean play(int x,int y) {
		
		int count = 48;
		board[y][x].revealCellvalue();
		
		//North
		if (board[y - 1][x].getMineState() == true) {
			count++;
		}
		
		//East
		if (board[y][x + 1].getMineState() == true) {
			count++;
		}
		
		//West
		if (board[y][x - 1].getMineState() == true) {
			count++;
		}
		
		//South
		if (board[y + 1][x].getMineState() == true) {
			count++;
		}
		
		//North East
		if (board[y - 1][x + 1].getMineState() == true) {
			count++;
		}
		
		//North West
		if (board[y - 1][x - 1].getMineState() == true) {
			count++;
		}
		
		//South East
		if (board[y + 1][x + 1].getMineState() == true) {
			count++;
		}
		
		//South West
		if (board[y + 1][x - 1].getMineState() == true) {
			count++;
		}
		
		
		if (board[y][x].getMineState() == false) {
			board[y][x].setCellvalue((char) count);
		}
		
		
		for (int i = 0; i < 10; i++ ) {
			
			System.out.println("");
			
			for (int j = 0; j < 10; j++ ) {

				System.out.print(board[i][j] + " ");
				
				
			}
			
		}
		
		System.out.println("\n");
		
		return board[y][x].getMineState();
	}
	
	public boolean getPlayedState(int x, int y) {
		return board[y][x].getPlayedState();
	}
	
	public void setPlayedState(int x, int y) {
		board[y][x].setPlayedState();
	}
	
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
