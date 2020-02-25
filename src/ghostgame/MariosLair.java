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

		// puts the ghosts into their rooms
		bedroom.setEnemy(lampy);
		living.setEnemy(couchy);
		kitchen.setEnemy(foody);
		basement.setEnemy(bigBaddy);

		bedroom.setDescription("SET DESCRIPTION for bedroom");
		living.setDescription("SET DESCRIPTION for living room");
		kitchen.setDescription("SET DESCRIPTION");
		basement.setDescription("SET DESCRIPTION");

		lampy.setName("Lampy");
		couchy.setName("Couchy");
		foody.setName("Foody");
		bigBaddy.setName("BigBaddy");

		// PLayer Setup
		Player ghostHunter = new Player();

		// Game Begins
		System.out.println("Welcome...ADD MORE GAME LORE LATER\n" + "What is your name?");
		playerName = keyboard.nextLine();
		System.out.println("Nice to meet you " + playerName + "\nWhat level ghost hunter are you?\n"
				+ "'1' for Beginner\n" + "'2' for Experienced\n" + "'3' for Expert");

		// gets difficulty from player then changes the player's and foody's parameters
		// based on that difficulty
		do {
			System.out.println("Enter your level: ");
			difficulty = keyboard.nextInt();
			if (difficulty == 1) {
				foody.setEscape(20);
				foody.setDamage(10);
				foody.setHealthRestore(15);
				ghostHunter.setPlayerAttack(50);
				ghostHunter.setPlayerHealth(100);
				System.out.println("Beginner selected");
			} else if (difficulty == 2) {
				foody.setEscape(50);
				foody.setDamage(20);
				foody.setHealthRestore(10);
				ghostHunter.setPlayerAttack(30);
				ghostHunter.setPlayerHealth(80);
				System.out.println("Experienced selected");
			} else if (difficulty == 3) {
				foody.setEscape(75);
				foody.setDamage(30);
				foody.setHealthRestore(5);
				ghostHunter.setPlayerAttack(10);
				ghostHunter.setPlayerHealth(60);
				System.out.println("Expert selected");
			} else {
				System.out.println("Must enter 1, 2, or 3");
			}
		} while (difficulty < 1 || difficulty > 3);

		System.out.println("ENTER MORE GAME LORE...SOMETHING ABOUT PLAYER STATS/WEAPONS");

		int check;
		do {
			if (ghostHunter.isPlayerDead() == false) {

				System.out.println(playerName + ", what room do you want to enter?\n" + "  Bedroom(1)\n"
						+ "   Living Room(2)\n" + "   Kitchen(3)");

				input = keyboard.nextInt();
				switch (input) {
				case 1: // for Bedroom
					int clear = bedroom.isClear();
					if (clear == 0) {
						System.out.println(bedroom.getDescription());
						int battle = lampy.doBattle();
						if (battle == 1) {
							int escape = lampy.doesGhostEscape();
							if (escape == 1) {
								ghostHunter.setPlayerHealth(ghostHunter.getPlayerHealth() - lampy.getDamage());
								System.out.println("Lampy escapes attack and attacks you! Your health is now:"
										+ ghostHunter.getPlayerHealth());
							} else {
								lampy.setHealth(0);
								System.out.println("You've sucked up Lampy into your vacuum and cleared the Bedroom!");
							}
							break;
						}
					} else {
						System.out.println("This room is clear");
					}

					break;
				case 2: // for living room
					int clear1 = living.isClear();
					if (clear1 == 0) {
						System.out.println(living.getDescription());
						int battle = couchy.doBattle();
						if (battle == 1) {
							int escape = couchy.doesGhostEscape();
							if (escape == 1) {
								System.out.println("Couchy escapes attack and attacks you! Your health is now:");
							} else {
								couchy.setHealth(0);
								System.out.println("You've sucked up Couchy into your vacuum and cleared the Bedroom!");
							}
							break;
						}
					} else {
						System.out.println("This room is clear");
					}

					break;
				case 3: // for kitchen
					int clear2 = kitchen.isClear();
					if (clear2 == 0) {
						System.out.println(kitchen.getDescription());
						int battle = foody.doBattle();
						if (battle == 1) {
							int escape = foody.doesGhostEscape();
							if (escape == 1) {
								System.out.println("Foody escapes attack and attacks you! Your health is now:");
							} else {
								foody.setHealth(0);
								System.out.println("You've sucked up Foody into your vacuum and cleared the Bedroom!");
							}
							break;
						}
					} else {
						System.out.println("This room is clear");
					}

					break;
				default:
					System.out.println("Not a valid selection");
				}

				check = (kitchen.isClear()) + (living.isClear() + (bedroom.isClear()));
			} else {
				System.out.println("Player is out of health\n" + "GAME OVER");
				check = 3;
			}

		} while (check < 3);

		System.out.println("ENTER LORE for BOSS GHOST");

		/*
		 * do { if (input == 1) { System.out.println(bedroom.getDescription());
		 * System.out.println("room 1"); } else if (input == 2) {
		 * System.out.println("room 2"); } else if (input == 3) {
		 * System.out.println("room 3"); } else {
		 * System.out.println("Must enter 1, 2, or 3"); } } while (input < 1 || input >
		 * 3);
		 */
	}

}
