import java.util.Scanner;

public class Minesweeper {
//
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Gameboard game1 = new Gameboard();
		int inputx;
		int inputy;
		String input;
		String input2;
		int i;
		
		
		boolean peeked = false;

		game1.run();
		System.out.println("Welcome to Minesweeper");

		for (i = 0; i < 64; i++) {
			
			if (peeked == false) {
				System.out.println("Would you like to peek? (yes/no)");
				input = scan.nextLine();

				if (input.equals("yes")) {
					game1.peek();
					peeked = true;
				}
			
			}
			
			do {
				System.out.println("Please enter an x-coordinate (1 - 8) to guess: ");
				while (!scan.hasNextInt()) {
					scan.next();
					System.out.println("Please enter a valid number (1 - 8)!");
				}
				inputx = scan.nextInt();
			} while (inputx < 1 || inputx > 8);
			
			
			do {
				System.out.println("Please select a y-coordinate (1 - 8) to guess: ");
				while (!scan.hasNextInt()) {
					scan.next();
					System.out.println("Please enter a valid number (1 - 8)!");
				}
				
				inputy = scan.nextInt();
			} while (inputy < 1 || inputy > 8);
			scan.nextLine();

				System.out.println("Does the cell " + inputx + ", " + inputy + " contain a mine?");
				input2 = scan.nextLine();
	
				if (input2.equalsIgnoreCase("yes")) {
					if (game1.play(inputx, inputy) == true) {
						if (game1.getPlayedState(inputx, inputy) == true) {
							System.out.println("You have played this cell before, please enter a new coordinates.");
							i --;
							continue;
						}
						System.out.println("Your guess is correct!");
						game1.setPlayedState(inputx, inputy);
					} else {
						System.out.println("Your guess is incorrect, you lost.");
						game1.peek();
						System.out.println("Would you like to play another round? (yes/no)");
						String input3 = scan.nextLine(); 
						
						if (!input3.equalsIgnoreCase("yes")) {
							break;
						}
						peeked = false;
						i = 0;
						game1.run();
					}
	
				}
				if (input2.equalsIgnoreCase("no")) {
					if (game1.play(inputx, inputy) == false) {
						if (game1.getPlayedState(inputx, inputy) == true) {
							System.out.println("You have played this cell before, please enter a new coordinates.");
							i --;
							continue;
						}
						System.out.println("Your guess is correct!");
						game1.setPlayedState(inputx, inputy);
					} else {
						System.out.println("Your guess is incorrect, you lost.");
						game1.peek();
						System.out.println("Would you like to play another round? (yes/no)");
						String input3 = scan.nextLine(); 
						
						if (!input3.equalsIgnoreCase("yes")) {
							break;
						}
						peeked = false;
						i = 0;
						game1.run();
					}
	
				}
			
			
			
		}
		
		game1.peek();
		if (i == 63) {
			System.out.println("Congratulations you won!");
		}
		
	}
}
