/*
 * @author Mike Mankowski
 * @dueDate 2/26/20
 * @courseSection 04
 * @title Ghost Hunters
 * This is a turn-based ghost hunting game with two different levels of ghosts
 * 		Meant to demonstrate classes, inheritance, and overloaded constructors 
 */

package ghostgame;

import java.util.Scanner;

public class MariosManor {

	public static void main(String[] args) {

		String input; // holds user String input
		String playerName; // holds name of player
		int difficulty; // holds difficulty level selected by player

		Scanner keyboard = new Scanner(System.in);

		// TEST STUFF
		Ghost testGhost = new Ghost();
		//testGhost.testDisplay();
		RegularGhost test2 = new RegularGhost();
		System.out.println(test2.name);

		System.out.println("Enter Ghost name:");
		input = keyboard.nextLine();

		test2.setName(input);
		System.out.println(test2.getName());
		

		// END TEST STUFF

		// Game Begins
		System.out.println("Welcome...ADD MORE GAME LORE LATER\n" + "What is your name?");
		playerName = keyboard.nextLine();
		System.out.println("Nice to meet you " + playerName + "\nWhat level ghost hunter are you?\n"
				+ "'1' for Beginnner\n" + "'2' for Experienced\n" + "'3' for Expert");
		
		/*gets difficulty from player - not sure this is necessary 
		do {
			System.out.println("Enter your level: ");
			difficulty = keyboard.nextInt();
			if (difficulty == 1) {
				System.out.println("Difficulty is 1");
			} else if (difficulty == 2) {
				System.out.println("Difficulty is 2");
			} else if (difficulty == 3) {
				System.out.println("Difficulty is 3");
			} else {
				System.out.println("Must enter 1, 2, or 3");

			}
		} while (difficulty < 1 || difficulty > 3);
		*/
		
		
	}

}
