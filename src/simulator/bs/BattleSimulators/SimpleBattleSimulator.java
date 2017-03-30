package simulator.bs.BattleSimulators;

import simulator.bs.Characters.GameCharacter;
import simulator.bs.InanimateObjects.WeaponType;

public class SimpleBattleSimulator extends BattleSimulator {

	@Override
	protected void rules(GameCharacter attacker, GameCharacter defender) {
		Dice.debugInfo = true;
		if (attacker.getWeapon().getType() == WeaponType.PHYSICAL_MELEE) {
			physicalAttack(attacker, defender);
		} else if (attacker.getWeapon().getType() == WeaponType.MAGIC_MELEE) {
			magicalAttack(attacker, defender);
		}
	}
	
	//Similar to physical attack only we do not include the speed of the defender in their defense check. :O
	private void magicalAttack(GameCharacter attacker, GameCharacter defender){
		System.out.printf("%s is rolling: ", attacker.getName());
		int attackerHitCheck = Dice.roll(attacker.getMagicAtt()) + attacker.getSpeed();
		System.out.printf("%s is rolling: ", defender.getName());
		int defenderDefenseCheck = Dice.roll(attacker.getMagicDef());
		System.out.printf("Testing if hit. Must beat %d\n", defenderDefenseCheck);
		System.out.printf("The result is %d + %d = %d\n", attackerHitCheck - attacker.getSpeed(), attacker.getSpeed(),
				attackerHitCheck);
		if (attackerHitCheck > defenderDefenseCheck) {
			int critCheck = attacker.getCritChance() + attacker.getWeapon().getCritChance();
			System.out.printf("Testing if crit. Must be <= %d\n", critCheck);
			if (Dice.roll(100) <= critCheck) {
				attacker.magAttack(defender, true);
			}else {
				attacker.magAttack(defender, false);
			}
		} else {
			System.out.printf("%s missed %s!\n", attacker.getName(), defender.getName());
		}
	}

	private void physicalAttack(GameCharacter attacker, GameCharacter defender) {
		System.out.printf("%s is rolling: ", attacker.getName());
		int attackerHitCheck = Dice.roll(attacker.getPhyAtt()) + attacker.getSpeed();
		System.out.printf("%s is rolling: ", defender.getName());
		int defenderDefenseCheck = Dice.roll(attacker.getPhyDef()) + defender.getSpeed();
		System.out.printf("Testing if hit. Must beat %d\n", defenderDefenseCheck);
		System.out.printf("The result is %d + %d = %d\n", attackerHitCheck - attacker.getSpeed(), attacker.getSpeed(),
				attackerHitCheck);
		if (attackerHitCheck > defenderDefenseCheck) {
			int critCheck = attacker.getCritChance() + attacker.getWeapon().getCritChance();
			System.out.printf("Testing if crit. Must be <= %d\n", critCheck);
			if (Dice.roll(100) <= critCheck) {
				attacker.phyAttack(defender, true);
			} else {
				attacker.phyAttack(defender, false);
			}
		} else {
			System.out.printf("%s missed %s!\n", attacker.getName(), defender.getName());
		}
	}
}
