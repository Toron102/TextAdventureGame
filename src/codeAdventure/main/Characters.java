package codeAdventure.main;

public abstract class Characters {

	
	//variables that all characters have
	public int hp, maxHp, lvl;
	public String name;
	
	//construct characters
	public Characters(String name,int hp, int maxHp, int lvl) {
		this.name = name;
		this.hp = maxHp;
		this.maxHp = maxHp;
		this.lvl = lvl;

	}
	
	public abstract int attack();
	public abstract int defense();
}

