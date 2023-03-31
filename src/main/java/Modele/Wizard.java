package Modele;

import Console.GameLogic;

import java.util.Scanner;
import java.util.ArrayList;

public class Wizard extends Charactere {
    public String name;

    private Wand wand;
    private int level;
    private ArrayList<String> knownSpells;
    private String Spell;


    public Wizard(String name) {
        super(name, 100, 0);
        this.name = name;
        this.numOffensive=0;
        this.numDefensive=0;
        //stast en plus
        this.gold = 5;
        this.restsLeft=1;
        this.pots=0;
        //le wizard choisit un trait quand il est créé
        chooseTrait();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the name of the wizard ?");
        this.name = scanner.nextLine();
        level = 1;
        knownSpells = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }



        public void levelUp() {
            level++;
            knownSpells();
        }

        public void knownSpells() {
            // Choisissez un nouveau sort à apprendre en fonction du niveau actuel du wizard
            String newSpell = getSpellForLevel(level);
            knownSpells.add(newSpell);
            System.out.println("Wizard a appris un nouveau sort: " + newSpell);
        }

        private String getSpellForLevel(int level) {

            switch (level) {
                case 2:
                    return "Spell 2";
                case 3:
                    return "Spell 3";
                case 4:
                    return "Spell 4";
                // etc.
                default:
                    return "Aucun nouveau sort n'est disponible pour ce niveau.";
            }
        }

        public void displayLearnedSpells() {
            System.out.println("Sorts appris:");
            for (String spell : knownSpells{
                System.out.println("- " + Spell);
            }
        }





    //integers pour les points des offensives deffensives
    public int numOffensive, numDefensive;
    //stats du wizard en plus
    public int gold;
    public int restsLeft;
    public int pots;
    // diiferentes attaques et offensives
    public String[]defensive={"Strength", "Power","Might","Godlike Strength"};
    public String[] offensive={ "Heavy Bones", "Stoneskin","Scale Armor", "Holy Aura"};
    // specific constructor du wizard

    // les methodes specifiques du wizard

    @Override
    public int attack() {

        return (int) (Math.random()*(xp/4+numOffensive*3+3)+xp/10+numOffensive*2+numOffensive+1);

    }

    @Override
    public int defend() {
        return (int) (Math.random()*(xp/4+numDefensive*3+3)+xp/10+numDefensive*2+numDefensive+1);
    }
    // wizard choisit un trait pour chaque skill path
    public void chooseTrait() {
        //pas sure de ces 2 lignes
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose a trait");
        System.out.println("(1)" + offensive[numOffensive]);
        System.out.println("(2)" + defensive[numDefensive]);
        //wizard fait son choix
        int input = GameLogic.readInt("->", 2);
        GameLogic.clearConsole();
        //actions selon choix
        if (input == 1) {
            GameLogic.printHeading(" You chose" + offensive[numOffensive] );
            numOffensive++;
        } else {
            GameLogic.printHeading(" You chose" + defensive[numDefensive] );
            numDefensive++;
        }
        GameLogic.anythingToContinue();
    }


    }



