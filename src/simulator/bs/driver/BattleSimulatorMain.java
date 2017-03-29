package simulator.bs.driver;

import java.util.Scanner;

import simulator.bs.BattleSimulator;
import simulator.bs.SimpleBattleSimulator;
import simulator.bs.Characters.Character;
import simulator.bs.Characters.Human;
import simulator.bs.Characters.Monster;
import simulator.bs.Weapons.BroadSword;
import simulator.bs.Weapons.DarkSpell;

public class BattleSimulatorMain {
	
	private static Scanner input;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		int round = 1;
		int battle = 0;
		//Name, Speed, phyDef, phyAtt, magDef, magAtt, critChance, maxLife, isAlive
		Human brian = new Human("Brian", 8, 17, 2, 2, 17, 4, 18, true);
		brian.equipWeapon(new BroadSword());
		System.out.println(brian);
		Monster banshee;
		BattleSimulator battleSim = new SimpleBattleSimulator(); //Change to your Subclassed simulator.
		while(brian.isAlive() && battle < 100){
			banshee = new Monster("Banshee", 5, 10, 8, 10, 10, 25, 15, true);
			banshee.equipWeapon(new DarkSpell());
			System.out.println(banshee);
			battle += 1;
			while(brian.isAlive() && banshee.isAlive()){
				waitForEnter();
				System.out.printf("\nROUND %d\n", round);
				System.out.printf("\n--%s's turn!--\n", brian.getName());
				battleSim.battle(brian, banshee);
				printBattleInformation(banshee);
				waitForEnter();
				if(banshee.isAlive()){
					System.out.printf("\n--%s's turn!--\n", banshee.getName());
					battleSim.battle(banshee, brian);
					printBattleInformation(brian);
				}
				round += 1;
			}
			
			if(!brian.isAlive()){
				System.out.printf("%s got eaten by %s.\n", brian.getName(), banshee.getName());
			}
			if(!banshee.isAlive()){
				System.out.printf("%s has died at the blade of %s\n", banshee.getName(), brian.getName());
			}
			System.out.printf("End of battle: %d\n", battle);
		}
	}
	
	public static void waitForEnter(){
		System.out.print("Press ENTER to continue...");
		input.nextLine();
	}
	
	public static void printBattleInformation(Character character){
		System.out.printf("%s health: %d\n", character.getName(), character.getLife());
	}
}
