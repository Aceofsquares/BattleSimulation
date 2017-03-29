package simulator.bs.Characters;

public class Human extends GameCharacter {

	public Human(String name) {
		super(name);
	}

	public Human(String name, int maxLife) {
		super(name, maxLife);
	}

	public Human(String name, int speed, int phyDef, int phyAtt, int magDef, int magAtt, int critChance, int maxLife,
			boolean isAlive) {
		super(name, speed, phyDef, phyAtt, magDef, magAtt, critChance, maxLife, isAlive);
	}

	@Override
	public void enterBattle() {
		System.out.println("I must defeat you to save my town, Demon!");
	}

	@Override
	public void exitBattle() {
		System.out.println("That was a close one! I should be more careful.");
	}

	@Override
	public void criticalHit() {
		System.out.println("By the divine!!! I will smite you!!!");
	}

	@Override
	public void death() {
		System.out.println("Noooo!!! I have failed you!");
	}

	@Override
	public void victory() {
		System.out.println("Finally! I am victorious");
	}
}
