package simulator.bs.InanimateObjects.Weapons;

import simulator.bs.InanimateObjects.Weapon;
import simulator.bs.InanimateObjects.WeaponType;

public class DarkSpell extends Weapon {
	public DarkSpell(){
		super("Dark Spell");
		weaponType = WeaponType.MAGIC_MELEE;
		attack = 6;
		critChance = 10;
		cost = 15;
		weight = 0;
	}

	@Override
	public String getDescription() {
		return "Some prefer the light. Others, were born at night.";
	}
}
