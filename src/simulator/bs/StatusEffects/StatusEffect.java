package simulator.bs.StatusEffects;

import simulator.bs.Characters.GameCharacter;

public abstract class StatusEffect {
	protected int buff;
	protected int turnsApplied;
	protected StatusEffectTime time;
	
	public StatusEffect(int buff){
		this.buff = buff;
		time = StatusEffectTime.NEVER;
	}
	
	public abstract void affectCharacter(GameCharacter character);
	
	public int getBuff(){
		return buff;
	}
	
	public int getTurnsApplied(){
		return turnsApplied;
	}
	
	public void decreaseTurnsApplied(){
		turnsApplied -= 1;
	}
	
	public StatusEffectTime getTime(){
		return time;
	}

}
