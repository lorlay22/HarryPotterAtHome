package Modele;
import java.util.Random;

public class SortingHat {
    public House assignRandomHouse(){
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
        SortingHat hat = new SortingHat();
        House house = hat.assignRandomHouse();
        System.out.println("Your house is" + house.getName()+ "house");
    }
}
