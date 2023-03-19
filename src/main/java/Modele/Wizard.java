package Modele;

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
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }
    // wizard choisit un trait pour chaque skill path
    public void chooseTrait() {
        //pas sure de ces 2 lignes
        Wizard.clearConsole();
        Wizard.printHeading("Choose a trait");
        System.out.println("(1)" + offensive[numOffensive]);
        System.out.println("(2)" + defensive[numDefensive]);
        //wizard fait son choix
        int input = Wizard.readInt("->", 2);
        Wizard.clearConsole();
        //actions selon choix
        if (input == 1) {
            Wizard.printHeading(" You chose" + offensive[numOffensive] +);
            numOffensive++;
        } else {
            Wizard.printHeading(" You chose" + defensive[numDefensive] +);
            numDefensive++;
        }
        Wizard.anythingToContinue();
    }


    }



