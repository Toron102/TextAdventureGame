package codeAdventure.main;

public class WeaponShortSword extends Weapons {

	public WeaponShortSword() {
		
		super("Short Sword", 6);
		
	}

	@Override
	public String getWeaponName() {

		return WeaponShortSword.weaponName;
	}

	@Override
	public Integer getWeaponDamage() {

		return WeaponShortSword.weaponDamage;
	}

}
