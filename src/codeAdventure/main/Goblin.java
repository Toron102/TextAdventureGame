package codeAdventure.main;

public class Goblin extends Characters {

	WeaponDagger weaponEquipDagger = new WeaponDagger();
	
	public String weaponName = weaponEquipDagger.getWeaponName();
	public int weaponDamage = weaponEquipDagger.getWeaponDamage();
	
	public Goblin() {
		super("Goblin", 14, 14, 1);
		
	}
	
	public String getWeaponName() {
		return this.weaponName;
		
	}
	
	public int getWeaponDamage() {
		return this.weaponDamage;
	}

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return (int) (Math.random()*(this.lvl + this.weaponDamage));
	}

	@Override
	public int defense() {
		// TODO Auto-generated method stub
		return this.lvl;
	}

}
