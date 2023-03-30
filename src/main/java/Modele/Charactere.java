package Modele;

public abstract class Charactere {
    //attributs de tous les personnages
    public String name;
    public int maxHp, hp, xp;
    private Wand wand;

    //construction pour personnage
    public Charactere( String name, int maxHp, int xp, int hp){
        this.name=name;
        this.maxHp=maxHp;
        this.xp = xp;
        this.hp=maxHp;
    }

    public Charactere(String name, int maxHp, int xp) {
    }


    //methode des personnages
    public abstract int attack();
    public abstract int defend();

    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }
}
