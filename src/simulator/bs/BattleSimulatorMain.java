package simulator.bs;

import java.util.Scanner;

public class BattleSimulatorMain {
	
	private static Scanner input;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		int round = 1;
		//Name, Speed, phyDef, phyAtt, critChance, maxLife, isAlive
		Human brian = new Human("Brian", 8, 17, 17, 4, 18, true);
		Monster banshee = new Monster("Banshee", 3, 10, 5, 55, 15, true);
		BattleSimulator battleSim = new SimpleBattleSimulator(); //Change to your Subclassed simulator.
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
			System.out.printf("%s got eaten by %s.", brian.getName(), banshee.getName());
		}
		if(!banshee.isAlive()){
			System.out.printf("%s has died at the blade of %s", banshee.getName(), brian.getName());
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
