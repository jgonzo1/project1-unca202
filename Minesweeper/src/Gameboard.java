
public class Gameboard {

	Cell [][] board;
	
	
	public void run() {
		
		for (int i = 0; i < 8; i++ ) {
			
			System.out.println("");
			
			for (int j = 0; j < 8; j++ ) {
				
				board = new Cell[i][j];
				System.out.print(board[i][j] + " ");
				
			}
			
		}
		
	}
	
}
