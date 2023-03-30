package Console;
import Modele.Charactere;
import Modele.Enemy;
import Modele.Wizard;

import javax.swing.*;
import java.util.Scanner;
import java.util.Stack;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    public static boolean isRunning;
    public static Wizard wizard;
    public static Charactere charactere;

    //random enemies
    public static String[]encounters={"Battle","Battle","Battle","Battle","Rest","Rest"};
    //enemy names
    public static String[] enemy={"Troll","Basilic","Dementor","Voldemort & Peter Pettigrow", "Dolores Ombrage","Death Eaters"};
    //elements de l'histoire
    public static int place = 0, act=1;

    //methode pour que les joueurs mettent des choses dans la console
    public static int readInt(String prompt, int userChoices) {
        int input;
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Please enter an integer !");
            }
        } while (input < 1 || input > userChoices);
        return input;
    }
        //methode pour clear la console
        public static void clearConsole(){
            for (int i=0; i <100; i++);
            System.out.println();
        }
        //methode pour afficher une spération de n longueur
        public static void printSeperator(int n){
            for (int i=0; i<n;i++)
                System.out.println("-");
            System.out.println();
        }
        //methode pour afficher un titre
        public static void printHeading (String title){
            printSeperator(30);
            System.out.println(title);
            printSeperator(30);
        }
        //methode pour stopperle jeu le temps que le joueur fasse son choix
        public static void anythingToContinue(){
            System.out.println("\nEnter anything to continue ...");
            scanner.next();
        }
        //methode pour commencer le jeu
    public static void startGame(){
        boolean nameSet = false;
        String name;
        //affiche le titre
        clearConsole();
        printSeperator(40);
        printSeperator(30);
        System.out.println("Harry Potter");
        printSeperator(30);
        printSeperator(40);
        anythingToContinue();

        //demande le nom du joueur
        do {
            clearConsole();
            printHeading("What's your name");
            name = scanner.next();
            //demande au joueur s'il veut faire une correction
            clearConsole();
            printHeading("Your name is" + name + ".\nIs that correct ?");
            System.out.println("(1) Yes !");
            System.out.println("(2) No I want to change my name!");
            int input = readInt("->", 2);
            if (input == 1)
                nameSet = true;
        }while (! nameSet);
        // creer nouveau joueur objet avec le nom
        wizard= new Wizard(name);
        //game loop peut continuer
        isRunning = true;
        //start main game loop
        gameLoop();
    }
    //methode qui change la valeur du jeu basé sur xp du sorcier
    public static void checkAct(){

        //change act base sur xp
        if (charactere.xp >=10 && act ==1){
            //increment act et lieu
            act=2;
            place=1;
            //histoire
            Story.printFirstActOutro();
            //le joueur level up
            wizard.chooseTrait();
            //histoire
            Story.printSecondActIntro();
            //assigne nouvelles valeurs aux ennemies
            enemy[0]="Troll";
            enemy[1]="Basilic";
            enemy[2]="Dementor";
            enemy[3]="Voldemort & Peter pettigrow";
            enemy[4]="Dolores Ombrage";
            enemy[5]="Death Eaters";
            //asiigne nouvelles valeurs à encounters
            encounters[0]="Battle";
            encounters[1]="Battle";
            encounters[2]="Battle";
            encounters[3]="Battle";
            encounters[4]="Battle";
            encounters[5]="Battle";
            //guerie completement le wizard
            charactere.hp = charactere.maxHp;
        }else if (charactere.xp >=50 && act ==2){
            //increment act et lieu
            act=3;
            place=2;
            //histoire
            Story.printSecondActOutro();
            //le joueur level up
            wizard.chooseTrait();
            //histoire
            Story.printThirdActIntro();
        }else if (charactere.xp >=100 && act ==3){
            //increment act et lieu
            act=4;
            place=3;
            //histoire
            Story.printThirdActOutro();
            //le joueur level up
            wizard.chooseTrait();
            Story.printFourthActOutro();
            //guerie completement le wizard
            charactere.hp = charactere.maxHp;
            //derniere battle
            //finalBatttle()


        }
    }
    //methode pour calculer random encounter
    public static void randomEncounter(){
        int encounter=(int) (Math.random()*encounters.length);
        //appelle les differntes methodes
        if (encounters[encounter].equals("Battle")) {
            //randomBattle
        }else if (encounters[encounter].equals("Rest")){
            //takeRest
        }else {
            //shop
        }
    }
    // methode pour continuer journey
    public static void continueJourney(){
        //vérifier si acte doit être augmenté
        checkAct();
        //verifier si jeu n'est pas le dernier act
        if (act!=4)
            randomEncounter();

    }
    //affiche les informations les plus importantes du joueur
    public static void characterInfo(){
        clearConsole();
        printHeading("Character info");
        System.out.println(charactere.name +"\tHP: "+charactere.hp+ "/" + charactere.maxHp);
        printSeperator(20);
        //wizard xp adn gold
        System.out.println("XP:" + charactere.xp+"\tGold:" + wizard.gold);
        printSeperator(20);
        System.out.println("# of Potions"+ wizard.pots);
        printSeperator(20);
    }
    //creation  du shop
    public static void shop(){
        clearConsole();
        printHeading("A weird shop is on your way");
        int price =(int) (Math.random()*(10+wizard.pots*3)+10+ wizard.pots);
        System.out.println("Do you want to buy one ?\n(1) Yes\n(2) No");
        int input= readInt("->",2);
        if(input==1){
            clearConsole();
            if(wizard.gold>= price){
                printHeading("You bought a potion");
                wizard.pots++;
                wizard.gold-=price;
            }else{
                printHeading("You don't have enough money");
                anythingToContinue();
            }
        }
        //prendre du repos
        public static void takeRest(){
            clearConsole();
            if (wizard.restsLeft >=1){
                printHeading("Do you want to take rest ?("+ wizard.restsLeft+" rest left)");
                System.out.println("(1) Yes\n(2) No");
                input = readInt("->", 2);
                if (input==1){
                    clearConsole();
                    if (charactere.hp< charactere.maxHp){
                        int hpRestored=(int)(Math.random()*(charactere.xp/4+1)+10);
                        charactere.hp += hpRestored;
                        if (charactere.hp>charactere.maxHp)
                            charactere.hp = charactere.maxHp;
                            System.out.println("You took a rest and now you have" + hpRestored + "health");
                            wizard.restsLeft--;

                    }
                }else{
                    System.out.println("You don't need to rest");
                    anythingToContinue();
                }
            }
        }
    }
    //creer random battle
    public static void randomBattle(){
        clearConsole();
        printHeading("You encountered an enemy, you will have to fight it");
        anythingToContinue();
        //creer nouvel enemy avec random nom
        battle(new Enemy(enemy[(int)(Math.random()*enemy.length)],charactere.xp));
    }
    //main battle method
    public static void battle(Enemy enemy){
        //main battle loo^p
        while  (true){
            clearConsole();
            printHeading(enemy.name+"\nHP:"+enemy.hp+"/"+enemy.maxHp);
            printHeading(charactere.name+"\nHP:"+charactere.hp+"/"+charactere.maxHp);
            System.out.println("Choose an action");
            printSeperator(20);
            System.out.println("(1)Fight\n(2) Use Potion\n(3) Run away");
            int input =readInt("->",3);
            //reagit selon la reponse du joueur
            if (input==1) {
                //combat
                //calcule dommage
                int dmg=wizard.attack()-enemy.defend();
                int dmgTook=enemy.attack()-wizard.defend();
                //verifie que dommage n'est pas negatif
                if(dmgTook<0){
                    dmg-=dmgTook/2;
                    dmgTook=0;
                }
                if (dmg<0){
                    dmg=0;
                    wizard.hp -=dmgTook;
                    enemy.hp-=dmg;
                    clearConsole();
                    printHeading("Battle");
                    System.out.println("You dealt"+dmg + " damage to the" + enemy.name + ".");
                    printSeperator(15);
                    System.out.println("The" + enemy.name+ " dealt" + dmgTook+ " damage to you.");
                    anythingToContinue();
                    //verifie que le wizard est toujoirs en vie
                    if (wizard.hp<=0){
                        wizardDied();
                        break;
                    }else if (enemy.hp<=0){
                        clearConsole();
                        printHeading("You defeated the"+ enemy.name );
                        wizard.hp+=enemy.hp;
                        System.out.println("You earned"+ enemy.xp+ "XP");
                        boolean addRest= (Math.random()*5+1<=2.25);
                        int goldEarned= (int)(Math.random()*enemy.xp);
                        if (addRest){
                            wizard.restsLeft++;
                            System.out.println("You eardned an additional rest");
                        }
                        if (goldEarned>0){
                            wizard.gold+= goldEarned;
                            System.out.println("You collect"+ goldEarned+"gold from the"+ enemy.name+"'s corpse");
                        }
                        anythingToContinue();
                        break;
                    }
            }else if(input==2){
                    //utilise potion
                    clearConsole();
                    if (wizard.pots> 0 && charactere.hp < charactere.maxHp){
                        //wizard peut prendre la potion
                        //etre sur que le wizard veut prendre la potion
                        printHeading("Do you want to drink a potion ?("+wizard.pots +"left)");
                        System.out.println("(1)Yes\n(2) No");
                        input = readInt("->",2);
                        if (input==1){
                            //wizard la prend
                            charactere.hp=charactere.maxHp;
                            clearConsole();
                            printHeading("Ypu drink a potion, now your health is at"+ charactere.maxHp);
                            anythingToContinue();
                        }
                    }else {
                        //wizard ne peut pas prendre la potion
                        printHeading("You don't have any potions or you're don't need it");
                        anythingToContinue();
                    }
                }
            }else{
                //s'enfuie
                    clearConsole();
                    //chance de s'enfuir 20%
                if (Math.random()*10+1<=2.0){
                    printHeading("You ran away from the"+ enemy.name);
                    anythingToContinue();
                    break;
                }else {
                    printHeading("You didn't manage to run away");
                    int dmgTook=enemy.attack();
                    System.out.println("In your hurry you took" +dmgTook+" damage");
                    anythingToContinue();
                    //verifie si le wizard est toujoirs en vie
                    if (charactere.hp<=0)
                        wizardDied();
                }

                }
        }
    }
    //afficher le menu
    public static void printMenu(){
        clearConsole();
        printHeading("Menu");
        System.out.println("Choose an action");
        printSeperator(20);
        System.out.println("(1) Continue on your journey");
        System.out.println("(2) Character info");
        System.out.println("(3) Exit");
    }
    //final battle
    public static void finalBattle(){
        battle(new Enemy("Voldemort & Bellatrix Lestrange",300));
        Story.printEnd(wizard);
        isRunning=false;
    }
    //methode si le wizard est mort
    public static void wizardDied(){
        clearConsole();
        printHeading("You died ..");
        printHeading("You earned"+ charactere.xp +" XP on your journey!");
       isRunning=false;
    }
        //main game loop
    public static void gameLoop(){
        while(isRunning){
            printMenu();
            int input = readInt("->",3);
            if (input ==1)
                continueJourney();
            else if (input ==2)
                characterInfo();
            else
                isRunning = false;

        }
    }

    }




