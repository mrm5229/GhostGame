package ghostgame;

public class Room {

	String name;
	String description;
	Ghost enemy;
	
	public Room() {
		
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

