package simulator.bs.BattleSimulators;

import simulator.bs.Characters.GameCharacter;

public abstract class BattleSimulator {

	protected abstract void rules(GameCharacter attacker, GameCharacter defender);

	public void battle(GameCharacter attacker, GameCharacter defender) {
		attacker.enterBattle();
		rules(attacker, defender);
		attacker.exitBattle();
		if (!defender.isAlive()) {
			attacker.victory();
			defender.death();
		}
	}
}
