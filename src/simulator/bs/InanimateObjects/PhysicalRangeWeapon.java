package simulator.bs.InanimateObjects;

public abstract class PhysicalRangeWeapon extends Weapon {
	protected int accuracy;

	public PhysicalRangeWeapon(String name, RangeType range) {
		super(name, range, WeaponType.PHYSICAL_RANGE);
		attack = 0;
		critChance = 0;
		accuracy = 0;
	}

	public PhysicalRangeWeapon(String name, float weight, int cost, int attack, int critChance, RangeType range, int accuracy) {
		super(name, weight, cost, attack, critChance, range, WeaponType.PHYSICAL_RANGE);
		this.accuracy = accuracy;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int acc) {
		accuracy = acc;
	}
}
