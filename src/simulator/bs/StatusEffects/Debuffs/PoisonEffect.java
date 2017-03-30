package simulator.bs.StatusEffects.Debuffs;

import simulator.bs.Characters.GameCharacter;
import simulator.bs.StatusEffects.StatusEffect;
import simulator.bs.StatusEffects.StatusEffectTime;

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
