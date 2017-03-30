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
		sb.append("Attack: ");
		sb.append(attack);
		
		sb.append("\tType: ");
		sb.append(weaponType == WeaponType.PHYSICAL_MELEE ? "PHYSICAL" : "MAGIC");
		sb.append("\n");
		return sb.toString();
	}

}
