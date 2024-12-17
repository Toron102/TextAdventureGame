package codeAdventure.main;

public abstract class Weapons {

	
	public static int weaponDamage;
	public static String weaponName;
	
	public Weapons(String weaponName, int weaponDamage) {
		
		Weapons.weaponName = weaponName;
		Weapons.weaponDamage = weaponDamage;
	}

	public abstract String getWeaponName();
	public abstract Integer getWeaponDamage();

	

}
