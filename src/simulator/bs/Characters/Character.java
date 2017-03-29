package simulator.bs.Characters;

import simulator.bs.Weapons.Weapon;

public abstract class Character {
	protected String name;
	protected int speed;
	protected int phyDef;
	protected int phyAtt;
	protected int magDef;
	protected int magAtt;
	protected int critChance;
	protected int life;
	protected int maxLife;
	protected boolean isAlive;
	protected Weapon weapon;
	
	//*****These will perform different things for different characters****//
	//*****Must be implemented****//
	public abstract void enterBattle();
	public abstract void exitBattle();
	public abstract void criticalHit();
	public abstract void death();
	
	public Character(String name, int maxLife){
		//***Everything by default is 0, false, or null***//
		isAlive = true;
		life = maxLife;
		weapon = new Weapon();
		this.maxLife = maxLife;
		this.name = name;
	}
	
	public Character(String name, int speed, int phyDef, int phyAtt, int magDef, int magAtt, int critChance, int maxLife, boolean isAlive){
		weapon = new Weapon();
		this.name = name;
		this.speed = speed;
		this.phyDef = phyDef;
		this.phyAtt = phyAtt;
		this.magDef = magDef;
		this.magAtt = magAtt;
		this.critChance = critChance;
		this.maxLife = maxLife;
		this.life = maxLife;
		this.isAlive = isAlive;
	}
	
	public void takeDamage(int damage){
		if(damage > 0){
			life -= damage;
			System.out.printf("%s took %d damage\n", name, damage);
			if(life <= 0){
				isAlive = false;
			}
		} else {
			System.out.printf("%s took no damage\n", name);
		}
	}
	
	public void heal(int healAmnt){
		if((healAmnt + life) > maxLife){
			life = maxLife;
		} else {
			life += healAmnt;
		}
	}
	
	public void equipWeapon(Weapon weapon){
		this.weapon = weapon;
	}
	
	public void phyAttack(Character attackedCharacter, boolean isCrit) {
		double critModifier = isCrit ? 2.5 : 1;
		
		int otherAttDef = attackedCharacter.getPhyDef();
		int damage = (int)((phyAtt * critModifier) + weapon.getAttack()) - otherAttDef;
		attackedCharacter.takeDamage(damage);
	}
	
	public void magAttack(Character attackedCharacter, boolean isCrit){
		double critModifier = isCrit ? 2.5 : 1;
		
		int otherMagDef = attackedCharacter.getMagicDef();
		int damage = (int)((magAtt + weapon.getAttack()) * critModifier) - otherMagDef;
		attackedCharacter.takeDamage(damage);
	}
	
	public void setSpeed(int spd){
		speed = spd;
	}
	
	public void setPhyDef(int pDef){
		phyDef = pDef;
	}
	
	public void setPhyAtt(int pAtt){
		phyAtt = pAtt;
	}
	
	public void setMagDef(int mDef){
		magDef = mDef;
	}

	public void setMagAtt(int mAtt){
		magAtt = mAtt;
	}
	
	public void setCritChance(int critChnc){
		critChance = critChnc;
	}
	
	public void setLife(int lfe){
		life = lfe;
	}
	
	public void setIsAlive(boolean alive){
		isAlive = alive;
	}
	
	public int getSpeed() {
		return speed;
	}
	public int getPhyDef() {
		return phyDef;
	}
	public int getPhyAtt() {
		return phyAtt;
	}
	public int getMagicDef(){
		return magDef;
	}
	public int getMagicAtt(){
		return magAtt;
	}
	public int getCritChance() {
		return critChance;
	}
	public int getLife() {
		return life;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public String getName(){
		return name;
	}
	public Weapon getWeapon(){
		return weapon;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Name: ");
		sb.append(name);
		sb.append("\n");
		
		sb.append("Life: ");
		sb.append(life);
		sb.append("\n");
		
		sb.append("Phy Att: ");
		sb.append(phyAtt);
		sb.append("\n");
		
		sb.append("Phy Def: ");
		sb.append(phyDef);
		sb.append("\n");
		
		sb.append("Mag Def: ");
		sb.append(magDef);
		sb.append("\n");
		
		sb.append("Mag Att: ");
		sb.append(magAtt);
		sb.append("\n");
		
		sb.append("Speed: ");
		sb.append(speed);
		sb.append("\n");
		
		sb.append("Crit: ");
		sb.append(critChance);
		sb.append("\n");
		
		sb.append("Alive: ");
		sb.append(isAlive);
		sb.append("\n");
		
		sb.append("----Weapon----");
		sb.append("\n");
		sb.append(weapon.toString());
		sb.append("\n");
		sb.append("--------------");
		sb.append("\n");
		
		return sb.toString();
	}
}
