package simulator.bs.InanimateObjects;

public abstract class Weapon extends Item {
		
	protected WeaponType weaponType;
	protected int attack;
	protected int critChance;
	
	public Weapon(String name){
		super(name);
		attack = 0;
		weaponType = WeaponType.PHYSICAL_MELEE;
		critChance = 0;
	} 
	public Weapon(String name, float weight, int cost, int attack, int critChance, WeaponType type){
		super(name, weight, cost, ItemType.EQUIPPABLE);
		this.critChance = critChance;
		this.attack = attack;
		this.weaponType = type;
	}
	
	public int getAttack(){
		return attack;
	}
	
	public WeaponType getType(){
		return weaponType;
	}

	public int getCritChance() {
		return critChance;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		if(weaponType == WeaponType.PHYSICAL_MELEE){
			sb.append(" (PHYSICAL MELEE)");
		} else if(weaponType == WeaponType.PHYSICAL_RANGE){
			sb.append(" (PHYSICAL RANGE)");
		} else if(weaponType == WeaponType.MAGIC_MELEE){
			sb.append(" (MAGIC MELEE)");
		} else if(weaponType == WeaponType.MAGIC_RANGE){
			sb.append(" (MAGIC RANGE)");
		} else {
			sb.append(" (UNKNOWN)");
		}
		
		sb.append("\n");
		
		sb.append("Attack: ");
		sb.append(attack);
		
		sb.append("\t");
		sb.append("Crit: ");
		sb.append(critChance);
		sb.append("\n");
		return sb.toString();
	}

}
