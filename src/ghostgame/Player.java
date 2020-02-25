package ghostgame;

public class Player {

	private String name;
	private int playerHealth = 100;
	private int playerAttack1 = 20;
	private int playerAttack2 = 40;

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

	public int getPlayerAttack1() {
		return playerAttack1;
	}

	public void setPlayerAttack1(int playerAttack) {
		this.playerAttack1 = playerAttack;
	}

	public int getPlayerAttack2() {
		return playerAttack2;
	}

	public void setPlayerAttack2(int playerAttack2) {
		this.playerAttack2 = playerAttack2;
	}

}
