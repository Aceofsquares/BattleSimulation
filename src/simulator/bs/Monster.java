package simulator.bs;

public class Monster extends Character {
	public Monster(String name, int maxLife) {
		super(name, maxLife);
	}
	
	public Monster(String name, int speed, int phyDef, int phyAtt, int critChance, int maxLife, boolean isAlive){
		super(name, speed, phyDef, phyAtt, critChance, maxLife, isAlive);
	}

	@Override
	public void enterBattle() {
		System.out.println("Di puni hooman.");
	}

	@Override
	public void exitBattle() {
		System.out.println("**Stomach Gurgles**  I need to eat!");
	}

	@Override
	public void criticalHit() {
		System.out.println("GRAAAAAAAAAAAAAAHHHHHHHH.");
	}

	@Override
	public void death() {
		System.out.println("How cah dis bae!!!!");
	}
}
