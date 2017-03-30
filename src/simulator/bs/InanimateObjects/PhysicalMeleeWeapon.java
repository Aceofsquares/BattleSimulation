package simulator.bs.InanimateObjects;

public abstract class PhysicalMeleeWeapon extends Weapon {
	public PhysicalMeleeWeapon(String name) {
		super(name, RangeType.CLOSE, WeaponType.PHYSICAL_MELEE);
		attack = 0;
		critChance = 0;
	}

	public PhysicalMeleeWeapon(String name, float weight, int cost, int attack, int critChance) {
		super(name, weight, cost, attack, critChance, RangeType.CLOSE, WeaponType.PHYSICAL_RANGE);
	}
}
