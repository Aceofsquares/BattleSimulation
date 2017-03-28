package simulator.bs;

public class SimpleBattleSimulator extends BattleSimulator {
	@Override
	protected void rules(Character attacker, Character defender) {
		if(Dice.roll(100) - attacker.getSpeed() > defender.getSpeed()){
			if(Dice.roll(100) <= attacker.getCritChance()){
				attacker.phyAttack(defender, true);
			}
			attacker.phyAttack(defender, false);
		} else {
			System.out.printf("%s missed %s!\n", attacker.getName(), defender.getName());
		}
	}
}
