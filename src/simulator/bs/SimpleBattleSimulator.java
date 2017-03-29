package simulator.bs;

public class SimpleBattleSimulator extends BattleSimulator {

	@Override
	protected void rules(Character attacker, Character defender) {
		System.out.printf("%s is rolling: ", attacker.getName());
		int attackerHitCheck = Dice.roll(100) + attacker.getSpeed();
		System.out.printf("%s is rolling: ", defender.getName());
		int defenderDefenseCheck = Dice.roll(100) + defender.getSpeed();
		System.out.printf("Testing if hit.  Must beat %d\n", defenderDefenseCheck);
		System.out.printf("The result is %d + %d = %d\n", attackerHitCheck - attacker.getSpeed(), attacker.getSpeed(),
				attackerHitCheck);
		if (attackerHitCheck > defenderDefenseCheck) {
			System.out.printf("Testing if crit. Must be <= %d\n", attacker.getCritChance());
			if (Dice.roll(100) <= attacker.getCritChance()) {
				attacker.phyAttack(defender, true);
			}
			attacker.phyAttack(defender, false);
		} else {
			System.out.printf("%s missed %s!\n", attacker.getName(), defender.getName());
		}
	}
}
