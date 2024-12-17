package codeAdventure.main;

public class WeaponStick extends Weapons{

	public WeaponStick() {
		
		super("Stick", 2);

	}

	@Override
	public String getWeaponName() {
		return WeaponStick.weaponName;
	}

	@Override
	public Integer getWeaponDamage() {
		return WeaponStick.weaponDamage;
	}

}
