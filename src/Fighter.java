public class Fighter extends Creature {
	// Constructor
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
			super.missAction();
			return 0f;
		}
		float power = Rand.randomFloat(15,30);
		super.attackAction();
		return power;
	}
	
	@Override
	public float defend() {
		// 50% chance of defending
		if (Rand.randomInt(0,10) < 5) {
			super.defendAction();
			return 0.6f;
		}
		else {
			super.failDefendAction();
		}
		return 1f;
	}
}
