package codeAdventure.main;

public class WeaponDagger extends Weapons{

	public WeaponDagger() {
		
		super("Dagger", 3);
		
	}

	@Override
	public String getWeaponName() {
		return WeaponDagger.weaponName;
	}

	@Override
	public Integer getWeaponDamage() {
		return WeaponDagger.weaponDamage;
	}

}
