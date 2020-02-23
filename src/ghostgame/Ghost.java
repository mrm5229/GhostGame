/*
 * Super class for ghost enemy 
 */

package ghostgame;

public class Ghost {

	private String name;
	private int damage;
	private int health;

	// default constructor - initializes name to null and damage they inflict to
	// zero
	public Ghost() {
		name = null;
		damage = 0;
	}// end constructor

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}



}// end class
