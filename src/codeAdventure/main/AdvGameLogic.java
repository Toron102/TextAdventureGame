package codeAdventure.main;

import java.util.Scanner;

public class AdvGameLogic {

	//bool to restart a game
	public static boolean play = true;

	static Scanner scanner = new Scanner(System.in);
	
	static Hero hero;
	
	static GateGuard guard = new GateGuard();
	
	static Goblin goblin = new Goblin();
	

	public static boolean goblinEar = false;
	
	public static boolean wellWish = false;
	
	public static boolean isStickFound = false;
	
	public static boolean isDaggerFound = false;
	
	public static boolean meditateInRuins = false;
	
	public static boolean isSwordFound = false;
	
	public static boolean isFirstTalkWithGuardDone = false;
	
	public static int readInt(String prompt, int userChoices) {
		int input = 0;
		
		do {
			System.out.println(prompt);
			
			try {
				input = Integer.parseInt(scanner.next());
			} 
			catch (Exception e) {
				input = -1;
				System.out.println("Enter an integer!");
			}
			
		}while(input < 1 || input > userChoices);
		
		return input;
	}
	
	
	//method to simulate clearing up the console window
	public static void clearConsole() {
		for(int i = 0; i < 100; i++) {
			System.out.println();
		}
	}
	
	//method to print separating line with length n
	public static void printSeparator(int n) {
		for(int i = 0; i < n; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	//method to print heading
	public static void printHeading(String title) {
		printSeparator(30);
		System.out.println(title);
		printSeparator(30);
	}
	
	//method to wait on user input
	public static void anythingToContinue() {
		System.out.println("\nType anything to continue...");
		scanner.next();
	}
	
	//method to start game
	public static void startGame() {
		
		boolean nameSet = false;
		String name;
		
		
		clearConsole();
		printSeparator(20);
		printHeading("Adventure game");
		printSeparator(20);
		anythingToContinue();
		
		//getting hero name from the player
		do {
			clearConsole();
			printHeading("What is your name?");
			name = scanner.next();
			clearConsole();
			
			printHeading("Your name is: " + name + " \nIs that correct?");
			System.out.println("(1). Yes");
			System.out.println("(2). No, change my name.");
			int input = readInt("->", 2);
				if(input == 1) {
					nameSet = true;
				}
			
		}while(!nameSet);
		
		
		//creating hero object with set name 
		hero = new Hero(name);
		
		hero.setWeaponToFists();
		//start game loop
		clearConsole();
		crossRoads();

		
		
	}
	
	public static void crossRoads() 
	{
		printSeparator(30);
		System.out.println("You stand alone at the Crossroads.");
		System.out.println("Only way for you is forward.");
		System.out.println("But what path will you choose now?");
		System.out.println("(1). Go to the towns Main Gate.");
		System.out.println("(2). Go to the lonely well near the Crossroads.");
		System.out.println("(3). Go to the old ruins close to the city walls.");
		System.out.println("(4). Go to the eadge of the Great Forest.");
		System.out.println("(5). Go to the bridge over the local river.");
		System.out.println("(6). Check your stats.");
		printSeparator(30);
		int input = readInt("->", 6);
		if(input == 1) 
		{
			clearConsole();
			townGate();
		}
		else if(input == 2) 
		{
			clearConsole();
			lonelyWell();
		}
		else if(input == 3) 
		{
			clearConsole();
			oldRuins();
		}
		else if(input == 4) 
		{
			clearConsole();
			edgeOfTheForest();
		}
		else if(input == 5)
		{
			clearConsole();
			nearTheBridge();
		}
		else if(input == 6)
		{
			checkYourStats();
			crossRoads();
		}
	}
	
	public static void townGate() 
	{
		clearConsole();
		printSeparator(30);
		System.out.println("You are at the main gate of the city.");
		System.out.println("There is a guard standing in front of the gate.");
		System.out.println("What do you want to do?");
		System.out.println("(1). Talk to the guard.");
		System.out.println("(2). Try to sneak past the guard.");
		System.out.println("(3). Return to the Crossroads.");
		System.out.println("(4). Check your stats.");
		printSeparator(30);
		int input = readInt("->", 4);
		if (input == 1 && isFirstTalkWithGuardDone == false)
		{
			clearConsole();
			printSeparator(30);
			System.out.println("Greetings traveller, do you want to enter our beautiful town?");
			System.out.println("If so, I will need to ask you for your name first.");
			System.out.println("What do you want to do?");
			System.out.println("(1). Tell him your name.");
			System.out.println("(2). Refuse to tell him.");
			printSeparator(30);
			int input2 = readInt("->", 2);
			if (input2 == 1)
			{
				clearConsole();
				printSeparator(30);
				System.out.println("So, your name is " + hero.name + ", right?");
				System.out.println("Good to know, but you need to understand that we can not let any stranger into our town.");
				System.out.println("Even if they are as polite as you are.");
				System.out.println("The area around the town has become dangerous.");
				System.out.println("There are rumors about monsters blocking important strategic points.");
				System.out.println("We have our orders to be especially cautious.");
				printSeparator(30);
				isFirstTalkWithGuardDone = true;
				anythingToContinue();
				townGate();	
			}
			else if (input2 == 2)
			{
				clearConsole();
				printSeparator(30);
				System.out.println("Yes, keep your name to yourself, it is a great way to make friends in new places...");
				System.out.println("One way or another, I still would not let you into our town.");
				System.out.println("The area around the town has become dangerous.");
				System.out.println("There are rumors about monsters blocking important strategic points.");
				System.out.println("We have our orders to be especially cautious.");
				printSeparator(30);
				isFirstTalkWithGuardDone = true;
				anythingToContinue();
				townGate();	
			}
		}
		else if (input == 1 && isFirstTalkWithGuardDone == true && goblinEar == false)
		{
			clearConsole();
			printSeparator(30);
			System.out.println("Welcome again, I must inform you that nothing changed in the matter of monsters.");
			System.out.println("You should be careful around here, especially near our Great Bridge.");
			System.out.println("Some elusive goblins make us all kind of problems there.");
			printSeparator(30);
			anythingToContinue();
			townGate();
		}
		else if (input == 1 && isFirstTalkWithGuardDone == true && goblinEar == true)
		{
			clearConsole();
			printSeparator(30);
			System.out.println("So you really did have taken care of our green, little problem?");
			System.out.println("Those are some really great news, I must say!");
			System.out.println("You deserve to enter our town like noone else.");
			System.out.println("And keep your little trophy, maybe someone in the town would like to buy it.");
			System.out.println("What do you want to do?");
			System.out.println("(1). Enter the town.");
			System.out.println("(2). Stay here a little longer.");
			printSeparator(30);
			int input2 = readInt("->", 2);
			if (input2 == 1) 
			{
				endAdventure();
			}
			else if(input2 == 2)
			{
				townGate();
			}
		}
		else if (input == 2)
		{
			clearConsole();
			printSeparator(30);
			System.out.println("You tried to sneak past a very vigilant gate guard!");
			System.out.println("It was not a brightest idea...");
			printSeparator(30);
			anythingToContinue();
			clearConsole();
			printSeparator(30);
			System.out.println("Hey, what do you think you are doing?");
			System.out.println("Trying to senak past gatehouse in the light of day?");
			System.out.println("Get out of here, will you?");
			System.out.println("You walked away, fearing the consequences...");
			printSeparator(30);
			anythingToContinue();
			crossRoads();
		}
		else if (input == 3)
		{
			crossRoads();
		}
		else if (input == 4) 
		{
			checkYourStats();
			townGate();
		}
		
	}
	
	public static void lonelyWell() 
	{
		printSeparator(30);
		System.out.println("You stand before the lonely well, covered with ivy and moss.");
		System.out.println("It seems noone is coming here anymore...");
		System.out.println("What do you want to do?");
		System.out.println("(1). Use well's windlass to drink some fresh, cold water.");
		System.out.println("(2). Make a wish!");
		System.out.println("(3). Return to the Crossroads.");
		System.out.println("(4). Check your stats.");
		printSeparator(30);
		int input = readInt("->", 4);
		if(input == 1)
		{
			clearConsole();
			printSeparator(30);
			System.out.println("You drank the crystal-clear water.");
			System.out.println("You can feel your strenght returning!");
			hero.hp = hero.maxHp;
			System.out.println("Your HP: "+hero.hp+"/"+hero.maxHp);
			printSeparator(30);
			anythingToContinue();
			lonelyWell();
		}
		else if(input == 2 && wellWish == false)
		{
			wishToTheWell();
		}
		else if(input == 2 && wellWish == true)
		{
			clearConsole();
			printSeparator(30);
			System.out.println("You can feel that the well is deaf to your wishes...");
			System.out.println("You cannot ask for anything more!");
			printSeparator(30);
			anythingToContinue();
			lonelyWell();
		}
		else if(input == 3)
		{
			crossRoads();
		}
		else if(input == 4)
		{
			checkYourStats();
			lonelyWell();
		}

	}
	
	public static void oldRuins() 
	{
		clearConsole();
		printSeparator(30);
		System.out.println("You approach the ruins of the once proud watchtower.");
		System.out.println("The only inhabitants here are little birds and bugs.");
		if(isDaggerFound == false) 
		{
			System.out.println("You can see something glittering underneath the large rubble stones.");
		}
		else if (isDaggerFound == true)
		{
			System.out.println("There seems to be nothing more of the value here.");
		}

		System.out.println("What do you want to do?");
		if(hero.weaponName=="Fists") 
		{
			System.out.println("(1). Try to push the stones away with your hands.");
		}
		else if(hero.weaponName=="Stick") 
		{
			System.out.println("(1). Try to push the stones away using wooden stick.");
		}
		else if(hero.weaponName=="Dagger" || hero.weaponName=="Short Sword")
		{
			System.out.println("(1). Take your moment to meditate amongst the ruins.");
		}
		System.out.println("(2). Return to the Crossroads.");
		System.out.println("(3). Check your stats.");
		printSeparator(30);
		int input =readInt("->", 3);
		if(input == 1 && hero.weaponName=="Fists")
		{
			clearConsole();
			printSeparator(30);
			System.out.println("It seems this will be very hard and tiring work...");
			System.out.println("Some would say it would be work beyond your strength.");
			System.out.println("Do you want to try nontheless?");
			System.out.println("(1). Lets get to work!");
			System.out.println("(2). Back off.");
			printSeparator(30);
			int input2 = readInt("->", 2);
			if(input2 == 1) 
			{
				clearConsole();
				printSeparator(30);
				hero.hp = hero.hp/2;
				if(hero.hp == 0) 
				{
					hero.hp++;
				}
				System.out.println("You lost half of your life energy.");
				System.out.println("Your health is now "+ hero.hp+"/"+hero.maxHp);
				System.out.println("But you did it!");
				System.out.println("You pull out a dagger from under the rubble.");
				System.out.println("Dagger is not rusty at all, maybe someone lost it here not so long ago?");
				hero.setWeaponToDagger();
				isDaggerFound = true;
				System.out.println("Your weapon damage: "+ hero.getHeroAttackDamage());
				System.out.println("Your weapon name: "+ hero.getHeroWeaponEquipped());
				anythingToContinue();
				oldRuins();	
			}
			else if (input2 == 2)
			{
				clearConsole();
				printSeparator(30);
				System.out.println("You thought it is too risky to overwork yourself like that.");
				System.out.println("Maybe later you will find a solution to get to this shiny thing...");
				printSeparator(30);
				anythingToContinue();
				oldRuins();	
			}
			
		}
		else if (input == 1 && hero.weaponName=="Stick")
		{
			clearConsole();
			printSeparator(30);
			System.out.println("You used your wooden stick to push the stones.");
			System.out.println("The stick broke on the last stone!");
			System.out.println("Luckly it was enough to get to what you were looking for.");
			System.out.println("You pull out a dagger from under the rubble.");
			System.out.println("Dagger is not rusty at all, maybe someone lost it here not so long ago?");
			hero.setWeaponToDagger();
			isDaggerFound = true;
			System.out.println("Your weapon damage: "+ hero.getHeroAttackDamage());
			System.out.println("Your weapon name: "+ hero.getHeroWeaponEquipped());
			anythingToContinue();
			oldRuins();	
		}
		else if(input == 1 && (hero.weaponName=="Dagger" || hero.weaponName=="Short Sword") && meditateInRuins == false)
		{
			clearConsole();
			printSeparator(30);
			System.out.println("You lost yourself in thoughts about meaning of time...");
			System.out.println("It seems like everything that is made by hand will sooner or later turn into dust.");
			hero.lvlUp();
			meditateInRuins = true;
			printSeparator(30);
			anythingToContinue();
			oldRuins();
		}
		else if(input == 1 && (hero.weaponName=="Dagger" || hero.weaponName=="Short Sword") && meditateInRuins == true)
		{
			clearConsole();
			printSeparator(30);
			System.out.println("There is nothing more to think about.");
			printSeparator(30);
			anythingToContinue();
			oldRuins();
		}
		else if(input == 2)
		{
			crossRoads();
		}
		else if(input == 3)
		{
			checkYourStats();
			oldRuins();
		}
	}
	
	public static void edgeOfTheForest() 
	{
		clearConsole();
		printSeparator(30);
		System.out.println("You are now at the very edge of terryfing and majestic Great Forest, home to many dangers.");
		System.out.println("You can feel an unntatural calmness emanating from behind the trees...");
		System.out.println("What do you want to do?");
		System.out.println("(1). Check if there is something useful lying near the border of the forest.");
		System.out.println("(2). Enter the forest.");
		System.out.println("(3). Return to the Crossroads.");
		System.out.println("(4). Check your stats.");
		printSeparator(30);
		int input = readInt("->", 4);
		if(input == 1 && isStickFound == false && isDaggerFound == false)
		{
			clearConsole();
			printSeparator(30);
			System.out.println("You checked around the near trees, minding not to enter the forest.");
			System.out.println("You found sturdy-looking branch, perfect to defend yourself from dangers!");
			hero.setWeaponToStick();
			System.out.println("Your weapon damage: "+ hero.getHeroAttackDamage());
			System.out.println("Your weapon name: "+ hero.getHeroWeaponEquipped());
			printSeparator(30);
			isStickFound = true;
			anythingToContinue();
			edgeOfTheForest();
		}
		else if (input == 1 && (isStickFound == true || isDaggerFound == true))
		{
			clearConsole();
			printSeparator(30);
			System.out.println("You checked the area, but without much success...");
			printSeparator(30);
			anythingToContinue();
			edgeOfTheForest();
		}
		else if(input == 2) {
			enterTheForest();
		}
		else if (input == 3)
		{
			crossRoads();
		}
		else if (input == 4)
		{
			checkYourStats();
			edgeOfTheForest();
		}

		
	}
	
	public static void enterTheForest() 
	{
		clearConsole();
		printSeparator(30);
		System.out.println("You decided to enter the forest, prepared to face the worst.");
		System.out.println("As you venture through the thicket you notice many, unfriendly looking, purple eyes in the dark.");
		System.out.println("They are keeping close watch on you...");
		System.out.println("What do you want to do?");
		System.out.println("(1). Run back to the edge of the forest as fast as you can!");
		System.out.println("(2). Greet watchful eyes with warm and respectful tone.");
		System.out.println("(3). Walk onward into the forest!");
		printSeparator(30);
		int input = readInt("->", 3);
			if(input == 1) 
			{
				clearConsole();
				printSeparator(30);
				System.out.println("You decided to run away from danger as fast as your legs could carry you!");
				printSeparator(30);
				anythingToContinue();
				edgeOfTheForest();
				clearConsole();
			}
			else if(input == 2) 
			{
				clearConsole();
				System.out.println("You took on a respectful tone of voice, greeting many strange eyes looming in the dark.");
				System.out.println("There was no repsonse.");
				System.out.println("What do you want to do?");
				System.out.println("(1). Run back to the edge of the forest as fast as you can!");
				System.out.println("(2). Walk onward into the forest!");
				int inputRetry = readInt("->", 2);
					if(inputRetry == 1) 
					{
						clearConsole();
						System.out.println("You decided to run away from danger as fast as your legs could carry you!");
						anythingToContinue();
						edgeOfTheForest();
						clearConsole();
					}
					else if(inputRetry == 2) 
					{
						clearConsole();
						System.out.println("You decided to walk forward, unphased by fear.");
						System.out.println("Eyes in the dark quickly got up to you, covering you in purple fog.");
						System.out.println("You felt pain in your whole body, taking "+ hero.maxHp/2 +" damage in the process!");
						hero.hp -= hero.maxHp/2;
						if(hero.hp < 1)
						{
							death();
						}
						else 
						{
							System.out.println("Your health is now "+ hero.hp+"/"+hero.maxHp);
							System.out.println("You decided to run back to the edge of the forest, afraid of your own life!");
							anythingToContinue();
							edgeOfTheForest();
							clearConsole();
						}
					}
			}
			else if(input == 3) 
			{
				clearConsole();
				System.out.println("You decided to walk forward, unphased by fear.");
				System.out.println("Eyes in the dark quickly got up to you, covering you in purple fog.");
				System.out.println("You felt pain in your whole body, taking "+ hero.maxHp/2 +" damage in the process!");
				hero.hp -= hero.maxHp/2;
				if(hero.hp < 1)
				{
					death();
				}
				else 
				{
					System.out.println("Your health is now "+ hero.hp+"/"+hero.maxHp);
					System.out.println("You decided to run back to the edge of the forest, afraid of your own life!");
					anythingToContinue();
					edgeOfTheForest();
					clearConsole();
				}

			}
			else if(input == 4)
			{
				checkYourStats();
				edgeOfTheForest();
			}
	}
	
	public static void nearTheBridge() 
	{
		if(goblinEar == false)
		{
			printSeparator(30);
			System.out.println("You stand now near the bridge spanning the river.");
			System.out.println("A gigling noise is heard on the bridge...");
			System.out.println("What do you want to do?");
			System.out.println("(1). Enter the bridge");
			System.out.println("(2). Take a walk on a sandy river coast stretching under the bridge.");
			System.out.println("(3). Return to the Crossroads.");
			System.out.println("(4). Check your stats.");
			printSeparator(30);
			int input = readInt("->", 4);
			if (input == 1) 
			{
				onTheBridge();
			}
			else if (input == 2)
			{
				sandyShore();
			}
			else if (input == 3)
			{
				crossRoads();
			}
			else if (input == 4)
			{
				checkYourStats();
				nearTheBridge();
			}
		}
		else if (goblinEar == true)
		{
			clearConsole();
			printSeparator(30);
			System.out.println("You stand now near the bridge spanning the river.");
			System.out.println("The place feels much safer now that the goblin is gone.");
			System.out.println("What do you want to do?");
			System.out.println("(1). Take a walk on a sandy river coast stretching under the bridge.");
			System.out.println("(2). Return to the Crossroads");
			System.out.println("(3). Check your stats.");
			printSeparator(30);
			int input = readInt("->", 3);
			if (input == 1)
			{
				sandyShore();
			}
			else if (input == 2)
			{
				crossRoads();
			}
			else if (input == 3)
			{
				checkYourStats();
				nearTheBridge();
			}
		}
		
	}
	
	public static void sandyShore() 
	{
		if(isSwordFound == false) {
			
		clearConsole();
		printSeparator(30);
		System.out.println("When you walk on the sandy shore of crystal clear river, you come across a peculiar find.");
		System.out.println("It looks like the waters washed a closed chest ashore!");
		System.out.println("What do you want to do?");
		System.out.println("(1). Take a closer look at the chest.");
		System.out.println("(2). Try to open it!");
		System.out.println("(3). Go back to the bridge.");
		System.out.println("(4). Check your stats.");
		printSeparator(30);
		int input = readInt("->", 4);
		if(input == 1) 
		{
			clearConsole();
			printSeparator(30);
			System.out.println("At first glance, the only noteworthy thing is a strange emblem carved on the box.");
			System.out.println("It features a purse pierced with a spear.");
			System.out.println("You do not know the origin of this symbol.");
			System.out.println("But it looks like an emblem of some kind of Trading Company.");
			System.out.println("What do you want to do?");
			System.out.println("(1). Try to open the chest!");
			System.out.println("(2). Go back to the bridge.");
			System.out.println("(3). Check your stats.");
			printSeparator(30);
			int input2 = readInt("->", 3);
			if (input2 == 1 && hero.weaponName == "Fists")
			{
				clearConsole();
				printSeparator(30);
				System.out.println("You tried to force it open with your bare hands!");
				System.out.println("Strength alone is not enough here...");
				System.out.println("You do not have the equipment or the tools necessary to open the chest.");
				printSeparator(30);
				anythingToContinue();
				sandyShore();
			}
			else if (input2 == 1 && hero.weaponName == "Stick")
			{
				clearConsole();
				printSeparator(30);
				System.out.println("With your solid stick in hands you can try to pry open the lid of the chest.");
				System.out.println("Do you want to try it?");
				System.out.println("(1). Yes!");
				System.out.println("(2). No!");
				printSeparator(30);
				int input3 = readInt("->", 2);
				if (input3 == 1)
				{
					clearConsole();
					printSeparator(30);
					System.out.println("You tried to open the chest using your stick.");
					System.out.println("Unfortunately, the stick did not survive this attempt...");
					System.out.println("And the chest is still locked tight.");
					System.out.println("You lost your stick!");
					hero.setWeaponToFists();
					System.out.println("Your weapon damage: "+ hero.getHeroAttackDamage());
					System.out.println("Your weapon name: "+ hero.getHeroWeaponEquipped());
					printSeparator(30);
					anythingToContinue();
					sandyShore();
				}
				else if (input3 == 2)
				{
					clearConsole();
					printSeparator(30);
					System.out.println("You decided the stick will not be enough to open the chest.");
					System.out.println("You walk away from the chest.");
					printSeparator(30);
					anythingToContinue();
					sandyShore();
				}
			}
			else if (input2 == 1 && hero.weaponName == "Dagger")
			{
				clearConsole();
				printSeparator(30);
				System.out.println("With dagger at your disposal, you can try to pry open the lid of the chest.");
				System.out.println("Do you want to try it?");
				System.out.println("(1). Yes!");
				System.out.println("(2). No!");
				printSeparator(30);
				int input4 = readInt("->", 2);
				if (input4 == 1)
				{
					clearConsole();
					printSeparator(30);
					System.out.println("You tried to open the chest using your dagger.");
					System.out.println("It worked!");
					System.out.println("However, the dagger broke in the process.");
					System.out.println("You lost your dagger!");
					System.out.println("You look inside the chest.");
					printSeparator(30);
					anythingToContinue();
					clearConsole();
					printSeparator(30);
					System.out.println("There is a bundle at the bottom...");
					System.out.println("You unroll the bundle.");
					System.out.println("It is a sword, and in good condition nonetheless!");
					hero.setWeaponToShortSword();
					isSwordFound = true;
					System.out.println("Your weapon damage: "+ hero.getHeroAttackDamage());
					System.out.println("Your weapon name: "+ hero.getHeroWeaponEquipped());
					printSeparator(30);
					anythingToContinue();
					sandyShore();
				}
				else if (input4 == 2)
				{
					clearConsole();
					printSeparator(30);
					System.out.println("You thought to yourself that the dagger would not survive this action.");
					System.out.println("You walk away from the chest.");
					printSeparator(30);
					anythingToContinue();
					sandyShore();
				}
			}
			else if (input2 == 2)
			{
				nearTheBridge();
			}
			else if (input2 == 3)
			{
				checkYourStats();
				sandyShore();
			}
		}
		else if(input == 2 && hero.weaponName == "Fists")
		{
			clearConsole();
			printSeparator(30);
			System.out.println("You tried to force it open with your bare hands!");
			System.out.println("Strength alone is not enough here...");
			System.out.println("You do not have the equipment or the tools necessary to open the chest.");
			printSeparator(30);
			anythingToContinue();
			sandyShore();
		}
		else if(input == 2 && hero.weaponName == "Stick")
		{
			clearConsole();
			printSeparator(30);
			System.out.println("With your solid stick in hands you can try to pry open the lid of the chest.");
			System.out.println("Do you want to try it?");
			System.out.println("(1). Yes!");
			System.out.println("(2). No!");
			printSeparator(30);
			int input3 = readInt("->", 2);
			if (input3 == 1)
			{
				clearConsole();
				printSeparator(30);
				System.out.println("You tried to open the chest using your stick.");
				System.out.println("Unfortunately, the stick did not survive this attempt...");
				System.out.println("And the chest is still locked tight.");
				System.out.println("You lost your stick!");
				hero.setWeaponToFists();
				System.out.println("Your weapon damage: "+ hero.getHeroAttackDamage());
				System.out.println("Your weapon name: "+ hero.getHeroWeaponEquipped());
				printSeparator(30);
				anythingToContinue();
				sandyShore();
			}
			else if (input3 == 2)
			{
				clearConsole();
				printSeparator(30);
				System.out.println("You decided the stick will not be enough to open the chest.");
				System.out.println("You walk away from the chest.");
				printSeparator(30);
				anythingToContinue();
				sandyShore();
			}
		}
		else if (input == 2 && hero.weaponName == "Dagger")
		{
			clearConsole();
			printSeparator(30);
			System.out.println("With a dagger at your disposal, you can try to pry open the lid of the chest.");
			System.out.println("Do you want to try it?");
			System.out.println("(1). Yes!");
			System.out.println("(2). No!");
			printSeparator(30);
			int input4 = readInt("->", 2);
			if (input4 == 1)
			{
				clearConsole();
				printSeparator(30);
				System.out.println("You tried to open the chest using your dagger.");
				System.out.println("It worked!");
				System.out.println("However, the dagger broke in the process.");
				System.out.println("You lost your dagger!");
				System.out.println("You look inside the chest.");
				printSeparator(30);
				anythingToContinue();
				clearConsole();
				printSeparator(30);
				System.out.println("There is a bundle at the bottom...");
				System.out.println("You unroll the bundle.");
				System.out.println("It is a sword, and in good condition nonetheless!");
				hero.setWeaponToShortSword();
				isSwordFound = true;
				System.out.println("Your weapon damage: "+ hero.getHeroAttackDamage());
				System.out.println("Your weapon name: "+ hero.getHeroWeaponEquipped());
				printSeparator(30);
				anythingToContinue();
				sandyShore();
			}
			else if (input4 == 2)
			{
				clearConsole();
				printSeparator(30);
				System.out.println("You thought to yourself that the dagger would not survive this action.");
				System.out.println("You walk away from the chest.");
				printSeparator(30);
				anythingToContinue();
				sandyShore();
			}
		}
		else if (input == 3)
		{
			nearTheBridge();
		}
		else if (input == 4)
		{
			checkYourStats();
			sandyShore();
		}

		}
		else if (isSwordFound == true) 
		{
			clearConsole();
			printSeparator(30);
			System.out.println("The chest stands open, empty.");
			System.out.println("There is nothing more you can find on this sandy shore.");
			System.out.println("What do you want to do?");
			System.out.println("(1). Go back to the bridge.");
			System.out.println("(2). Check your stats.");
			printSeparator(30);
			int input = readInt("->", 2);
			if (input == 1)
			{
				nearTheBridge();
			}
			else if (input == 2)
			{
				checkYourStats();
				sandyShore();
			}
		}
		
	}
	
	public static void onTheBridge() {
		clearConsole();
		printSeparator(30);
		System.out.println("You entered the cobblestone birdge, preparing for not-so-pleasant meeting with Goblin.");
		System.out.println("The knife that goblin wields reflects the sunrays.");
		printSeparator(30);
		anythingToContinue();
		fightWithGoblin();
	}
	
	
	public static void fightWithGoblin() {
		printSeparator(30);
		if(goblin.hp == goblin.maxHp || goblin.hp > (goblin.maxHp/2)) 
		{
		System.out.println("You can hear quiet sound of water beneath the bridge...");
		}
		else if(goblin.hp <= (goblin.maxHp/2) && goblin.hp > (goblin.maxHp/4))
		{
			System.out.println("You can see goblin's courage faiding.");
		}
		else if(goblin.hp < (goblin.maxHp/3.5))
		{
			System.out.println("Goblin is standing on his last legs!");
		}
		System.out.println("Your HP: "+hero.hp+"/"+hero.maxHp);
		System.out.println("Your weapon damage: "+ hero.getHeroAttackDamage());
		System.out.println("Your weapon name: "+ hero.getHeroWeaponEquipped());
		System.out.println("Enemy's HP: "+goblin.hp+"/"+goblin.maxHp);
		System.out.println("(1). Attack");
		System.out.println("(2). Run away");
		printSeparator(30);
		int input = readInt("->", 2);
		if(input == 1) {
			int playerAttackDamage = hero.attack();
			int playerDefense = hero.defense();
			int goblinAttackDamage = goblin.attack();
			int goblinDefense = goblin.defense();
			if (playerAttackDamage < goblinDefense) 
			{
				playerAttackDamage = goblinDefense;
			}
			
			if (goblinAttackDamage < playerDefense)
			{
				goblinAttackDamage = playerDefense;
			}
			
			int goblinDamageTaken;
			int heroDamageTaken;
			if(goblin.hp > 0) 
			{
				
				System.out.println("You attack the enemy for "+(playerAttackDamage-goblinDefense)+" DMG");
				goblinDamageTaken =  playerAttackDamage-goblinDefense;
				if (goblinDamageTaken == 0) 
				{
					System.out.println("You missed your attack!");
				}
				goblin.hp -= goblinDamageTaken;
				System.out.println("Goblin attacks you for "+(goblinAttackDamage-playerDefense)+" DMG");
				heroDamageTaken = goblinAttackDamage-playerDefense;
				if (heroDamageTaken == 0) 
				{
					System.out.println("Enemy missed his attack!");
				}
				hero.hp -= heroDamageTaken;
				if(hero.hp > 0 && goblin.hp > 0) {
					fightWithGoblin();
				}
				
				else if(hero.hp < 1) 
				{
					death();
				}
				else if (goblin.hp < 1) 
				{
					wonFightWithGoblin();
				}
			}

		}
		else if (input == 2) {
			System.out.println("You run away from the fight!");
			System.out.println("Your enemy will use this time to fully regenerate his health.");
			goblin.hp = goblin.maxHp;
			anythingToContinue();
			nearTheBridge();
		}
	}
	
	public static void wonFightWithGoblin() {
		clearConsole();
		printSeparator(30);
		System.out.println("You won a fight!");
		goblinEar = true;
		System.out.println("The area will feel a lot safer now.");
		System.out.println("This will be enough of an accomplishment to finally be let in into the town.");
		System.out.println("You decide to take one of the goblin's Ears as a proof.");
		printSeparator(30);
		hero.lvlUp();
		anythingToContinue();
		nearTheBridge();
	}
	
	public static void death() {

		printSeparator(30);
		System.out.println("You fell on the ground, feeling the strength leaving your body...");
		System.out.println("You died!");
		System.out.println("Game Over");
		printSeparator(30);
		System.out.println("Do you wish to try again?");
		System.out.println("(1). Yes!");
		System.out.println("(2). No!");
		int input = readInt("->", 2);
		if(input == 1) {
			startGame();
		}
		else if(input == 2)
		{
			play=false;
		}

		

	}
	
	public static void checkYourStats() {
		clearConsole();
		printSeparator(30);
		System.out.println("Your HP: "+hero.hp+"/"+hero.maxHp);
		System.out.println("Your weapon damage: "+ hero.getHeroAttackDamage());
		System.out.println("Your weapon name: "+ hero.getHeroWeaponEquipped());
		System.out.println("Your LVL: "+hero.lvl);
		printSeparator(30);
		anythingToContinue();
		clearConsole();

	}
	
	public static void wishToTheWell() {
		clearConsole();
		printSeparator(30);
		System.out.println("What do you wish from the old well?");
		System.out.println("(1). Wish for better physical prowess!");
		System.out.println("(2). Wish for a way to overcome obstacles!");
		printSeparator(30);
		int input = readInt("->", 2);
		if(input == 1 )
		{
			clearConsole();
			printSeparator(30);
			System.out.println("Soft whispers fill your mind with tales of grandeur...");
			hero.lvlUp();
			printSeparator(30);
			wellWish = true;
			anythingToContinue();
			lonelyWell();
		}
		else if (input == 2)
		{
			clearConsole();
			printSeparator(30);
			System.out.println("In your mind you see a sea of sand, an abandoned chest and a small blade helping the big one!");
			System.out.println("In the distance you can also see old ruins...");
			System.out.println("This cloudy vision sets you on a new path.");
			printSeparator(30);
			wellWish = true;
			anythingToContinue();
			lonelyWell();
		}
	}
	
	public static void endAdventure() {
		System.out.println("You did it, you are finally in the town!");
	}
}
