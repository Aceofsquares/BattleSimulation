package simulator.bs.BattleSimulators;

import simulator.bs.Characters.Character;

public abstract class BattleSimulator {

	protected abstract void rules(Character attacker, Character defender);

	public void battle(Character attacker, Character defender) {
		attacker.enterBattle();
		rules(attacker, defender);
		attacker.exitBattle();
		if (!defender.isAlive()) {
			attacker.victory();
			defender.death();
		}
	}
}
