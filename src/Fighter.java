public class Fighter extends Creature {
	public Fighter(float health, String name, String action) {
		super(health, name, action);
	}
	
	@Override
	public int pickAction() {
		return Rand.randomInt(0,2);
	}
	
	@Override
	public float attack() {
		// 10% chance of missing
		if (Rand.randomInt(0,10) < 1) {
			action = name + " has missed their attack.";
			return 0f;
		}
		float power = Rand.randomFloat(15,30);
		action = name + " has attacked with " + power + " damage!";
		return power;
	}
	
	@Override
	public float defend() {
		// 50% chance of defending
		if (Rand.randomInt(0,10) < 5) {
			action = name + " defended and reduced damage by 40%!";
			return 0.6f;
		}
		else {
			action = name + " failed to defend.";
		}
//		health -= incomingPower;
		return 1f;
	}
	
	@Override
	public void calculateNewHealth(float damageTaken) {
		health -= damageTaken;
	}
	
	@Override
	public void calculateNewHealth(float damageTaken, float defenseMulti) {
		health -= damageTaken * defenseMulti;
	}
}
