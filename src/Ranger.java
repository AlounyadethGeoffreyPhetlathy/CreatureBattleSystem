public class Ranger extends Creature{
	@Override
	public int pickAction() {
		return Rand.randomInt(0,2);
	}
	
	@Override
	public float attack() {
		// 50% chance of missing
		if (Rand.randomInt(0,10) < 5) {
			action = name + " has missed their attack.";
			return 0f;
		}
		float power = Rand.randomFloat(40,65);
		action = name + " has attacked with " + power + " damage!";
		return power;
	}
	
	@Override
	public float defend() {
		// 50% chance of defending
		if (Rand.randomInt(0,10) < 5) {
			action = name + " dodge roll the attack!";
			return 0f;
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
