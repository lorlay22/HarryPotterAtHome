package Modele;

import java.util.Scanner;

public class beginning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome in Harry Potter !");

        // Création du sorcier
        Wizard wizard = new Wizard();
        System.out.println("Creation of the wizard : " + wizard.getName());

        // Équipement de la baguette magique
        Wand wand = new Wand();
        wizard.setWand(wand);
        System.out.println("The magic wand of " + wizard.getName() + " is : " + wizard.getWand().getDescription());

        // Assignation de la maison par le Choipeau Magique
        SortingHat sortingHat = new SortingHat();
        String house = sortingHat.assignHouse(wizard);
        System.out.println("The sorting hat decide that " + wizard.getName() + " go the house " + house + " !");
    }
}

class Wizard {
    private String name;
    private Wand wand;

    public Wizard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the name of the wizard ?");
        name = scanner.nextLine();
    }

    public String getName() {
        return name;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public Wand getWand()
}
