package simulator.bs.InanimateObjects.Weapons;

import simulator.bs.InanimateObjects.PhysicalMeleeWeapon;

public class BareHands extends PhysicalMeleeWeapon {
	public BareHands() {
		super("BAREHANDS");
		attack = 1;
		critChance = 1;
		weight = 0;
		cost = 0;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "To some, these are for working.  Others, for killing";
	}
}
