package simulator.bs.Weapons;

public class Weapon {
		
	protected WeaponType type;
	protected int attack;
	protected int weight;
	protected int critChance;
	
	public Weapon(){
		attack = 0;
		type = WeaponType.PHYSICAL;
		critChance = 0;
	}
	
	public int getAttack(){
		return attack;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public WeaponType getType(){
		return type;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Attack: ");
		sb.append(attack);
		sb.append("\n");
		
		sb.append("Weight: ");
		sb.append(weight);
		sb.append("\n");
		
		sb.append("Type: ");
		sb.append(type == WeaponType.PHYSICAL ? "PHYSICAL" : "MAGIC");
		sb.append("\n");
		return sb.toString();
	}

	public int getCritChance() {
		// TODO Auto-generated method stub
		return critChance;
	}

}
