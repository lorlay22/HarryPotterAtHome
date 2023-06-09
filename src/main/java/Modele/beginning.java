package Modele;

import java.util.Scanner;

public class beginning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome in Harry Potter !");

        // Création du sorcier
        String name = null;
        Wizard wizard = new Wizard(name);
        System.out.println("Creation of the wizard : " + wizard.getName());

        // Équipement de la baguette magique
        Wand wand = new Wand();
        wizard.setWand(wand);
        System.out.println("The magic wand of " + wizard.getName() + " is : " + wizard.getWand().getDescription());

        // Assignation de la maison par le Choipeau Magique
        SortingHat sortingHat = new SortingHat();
        House house = sortingHat.assignRandomHouse(wizard);
        System.out.println("The sorting hat decide that " + wizard.getName() + " go the house " + house + " !");
    }
}
