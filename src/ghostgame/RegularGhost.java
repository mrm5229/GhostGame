package ghostgame;

import java.util.Scanner;

public class RegularGhost extends Ghost {

	private int escape; // chance of ghost escaping
	private int healthRestore; // health restored to player once ghost is defeated

	// default constructor
	public RegularGhost() {
		super();
		escape = 20;
		healthRestore = 10;
		setDamage(15); // can't say damage = 15 because it is a private attribute
	}

	/*
	 * overloaded constructor 1 used for a preset escape chance and damage inflicted
	 * 
	 * @param escape Sets escape chance of ghost
	 * 
	 * @param damage Sets damage inflicted to character by ghost
	 */
	public RegularGhost(int escape, int damage) {
		super();
		this.escape = escape;
		healthRestore = 10;
		setDamage(damage);
	}

	/*
	 * overloaded constructor 2 used for setting the ghost to the users choice of
	 * easy, medium, or hard
	 * 
	 * @param escape Sets escape chance of ghost
	 * 
	 * @param damage Sets damage inflicted to character by ghost
	 * 
	 * @param healthRestore Determines how much health is restored to the player
	 * once the ghost has been defeated
	 */
	public RegularGhost(int escape, int damage, int healthRestore) {
		super();
		this.escape = escape;
		setDamage(damage);
		this.healthRestore = healthRestore;
	}

	/**
	 * This method determines if the ghost can escape based on the chance of escape
	 * it has set to it
	 * 
	 * @return returns a 1 if ghost escapes attack
	 */
	public int doesGhostEscape() {
		int result;
		int randomResult;
		randomResult = (int) (Math.random() * 100);
		if (randomResult <= escape) {
			result = 1;
		} else {
			result = 0;
		}
		return result;
	}

	/**
	 * The doBattle() method asks a user if they want to battle a ghost or run away
	 * 
	 * 
	 * @return returns a 1 if player wants to battle, a 0 if they run away
	 */
	public int doBattle() {
		int input;
		System.out.println("Do you want to battle or run away?\n" + "   Battle(1)\n" + "   Run Away(2)");
		Scanner keyboard = new Scanner(System.in);
		input = keyboard.nextInt();
		return input;
	}

	public int getEscape() {
		return escape;
	}

	public void setEscape(int escape) {
		this.escape = escape;
	}

	public int getHealthRestore() {
		return healthRestore;
	}

	public void setHealthRestore(int healthRestore) {
		this.healthRestore = healthRestore;
	}

}
