public class Tank extends Creature {
	// Constructor
	public Tank(float health, String name, String action) {
		super(health, name, action);
	}
	
	@Override
	public int pickAction() {
		return Rand.randomInt(0,2);
	}
	
	@Override
	public float attack() {
		// 30% chance of missing
		if (Rand.randomInt(0,10) < 3) {
			super.missAction();
			return 0f;
		}
		float power = Rand.randomFloat(25,35);
		super.attackAction();
		return power;
	}
	
	@Override
	public float defend() {
		// 80% chance of defending
		if (Rand.randomInt(0,10) < 8) {
			super.defendAction();
			return 0.3f;
		}
		else {
			super.failDefendAction();
		}
		return 1f;
	}
}
