package codeAdventure.main;

public class GateGuard extends Characters {

	WeaponShortSword weaponEquipSword = new WeaponShortSword();
	public int weaponDamage = weaponEquipSword.getWeaponDamage();
	public String weaponName = weaponEquipSword.getWeaponName();
	
	public GateGuard() {
		super("Gate Guard", 30, 30, 3);
		
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
		return (int) (Math.random()*this.lvl);
	}

}
