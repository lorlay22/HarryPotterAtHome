package Console;
import Modele.Wizard;

import java.util.Scanner;
import java.util.Stack;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    static  Wizard wizard;

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
        }

    }




