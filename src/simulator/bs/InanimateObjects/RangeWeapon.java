package simulator.bs.InanimateObjects;

public abstract class RangeWeapon extends Weapon {

	
	protected int accuracy;
	public RangeWeapon(String name){
		super(name);
		attack = 0;
		weaponType = WeaponType.PHYSICAL_MELEE;
		critChance = 0;
	} 
	public RangeWeapon(String name, float weight, int cost, int attack, int critChance, int accuracy){
		super(name, weight, cost, attack, critChance, WeaponType.PHYSICAL_RANGE);
		this.accuracy = accuracy;
	}
	
	public int getAccuracy(){
		return accuracy;
	}
	
	public void setAccuracy(int acc){
		accuracy = acc;
	}
	

}
