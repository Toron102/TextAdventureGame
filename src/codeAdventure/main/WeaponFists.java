package codeAdventure.main;

public class WeaponFists extends Weapons{

	public WeaponFists() {
		
		super("Fists", 1);

	}
	
	@Override
	public String getWeaponName() {
		return WeaponFists.weaponName;
	}

	@Override
	public Integer getWeaponDamage() {
		return WeaponFists.weaponDamage;
	}

}
