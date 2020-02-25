package ghostgame;

public class Room {

	String name;
	String description;
	Ghost enemy;
	
	public Room() {
		
	}

	/**
	 * Method to check if the room is clear
	 * 
	 * returns a 1 if enemy is cleared. 
	 */
	public int isClear() {
		int result;
		if (enemy.getHealth() <= 0) {
			result = 1;
		} else {
			result = 0;
		}
		return result;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setEnemy(Ghost enemy) 	{
		this.enemy = enemy;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	 public Ghost getEnemy() {
		 return enemy;
	 }
}

