package simulator.bs.InanimateObjects.Weapons;

import simulator.bs.InanimateObjects.Weapon;
import simulator.bs.InanimateObjects.WeaponType;

public class BroadSword extends Weapon {
	public BroadSword() {
		super("BroadSword");
		weaponType = WeaponType.PHYSICAL_MELEE;
		attack = 5;
		critChance = 2;
		cost = 3;
		weight = 5;
	}

	@Override
	public String getDescription() {
		return "A sword that is as broad as it is deadly.";
	}
}
