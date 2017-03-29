package simulator.bs.StatusEffects;

import simulator.bs.Characters.GameCharacter;

public class PoisonEffect extends StatusEffect {
	
	public PoisonEffect(int debuff){
		super(debuff);
		time = StatusEffectTime.BEFORE_BATTLE;
	}

	@Override
	public void affectCharacter(GameCharacter character) {
		character.takeDamage(buff);
	}

}
