package simulator.bs.InanimateObjects.Weapons;

import simulator.bs.InanimateObjects.Weapon;
import simulator.bs.InanimateObjects.WeaponType;

public class BareHands extends Weapon{

	public BareHands() {
		super("BAREHANDS");
		weaponType = WeaponType.PHYSICAL;
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
