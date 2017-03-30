package simulator.bs.driver;

import java.util.Scanner;

import simulator.bs.BattleSimulators.BattleSimulator;
import simulator.bs.BattleSimulators.Dice;
import simulator.bs.BattleSimulators.SimpleBattleSimulator;
import simulator.bs.Characters.GameCharacter;
import simulator.bs.Characters.Human;
import simulator.bs.Characters.Monster;
import simulator.bs.InanimateObjects.Weapons.BroadSword;
import simulator.bs.InanimateObjects.Weapons.DarkSpell;

public class BattleSimulatorMain {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		int round = 1;
		int battle = 0;
		GameCharacter brian = new Human("Brian");
		rollCharacter(brian);
		brian.equipWeapon(new BroadSword());
		System.out.println(brian);

		GameCharacter banshee;
		BattleSimulator battleSim = new SimpleBattleSimulator();
		while (brian.isAlive() && battle < 10) {
			banshee = new Monster("Banshee");
			rollCharacter(banshee);
			banshee.equipWeapon(new DarkSpell());
			System.out.println(banshee);
			battle += 1;
			while (brian.isAlive() && banshee.isAlive()) {
				waitForEnter();
				System.out.printf("\nROUND %d\n", round);
				System.out.printf("\n--%s's turn!--\n", brian.getName());
				battleSim.battle(brian, banshee);
				printBattleInformation(banshee);
				waitForEnter();
				if (banshee.isAlive()) {
					System.out.printf("\n--%s's turn!--\n", banshee.getName());
					battleSim.battle(banshee, brian);
					printBattleInformation(brian);
				}
				round += 1;
			}

			if (!brian.isAlive()) {
				System.out.printf("%s got eaten by %s.\n", brian.getName(), banshee.getName());
			}
			if (!banshee.isAlive()) {
				System.out.printf("%s has died at the blade of %s\n", banshee.getName(), brian.getName());
			}
			System.out.printf("End of battle: %d\n", battle);
		}
	}

	public static void rollCharacter(GameCharacter ch) {
		Dice.debugInfo = false;
		ch.setSpeed(Dice.roll(50));
		ch.setCritChance(Dice.roll(50));
		ch.setLife(Dice.roll(15, 30));
		ch.setMagAtt(Dice.roll(25));
		ch.setMagDef(Dice.roll(25));
		ch.setPhyAtt(Dice.roll(25));
		ch.setPhyDef(Dice.roll(25));
		ch.setDexterity(Dice.roll(25));
		ch.setIsAlive(true);
	}

	public static void waitForEnter() {
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}

	public static void printBattleInformation(GameCharacter character) {
		System.out.printf("%s health: %d\n", character.getName(), character.getLife());
	}
}
