package simulator.bs;

public class SimpleBattleSimulator extends BattleSimulator {
	@Override
	protected void rules(Character attacker, Character defender) {
		System.out.printf("Testing if hit.  Must beat %d\n", defender.getSpeed());
		int dieRoll = Dice.roll(100);
		System.out.printf("The result is %d - %d = %d\n", dieRoll, attacker.getSpeed(), (dieRoll - attacker.getSpeed()));
		if(dieRoll - attacker.getSpeed() > defender.getSpeed()){
			System.out.printf("Testing if crit. Must be <= %d\n", attacker.getCritChance());
			if(Dice.roll(100) <= attacker.getCritChance()){
				attacker.phyAttack(defender, true);
			}
			attacker.phyAttack(defender, false);
		} else {
			System.out.printf("%s missed %s!\n", attacker.getName(), defender.getName());
		}
	}
}
