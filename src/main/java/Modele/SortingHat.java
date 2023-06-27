package Modele;
import java.util.Random;

public class SortingHat {
    public House assignRandomHouse(Wizard wizard){
        Random rand = new Random();
        int randomHouse = rand.nextInt(4)+1;

        switch (randomHouse){
            case 1 :
                return new House("Gryffondor");
            case 2 :
                return new House("Slytherin");
            case 3 :
                return new House("Ravenclaw");
            case 4 :
                return new House("Hufflepuff");
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        SortingHat hat = new SortingHat();
        Wizard wizard = new Wizard("Harry");
        House house = hat.assignRandomHouse(wizard);
        if (house != null) {
            System.out.println("Your house is " + house.getName() + " house");
        } else {
            System.out.println("Failed to assign a house to the wizard.");
        }
    }
}
