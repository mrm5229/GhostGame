package ghostgame;

public class Room {

	String name;
	String description;
	Ghost enemy;
	
	public Room() {
		
	}

	/**
	 * Method to check if the room is clear
	 */
	public boolean isClear() {
		boolean result = false;
		if (enemy.getHealth() <= 0) {
			result = true;
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

