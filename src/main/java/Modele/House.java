package Modele;

public class House {

        private String nom;

        public House(String nom) {
            this.nom = nom;
        }
    House Gryffondor = new House("Gryffondor");
    House RavenClaw = new House("Ravenclaw");
    House Hufflepuff = new House("Hufflepuff");
    House Slytherin = new House("Slytherin");


        @Override
        public String toString() {
            return "Maison{" +
                    "nom='" + nom + '\'' +
                    '}';
        }

    public double efficacitePotions() {
        if (nom.equals("Hufflepuff")) {
            return 1.5;
        } else {
            return 1.0;
        }
    }

    public double degatsSorts() {
        if (nom.equals("Slytherin")) {
            return 1.5;
        } else {
            return 1.0;
        }
    }

    public double resistanceDegats() {
        if (nom.equals("Gryffondor")) {
            return 1.5;
        } else {
            return 1.0;
        }
    }

    public double precisionSorts() {
        if (nom.equals("RavenClaw")) {
            return 1.5;
        } else {
            return 1.0;
        }
    }


}


