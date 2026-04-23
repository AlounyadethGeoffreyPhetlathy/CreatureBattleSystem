public abstract class Creature {
    private float health;
    private String name;
    private String action;
    
    // Constructor
    public Creature(float health, String name, String action) {
    	this.health = health;
    	this.name = name;
    	this.action = action;
    }
    
    // Getters
    public float getHealth() {
    	return health;
    }
    
    public String name() {
    	return name;
    }


    // Returns the damage done by the Creature
//    public float attack() {
//
//        // 20% chance of missing
//        if (Rand.randomInt(0, 10) < 2) {
//            action = name + " missed!";
//            return 0;
//        }
//
//        // otherwise, do damage between 10-20
//        float power = Rand.randomFloat(10, 20);
//        action = name + " attacked with power " + power + "!";
//        return power;
//    }

//    public void defend(float incomingPower) {
//
//        // 10 % chance of reducing damage taken
//        if (Rand.randomInt(0, 10) < 1) {
//            incomingPower = incomingPower * 0.8f;
//            action = name + " defended and reduced damage taken to " + incomingPower;
//        }
//        else
//        {
//            action = name + " did not defend.";
//        }
//
//        health -= incomingPower;
//    }
    
    /* 
     * Every class inherited by Creature will have methods defined differently.
     * Creature is not being used anymore, so I'm using it as a template for the inherited classes.
     */
    
    public abstract int pickAction();
    
    public abstract float attack();
    
    public abstract float defend();
    
    public abstract void calculateNewHealth(float damageTaken);
    
    public abstract void calculateNewHealth(float damageTaken, float defenseMulti);

    public String readAction() {
        return action;
    }

    @Override
    public String toString() {
        return getClass() + "{name: " + name + ", health: " + health + "}";
    }
}
