package simulator.bs.InanimateObjects.Weapons;

import simulator.bs.InanimateObjects.PhysicalMeleeWeapon;

public class BroadSword extends PhysicalMeleeWeapon {
	public BroadSword() {
		super("BroadSword");
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
