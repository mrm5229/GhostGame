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

public class MariosLair {

	public static void main(String[] args) {

		int input; // holds user String input
		String playerName; // holds name of player
		int difficulty; // holds difficulty level selected by player

		Scanner keyboard = new Scanner(System.in);

		/*
		 * TEST STUFF Ghost testGhost = new Ghost(); //testGhost.testDisplay();
		 * RegularGhost test2 = new RegularGhost(); System.out.println(test2.name);
		 * 
		 * System.out.println("Enter Ghost name:"); input = keyboard.nextLine();
		 * 
		 * test2.setName(input); System.out.println(test2.getName());
		 * 
		 * test2.doesGhostEscape();
		 * 
		 */ // END TEST STUFF

		// Game room setup
		Room bedroom = new Room();
		Room living = new Room();
		Room kitchen = new Room();
		Room basement = new Room();
		
		RegularGhost lampy = new RegularGhost(); // uses default constructor
		RegularGhost couchy = new RegularGhost(15, 20); // uses overloaded constructor 1
		RegularGhost foody = new RegularGhost(15, 10, 10); // uses overloaded constructor 2
		BossGhost bigBaddy = new BossGhost(); // uses default constructor
		
		bedroom.setEnemy(lampy);
		living.setEnemy(couchy);
		kitchen.setEnemy(foody);
		basement.setEnemy(bigBaddy);
		
		bedroom.setDescription("SET DESCRIPTION for bedroom");
		living.setDescription("SET DESCRIPTION");
		kitchen.setDescription("SET DESCRIPTION");
		basement.setDescription("SET DESCRIPTION");
		
		lampy.setName("Lampy");
		couchy.setName("Couchy");
		couchy.setName("Foody");
		bigBaddy.setName("BigBaddy");

		// Game Begins
		System.out.println("Welcome...ADD MORE GAME LORE LATER\n" + "What is your name?");
		playerName = keyboard.nextLine();
		System.out.println("Nice to meet you " + playerName + "\nWhat level ghost hunter are you?\n"
				+ "'1' for Beginner\n" + "'2' for Experienced\n" + "'3' for Expert");

		// gets difficulty from player then changes foody's parameters based on that
		// difficulty
		do {
			System.out.println("Enter your level: ");
			difficulty = keyboard.nextInt();
			if (difficulty == 1) {
				foody.setEscape(10);
				foody.setDamage(10);
				foody.setHealthRestore(15);
				System.out.println("Beginner selected");
			} else if (difficulty == 2) {
				foody.setEscape(15);
				foody.setDamage(20);
				foody.setHealthRestore(10);
				System.out.println("Experienced selected");
			} else if (difficulty == 3) {
				foody.setEscape(20);
				foody.setDamage(30);
				foody.setHealthRestore(5);
				System.out.println("Expert selected");
			} else {
				System.out.println("Must enter 1, 2, or 3");

			}
		} while (difficulty < 1 || difficulty > 3);

		System.out.println("ENTER MORE GAME LORE...SOMETHING ABOUT PLAYER STATS/WEAPONS");

		System.out.println(playerName + ", what room do you want to enter?\n" + "  Bedroom(1)\n"
				+ "   Living Room(2)\n" + "   Kitchen(3)");
		
		do {
			input = keyboard.nextInt();
			if (input == 1) {
				System.out.println(bedroom.getDescription());
				System.out.println("room 1");
			} else if (input == 2) {
				System.out.println("room 2");
			} else if (input == 3) {
				System.out.println("room 3");
			} else {
				System.out.println("Must enter 1, 2, or 3");
			}
		} while (input < 1 || input > 3);
	}

}
