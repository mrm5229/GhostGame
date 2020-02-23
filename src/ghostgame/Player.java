package ghostgame;

public class Player {
	
	private String name;
	private int playerHealth = 100;
	private int playerAttack = 0;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPlayerHealth() {
		return playerHealth;
	}
	public void setPlayerHealth(int playerHealth) {
		this.playerHealth = playerHealth;
	}
	public int getPlayerAttack() {
		return playerAttack;
	}
	public void setPlayerAttack(int playerAttack) {
		this.playerAttack = playerAttack;
	}
	
	
}
