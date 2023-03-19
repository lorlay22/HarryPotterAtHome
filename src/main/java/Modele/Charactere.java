package Modele;

public abstract class Charactere {
    //attributs de tous les personnages
    public String name;
    public int maxHp, hp, xp;
    //construction pour personnage
    public Charactere( String name, int maxHp, int x){
        this.name=name;
        this.maxHp=maxHp;
        this.xp = xp;
        this.hp=maxHp;
    }
    //methode des personnages
    public abstract int attack();
    public abstract int defend();
}
