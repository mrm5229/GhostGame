package ghostgame;

public class RegularGhost extends Ghost {

	int escape; // chance of ghost escaping
	int damage; // damage inflicted by ghost to player
	int healthRestore; // health restored to player once ghost is defeated

	// default constructor
	public RegularGhost() {

	}

	/*
	 * overloaded constructor 1 used for a pre-set escape chance and damage
	 * inflicted
	 * 
	 * @param escape Sets escape chance of ghost
	 * 
	 * @param damage Sets damage inflicted to character by ghost
	 */
	public RegularGhost(int escape, int damage) {
		this.escape = escape;
		this.damage = damage;
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
		this.escape = escape;
		this.damage = damage;
		this.healthRestore = healthRestore;

	}

}
