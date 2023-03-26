package Modele;

import Console.GameLogic;

public class Wizard extends Charactere {
    //integers pour les points des offensives deffensives
    public int numOffensive, numDefensive;
    // diiferentes attaques et offensives
    public String[]defensive={"Strength", "Power","Might","Godlike Strength"};
    public String[] offensive={ "Heavy Bones", "Stoneskin","Scale Armor", "Holy Aura"};
    // specific constructor du wizard
    public Wizard (String name) {
        //calling constructor of superclass

        super(name, 100, 0);
        this.numOffensive=0;
        this.numDefensive=0;
        //le wizard choisit un trait quand il est créé
        chooseTrait();
    }
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



