public class Tank extends Creature{
	@Override
	public int pickAction() {
		return Rand.randomInt(0,2);
	}
	
	@Override
	public float attack() {
		// 30% chance of missing
		if (Rand.randomInt(0,10) < 3) {
			action = name + " has missed their attack.";
			return 0f;
		}
		float power = Rand.randomFloat(20,30);
		action = name + " has attacked with " + power + " damage!";
		return power;
	}
	
	@Override
	public float defend() {
		// 80% chance of defending
		if (Rand.randomInt(0,10) < 8) {
			action = name + " defended and reduced damage by 70%!";
			return 0.3f;
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
