public class Ranger extends Creature {
	// Constructor
	public Ranger(float health, String name, String action) {
		super(health, name, action);
	}
	
	@Override
	public int pickAction() {
		return Rand.randomInt(0,2);
	}
	
	@Override
	public float attack() {
		// 50% chance of missing
		if (Rand.randomInt(0,10) < 5) {
			super.missAction();
			return 0f;
		}
		float power = Rand.randomFloat(40,65);
		super.attackAction();
		return power;
	}
	
	@Override
	public float defend() {
		// 50% chance of defending
		if (Rand.randomInt(0,10) < 5) {
			super.defendAction();
			return 0f;
		}
		else {
			super.failDefendAction();
		}
		return 1f;
	}
}
