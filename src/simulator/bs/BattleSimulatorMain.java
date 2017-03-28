package simulator.bs;

public class BattleSimulatorMain {
	public static void main(String[] args) {
		//Name, Speed, phyDef, phyAtt, critChance, maxLife, isAlive
		Human brian = new Human("Brian", 8, 17, 17, 4, 18, true);
		Monster banshee = new Monster("Banshee", 3, 10, 5, 15, 15, true);
		SimpleBattleSimulator simpBatSim = new SimpleBattleSimulator();
		while(brian.isAlive() && banshee.isAlive()){
			System.out.printf("\n--%s's turn!--\n", brian.getName());
			simpBatSim.battle(brian, banshee);
			printBattleInformation(banshee);
			if(banshee.isAlive()){
				System.out.printf("\n--%s's turn!--\n", banshee.getName());
				simpBatSim.battle(banshee, brian);
				printBattleInformation(brian);
			}
		}
		
		if(!brian.isAlive()){
			System.out.printf("%s got eaten by %s.", brian.getName(), banshee.getName());
		}
		if(!banshee.isAlive()){
			System.out.printf("%s has died at the blade of %s", banshee.getName(), brian.getName());
		}
	}
	
	public static void printBattleInformation(Character character){
		System.out.printf("%s health: %d\n", character.getName(), character.getLife());
	}
}
