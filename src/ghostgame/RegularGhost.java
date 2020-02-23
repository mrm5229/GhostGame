package ghostgame;

public class RegularGhost extends Ghost {

	private int escape; // chance of ghost escaping
	private int healthRestore; // health restored to player once ghost is defeated

	// default constructor
	public RegularGhost() {
		super();
		escape = 20;
		healthRestore = 10;
		setDamage(15);	//can't say damage = 15 because it is a private attribute
	}

	/*
	 * overloaded constructor 1 used for a preset escape chance and damage
	 * inflicted
	 * 
	 * @param escape Sets escape chance of ghost
	 * 
	 * @param damage Sets damage inflicted to character by ghost
	 */
	public RegularGhost(int escape, int damage) {
		super();
		this.escape = escape;
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
	 * Used to determine if ghost gets away based on escape chance of ghost. escape
	 * field is the percentage chance of the ghost escaping.
	 * 
	 * @return returns true if ghost escapes attack
	 */
	public boolean doesGhostEscape() {
		boolean result = false;
		int randomResult;
		randomResult = (int) (Math.random() * 100);
		if (randomResult <= escape) {
			result = true;
		}
		return result;
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
