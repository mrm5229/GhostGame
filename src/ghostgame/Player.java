package ghostgame;

public class Player {
	
	private String name;
	private int playerHealth = 100;
	private int playerAttack = 50;
	
	public boolean isPlayerDead() {
		boolean result = false;
		if (playerHealth <= 0) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

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
