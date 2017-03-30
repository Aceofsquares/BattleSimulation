package simulator.bs.InanimateObjects;

public abstract class Spell extends Weapon{

	public Spell(String name, RangeType range, WeaponType type){
		super(name, range, type);
	}
	
	public Spell(String name, float weight, int cost, int attack, int critChance, RangeType range, WeaponType type) {
		super(name, weight, cost, attack, critChance, range, type);
		// TODO Auto-generated constructor stub
	}
}
