/*
 * Super class for ghost enemy 
 */

package ghostgame;

public class Ghost {

	String name;
	int damage;
	int health;

	// default constructor - initializes name to null and damage they inflict to
	// zero
	Ghost() {
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
