package simulator.bs.InanimateObjects.Weapons;

import simulator.bs.InanimateObjects.RangeType;
import simulator.bs.InanimateObjects.Spell;
import simulator.bs.InanimateObjects.WeaponType;

public class DarkSpell extends Spell {
	public DarkSpell(){
		super("Dark Spell", RangeType.SHORT, WeaponType.MAGIC_MELEE);
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
