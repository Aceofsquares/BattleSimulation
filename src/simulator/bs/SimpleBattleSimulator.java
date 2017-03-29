package simulator.bs;

import simulator.bs.Characters.Character;
import simulator.bs.Weapons.WeaponType;

public class SimpleBattleSimulator extends BattleSimulator {

	@Override
	protected void rules(Character attacker, Character defender) {
		if (attacker.getWeapon().getType() == WeaponType.PHYSICAL) {
			physicalAttack(attacker, defender);
		} else if (attacker.getWeapon().getType() == WeaponType.MAGIC) {
			magicalAttack(attacker, defender);
		}
	}
	
	//Similar to physical attack only we do not include the speed of the defender in their defense check. :O
	private void magicalAttack(Character attacker, Character defender){
		System.out.printf("%s is rolling: ", attacker.getName());
		int attackerHitCheck = Dice.roll(attacker.getMagicAtt()) + attacker.getSpeed();
		System.out.printf("%s is rolling: ", defender.getName());
		int defenderDefenseCheck = Dice.roll(attacker.getMagicDef());
		System.out.printf("Testing if hit. Must beat %d\n", defenderDefenseCheck);
		System.out.printf("The result is %d + %d = %d\n", attackerHitCheck - attacker.getSpeed(), attacker.getSpeed(),
				attackerHitCheck);
		if (attackerHitCheck > defenderDefenseCheck) {
			int critCheck = attacker.getCritChance() + attacker.getWeapon().getCritChance();
			System.out.printf("Testing if crit. Must be <= %d\n", critCheck + attacker.getWeapon().getCritChance());
			if (Dice.roll(100) <= attacker.getCritChance()) {
				attacker.magAttack(defender, true);
			}
			attacker.magAttack(defender, false);
		} else {
			System.out.printf("%s missed %s!\n", attacker.getName(), defender.getName());
		}
	}

	private void physicalAttack(Character attacker, Character defender) {
		System.out.printf("%s is rolling: ", attacker.getName());
		int attackerHitCheck = Dice.roll(attacker.getPhyAtt()) + attacker.getSpeed();
		System.out.printf("%s is rolling: ", defender.getName());
		int defenderDefenseCheck = Dice.roll(attacker.getPhyDef()) + defender.getSpeed();
		System.out.printf("Testing if hit. Must beat %d\n", defenderDefenseCheck);
		System.out.printf("The result is %d + %d = %d\n", attackerHitCheck - attacker.getSpeed(), attacker.getSpeed(),
				attackerHitCheck);
		if (attackerHitCheck > defenderDefenseCheck) {
			int critCheck = attacker.getCritChance() + attacker.getWeapon().getCritChance();
			System.out.printf("Testing if crit. Must be <= %d\n", critCheck + attacker.getWeapon().getCritChance());
			if (Dice.roll(100) <= attacker.getCritChance()) {
				attacker.phyAttack(defender, true);
			}
			attacker.phyAttack(defender, false);
		} else {
			System.out.printf("%s missed %s!\n", attacker.getName(), defender.getName());
		}
	}
}
