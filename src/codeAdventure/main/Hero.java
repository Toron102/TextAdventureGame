package codeAdventure.main;

public class Hero extends Characters{
	
	public int weaponDamage;
	public String weaponName;
	
	public Hero(String name) {
		super(name, 10, 10, 1);
				
	}
	
	WeaponFists weaponEquipFists;
	WeaponStick weaponEquipStick;
	WeaponDagger weaponEquipDagger;
	WeaponShortSword weaponEquipSword;
	
	public void setWeaponToFists() {
		weaponEquipFists = new WeaponFists();
		this.weaponName = weaponEquipFists.getWeaponName();
		this.weaponDamage = weaponEquipFists.getWeaponDamage();
	}
	
	public void setWeaponToStick() {
		weaponEquipStick = new WeaponStick();
		this.weaponName = weaponEquipStick.getWeaponName();
		this.weaponDamage = weaponEquipStick.getWeaponDamage();
	}
	
	public void setWeaponToDagger() {
		weaponEquipDagger = new WeaponDagger();
		this.weaponName = weaponEquipDagger.getWeaponName();
		this.weaponDamage = weaponEquipDagger.getWeaponDamage();
	}
	
	public void setWeaponToShortSword() {
		weaponEquipSword = new WeaponShortSword();
		this.weaponName = weaponEquipSword.getWeaponName();
		this.weaponDamage = weaponEquipSword.getWeaponDamage();
	}
	
	public int getHeroAttackDamage() {
		return this.weaponDamage;
	}
	
	public String getHeroWeaponEquipped() {
		return this.weaponName;
	}
	
	public void lvlUp() {
		System.out.println("Your experience grows!");
		this.lvl++;
		this.hp+=2;
		this.maxHp+=2;
		System.out.println("Your HP: "+this.hp+"/"+this.maxHp);
		System.out.println("Your LVL: "+this.lvl);
	}



	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return (int) (Math.random()*(this.lvl + this.weaponDamage));
	}

	@Override
	public int defense() {
		// TODO Auto-generated method stub
		return (int) (Math.random()*(this.lvl));
	}
	
}
