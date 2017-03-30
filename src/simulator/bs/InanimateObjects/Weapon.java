package simulator.bs.InanimateObjects;

public abstract class Weapon extends Item {
		
	protected WeaponType weaponType;
	protected int attack;
	protected int critChance;
	protected RangeType range;
	
	public Weapon(String name, RangeType range, WeaponType weaponType){
		super(name);
		attack = 0;
		this.weaponType = weaponType;
		critChance = 0;
		this.range = range;
	} 
	
	public Weapon(String name, float weight, int cost, int attack, int critChance, RangeType range, WeaponType weaponType){
		super(name, weight, cost, ItemType.EQUIPPABLE);
		this.critChance = critChance;
		this.attack = attack;
		this.weaponType = weaponType;
		this.range = range;
	}
	
	public int getAttack(){
		return attack;
	}
	
	public RangeType getRange(){
		return range;
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
		
		sb.append("\t");
		sb.append("Range: ");
		sb.append(range);
		sb.append("\n");
		return sb.toString();
	}

}
