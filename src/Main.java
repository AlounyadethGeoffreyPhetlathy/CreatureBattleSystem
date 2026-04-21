public class Main {
    public static void main(String[] args) {
    	// set up the battle
        BattleSystem battleSystem = new BattleSystem();

        // set up the creatures
        Creature[] battlers = battleSystem.generateBattlers();
        System.out.println(battlers[0] + " " + battlers[1]);

        // run the battle
        battleSystem.battle(battlers[0], battlers[1]);
    }
}
