package simulator.bs;

public class BattleSimulatorMain {
	public static void main(String[] args) {
		//Name, Speed, phyDef, phyAtt, critChance, maxLife, isAlive
		Human brian = new Human("Brian", 8, 17, 17, 4, 18, true);
		Monster banshee = new Monster("Banshee", 3, 10, 5, 15, 15, true);
		SimpleBattleSimulator simpBatSim = new SimpleBattleSimulator();
		while(brian.isAlive() && banshee.isAlive()){
			System.out.printf("--%s's turn!--\n", brian.getName());
			simpBatSim.battle(brian, banshee);
			if(banshee.isAlive()){
				System.out.printf("--%s's turn!--\n", banshee.getName());
				simpBatSim.battle(banshee, brian);
			}
		}
		
		if(!brian.isAlive()){
			System.out.println("Brian died at the hooves of Monster Girl.");
		}
		if(!banshee.isAlive()){
			System.out.println("Banshee has died at the blade of Brian.");
		}
	}
}
