package Modele;

public abstract class AbstractSpell {
    public String name;
    public int damage;
    public void Spell(String name, int damage){
        this.name=name;
        this.damage=damage;
    }
    public String getName(){
        return name;
    }
    public int getDamage(){
        return damage;
    }
}
