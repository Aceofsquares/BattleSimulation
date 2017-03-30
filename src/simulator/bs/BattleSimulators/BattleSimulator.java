package simulator.bs.BattleSimulators;

import simulator.bs.Characters.GameCharacter;

public abstract class BattleSimulator {

	protected abstract void rules(GameCharacter attacker, GameCharacter defender);

	public void battle(GameCharacter attacker, GameCharacter defender) {
		attacker.enterBattle();
		defender.enterBattle();
		rules(attacker, defender);
		if (!defender.isAlive()) {
			attacker.victory();
			defender.death();
		} else {
			rules(defender, attacker);
			if(!attacker.isAlive()){
				defender.victory();
				attacker.death();
			} else {
				attacker.exitBattle();
				defender.exitBattle();
			}
		}
	}
}
