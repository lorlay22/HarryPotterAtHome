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

    public double effectivePotions() {
        if (nom.equals("Hufflepuff")) {
            return 2;
        } else {
            return 1.0;
        }
    }

    public double effectiveSpell() {
        if (nom.equals("Slytherin")) {
            return 2;
        } else {
            return 1.0;
        }
    }

    public double damageResistant() {
        if (nom.equals("Gryffondor")) {
            return 2;
        } else {
            return 1.0;
        }
    }

    public double preciseSpell() {
        if (nom.equals("RavenClaw")) {
            return 2;
        } else {
            return 1.0;
        }
    }


    public String getName()  {
        String name = null;
        return name;}
}


