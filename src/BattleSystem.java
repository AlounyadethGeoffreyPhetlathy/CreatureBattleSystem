import java.sql.SQLOutput;

public class BattleSystem {
    public void battle(Creature a, Creature b) {
        while (a.health > 0 && b.health > 0) {
//            float attackPower = a.attack();
//            b.defend(attackPower);
        	
        	int actionA = a.pickAction();
        	int actionB = b.pickAction();
        	
        	if (actionA + actionB == 2) {
        		// Both defend, nothing happens
        		a.defend();
            	b.defend();
        	}
        	else if (actionA + actionB == 0) {
        		// Both attack, both take damage (or miss)
        		float damageA = a.attack();
        		float damageB = b.attack();
        		a.calculateNewHealth(damageB);
        		b.calculateNewHealth(damageA);
        	}
        	else if (actionA == 1) {
        		// A attacks, B defends
        		float damageA = a.attack();
        		float defenseB = b.defend();
        		b.calculateNewHealth(damageA, defenseB);
        	}
        	else if (actionB == 1) {
        		// B attacks, A defends
        		float damageB = b.attack();
        		float defenseA = a.defend();
        		a.calculateNewHealth(damageB, defenseA);
        	}
        	
            System.out.println(a.readAction());
            System.out.println(b.readAction());

            System.out.println(a);
            System.out.println(b);
            System.out.println();

            // swap turns
//            Fighter temp = a;
//            a = b;
//            b = temp;
        }
    }
    
    public Creature[] generateBattlers() {
    	Creature a = null;
    	Creature b = null;
    	switch (Rand.randomInt(0,3)) {
    	case 0:
    		a = new Fighter();
    		a.name = "A";
    		a.health = 120;
    		break;
    	case 1:
    		a = new Ranger();
    		a.name = "A";
    		a.health = 150;
    		break;
    	case 2:
    		a = new Tank();
    		a.name = "A";
    		a.health = 200;
    		break;
    	}
    	switch (Rand.randomInt(0,3)) {
    	case 0:
    		b = new Fighter();
    		b.name = "B";
    		b.health = 120;
    		break;
    	case 1:
    		b = new Ranger();
    		b.name = "B";
    		b.health = 150;
    		break;
    	case 2:
    		b = new Tank();
    		b.name = "B";
    		b.health = 200;
    		break;
    	}
    	Creature[] c = {a,b};
    	return c;
    }
}
