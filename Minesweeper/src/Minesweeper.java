import java.util.Scanner;

/**
 * A class initializing the Game board and managing the user inputs.
 *
 * @author  Jeremy Gonzales
 * @version February 1, 2019
 */

public class Minesweeper {


	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Gameboard game1 = new Gameboard();
		int inputx;
		int inputy;
		String peekinput;
		String input2;
		String input3;
		int win;				//Sets the win condition of the game
		boolean peeked = false;

		game1.run();
		System.out.println("Welcome to Minesweeper");

		for (win = 0; win < 64; win++) {

			if (peeked == false) {

				do {
					System.out.println("Would you like to peek? (yes/no)");
					peekinput = scan.nextLine();

					if (peekinput.equalsIgnoreCase("yes")) {
						game1.peek();
						peeked = true;
					} else if (!peekinput.equalsIgnoreCase("no")) {
						System.out.println("Invalid input");
					}

				} while (!(peekinput.equalsIgnoreCase("yes") || peekinput.equalsIgnoreCase("no")));
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

			//Checks if a cell is already played and resets the loop if true.
			if (game1.getPlayedState(inputx, inputy) == true) {
				System.out.println("You have played this cell before, please enter a new coordinate.");
				win --;
				continue;
			}

			do {
				System.out.println("Does the cell " + inputx + ", " + inputy + " contain a mine? (yes/no)");
				input2 = scan.nextLine();

				//Yes answer scenario
				if (input2.equalsIgnoreCase("yes")) {
					if (game1.getMineState(inputx, inputy) == true) {
						game1.play(inputx, inputy);
						System.out.println("Your guess is correct!");
					} else {
						game1.play(inputx, inputy);
						game1.peek();
						System.out.println("Your guess is incorrect. You lost");
						do {
							System.out.println("Would you like to play another round? (yes/no)");
							input3 = scan.nextLine();
							if (input3.equalsIgnoreCase("yes")) {
								System.out.println("Resetting game...");
								peeked = false;
								win = 0;
								game1.run();
							} else if (input3.equalsIgnoreCase("no")) {
								System.out.println("Thank you for playing the game");
								System.exit(0);
							} else {
								System.out.println("Invalid input");
							}
						} while (!(input3.equalsIgnoreCase("yes") || input3.equalsIgnoreCase("no")));
					} 

				//No answer scenario
				} else if (input2.equalsIgnoreCase("no")) {
					if (game1.getMineState(inputx, inputy) != true) {
						game1.play(inputx, inputy);
						System.out.println("Your guess is correct!");
					} else {
						game1.play(inputx, inputy);
						game1.peek();
						System.out.println("Your guess is incorrect. You lost");
						do {
							System.out.println("Would you like to play another round? (yes/no)");
							input3 = scan.nextLine();
							if (input3.equalsIgnoreCase("yes")) {
								System.out.println("Resetting game...");
								peeked = false;
								win = 0;
								game1.run();
							} else if (input3.equalsIgnoreCase("no")) {
								System.out.println("Thank you for playing the game");
								System.exit(0);
							} else {
								System.out.println("Invalid input");
							}
						} while (!(input3.equalsIgnoreCase("yes") || input3.equalsIgnoreCase("no")));
					}
				} else {
					System.out.println("Invalid input");
				}

			} while (!(input2.equalsIgnoreCase("yes") || input2.equalsIgnoreCase("no")));

		}
		
		game1.peek();
		if (win == 63) {
			System.out.println("Congratulations you won!");
		}

	}
}
