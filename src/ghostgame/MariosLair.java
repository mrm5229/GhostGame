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
		String playerName = "name"; // holds name of player
		int difficulty; // holds difficulty level selected by player

		Scanner keyboard = new Scanner(System.in);

		// Game room setup
		Room bedroom = new Room();
		Room living = new Room();
		Room kitchen = new Room();
		Room basement = new Room();

		RegularGhost lampy = new RegularGhost(); // uses default constructor
		RegularGhost couchy = new RegularGhost(15, 20); // uses overloaded constructor 1
		RegularGhost foody = new RegularGhost(15, 10, 10); // uses overloaded constructor 2
		BossGhost bigBaddy = new BossGhost(100, 30); // uses default constructor

		// puts the ghosts into their rooms
		bedroom.setEnemy(lampy);
		living.setEnemy(couchy);
		kitchen.setEnemy(foody);
		basement.setEnemy(bigBaddy);

		bedroom.setDescription(
				"\nYou have entered the bedroom. A lamp in the corner begins to violently flicker and shake!.\n"
						+ "You have encountered Lampy, the lamp ghost!");
		living.setDescription(
				"\nYou have entered the living room. A strong wind swirls through the room as the couch begins to hover!\n"
						+ "You have encountered Couchy, the couch ghost! ");
		kitchen.setDescription(
				"\nYou have entered the kitchen. The fridge door swings open and with it emerges a terrifying ghost!\n"
						+ "You have encountered Foody, the pompous eater ghost!");
		basement.setDescription("\nAs you clear the last room you hear laughter from the basement.\n"
				+ "All of the sudden you are pulled down the stairs and the door slams shut behind you!\n"
				+ "You look around and notice a baseball bat along the wall. You pick it up to use as a weapon.\n"
				+ "A Big Baddy basement ghost attacks!");

		lampy.setName("Lampy");
		couchy.setName("Couchy");
		foody.setName("Foody");
		bigBaddy.setName("BigBaddy");

		// PLayer Setup
		Player ghostHunter = new Player();

		// Game Begins
		System.out.println("\t\tWelcome to Marios Lair!\n\n"
				+ "Mario and Peach have bought a house which they did not know is haunted!\n"
				+ "Your objective is to clear all of the ghosts out of Marios house so he and Peach can move in.\n"
				+ "\t*Not to be confused with the inferior Luigis Mansion*\n\nWhat is your name?");
		playerName = keyboard.nextLine();
		System.out.println("\nNice to meet you " + playerName + "!\nWhat level ghost hunter are you?\n"
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
				ghostHunter.setPlayerAttack1(50);
				ghostHunter.setPlayerHealth(100);
				bigBaddy.setDamage(10);
				bigBaddy.setHealth(50);
				System.out.println("Beginner selected");
			} else if (difficulty == 2) {
				foody.setEscape(40);
				foody.setDamage(20);
				foody.setHealthRestore(10);
				ghostHunter.setPlayerAttack1(30);
				ghostHunter.setPlayerHealth(80);
				bigBaddy.setDamage(20);
				bigBaddy.setHealth(75);
				System.out.println("Experienced selected");
			} else if (difficulty == 3) {
				foody.setEscape(50);
				foody.setDamage(20);
				foody.setHealthRestore(5);
				ghostHunter.setPlayerAttack1(10);
				ghostHunter.setPlayerHealth(80);
				bigBaddy.setDamage(25);
				bigBaddy.setHealth(100);
				System.out.println("Expert selected");
			} else {
				System.out.println("Must enter 1, 2, or 3");
			}
		} while (difficulty < 1 || difficulty > 3);

		System.out.println("\nAs you enter Mario's Lair you have " + ghostHunter.getPlayerHealth()
				+ " health and are equipped with an enchanted vacuum to capture the ghosts.\n"
				+ "You are now in the foyer and must start clearing the house.");

		// loop to clear the 3 main rooms
		int check;
		do {
			if (ghostHunter.isPlayerDead() == false) {

				System.out.println("\n" + playerName + ", what room do you want to enter?\n" + "   Bedroom(1)\n"
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
								System.out.println(lampy.getName()
										+ " escapes your attack and shines a bright light into your face, "
										+ "knocking you back into the foyer!\nYour health is now: "
										+ ghostHunter.getPlayerHealth());
							} else {
								lampy.setHealth(0);
								ghostHunter.setPlayerHealth(ghostHunter.getPlayerHealth() + lampy.getHealthRestore());
								System.out.println("\nIts lights out for " + lampy.getName() + "!\nYou've sucked him"
										+ " into your vacuum and cleared the Bedroom!\n" + lampy.getHealthRestore()
										+ " health has been restored. Your health is now "
										+ ghostHunter.getPlayerHealth());
							}
							break;
						}
					} else {
						System.out.println("You have already cleared this room!");
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
								ghostHunter.setPlayerHealth(ghostHunter.getPlayerHealth() - couchy.getDamage());
								System.out
										.println(couchy.getName() + " escapes your attack and throws a cushion at you,"
												+ " knocking you back into the foyer!\nYour health is now: "
												+ ghostHunter.getPlayerHealth());
							} else {
								couchy.setHealth(0);
								ghostHunter.setPlayerHealth(ghostHunter.getPlayerHealth() + couchy.getHealthRestore());
								System.out.println("\nTime to kick " + couchy.getName()
										+ " to the curb!\nYou've sucked him"
										+ " into your vacuum and cleared the Living Room!\n" + couchy.getHealthRestore()
										+ " health has been restored. Your health is now "
										+ ghostHunter.getPlayerHealth());
							}
							break;
						}
					} else {
						System.out.println("You have already cleared this room!");
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
								ghostHunter.setPlayerHealth(ghostHunter.getPlayerHealth() - foody.getDamage());
								System.out.println(
										foody.getName() + " escapes your attack and pelts you with acai berries"
												+ " knocking you back into the foyer!\nYour health is now: "
												+ ghostHunter.getPlayerHealth());
							} else {
								foody.setHealth(0);
								ghostHunter.setPlayerHealth(ghostHunter.getPlayerHealth() + foody.getHealthRestore());
								System.out.println(foody.getName() + " is toast!\nYou've sucked him" 
										+ " into your vacuum and cleared the Kitchen!\n" + foody.getHealthRestore()
										+ " health has been restored. " + "Your health is now "
										+ ghostHunter.getPlayerHealth());
							}
							break;
						}
					} else {
						System.out.println("You have already cleared this room!");
					}

					break;
				default:
					System.out.println("Not a valid selection");
				}

				check = (kitchen.isClear()) + (living.isClear() + (bedroom.isClear()));
			} else {
				check = 3;
			}

		} while (check < 3);

		// loop to fight the boss
		if (ghostHunter.isPlayerDead() == false) {
			System.out.println(basement.getDescription());
			int stop = 0;
			do {
				if (ghostHunter.isPlayerDead() == false) {
					System.out.println(
							"\nWhich weapon would you like to use?\n" + "   Vacuum(1)\n" + "   Baseball Bat(2)");
					input = keyboard.nextInt();
					switch (input) {
					case 1:
						ghostHunter.setPlayerHealth((ghostHunter.getPlayerHealth() - bigBaddy.getDamage()));
						bigBaddy.setHealth(bigBaddy.getHealth() - ghostHunter.getPlayerAttack1());
						if (bigBaddy.getHealth() > 0) {

							System.out.println("You inflicted " + ghostHunter.getPlayerAttack1()
									+ " damage.\nBig Baddy's health is now " + bigBaddy.getHealth() + "."
									+ "\nThe ghost counter attacked by throwing basement trash at you doing "
									+ bigBaddy.getDamage() + " damage! \nYour health is now "
									+ ghostHunter.getPlayerHealth() + ".");
						} else {
							System.out.println("You inflicted " + ghostHunter.getPlayerAttack1()
									+ ". Big Baddy's health is now " + bigBaddy.getHealth() + ".");
							break;
						}
						break;
					case 2:
						ghostHunter.setPlayerHealth((ghostHunter.getPlayerHealth() - bigBaddy.getDamage()));
						bigBaddy.setHealth(bigBaddy.getHealth() - ghostHunter.getPlayerAttack2());
						if (bigBaddy.getHealth() > 0) {

							System.out.println("You inflicted " + ghostHunter.getPlayerAttack2()
									+ " damage.\nBig baddy's health is now " + bigBaddy.getHealth() + "."
									+ "\nThe ghost counter attacked by throwing basement trash at you doing "
									+ bigBaddy.getDamage() + " damage! \nYour health is now "
									+ ghostHunter.getPlayerHealth() + ".");
						} else {
							System.out.println("You inflicted " + ghostHunter.getPlayerAttack2()
									+ ". Big Baddy's health is now " + bigBaddy.getHealth() + ".");
							break;
						}
						break;
					default:
						System.out.println("Not a valid selection");
					}
				} else {
					System.out.println("\nOut of health\n" + "GAME OVER");
					stop = 1;
				}
			} while (bigBaddy.getHealth() > 0 && stop == 0);
		} else {
			System.out.println("Player is out of health\n" + "GAME OVER");
		}

		if (bigBaddy.getHealth() <= 0) {
			System.out.println("\n" + playerName + ", you defeated Big Baddy basement ghost and cleared the house.\n"
					+ "Mario and Peach can now move into their ghost-free home.\n\n"
					+ "\t\t***YOU WIN!!!***");
		}

	}

}
