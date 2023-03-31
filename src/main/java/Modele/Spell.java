package Modele;

public class Spell extends AbstractSpell {
    public String name;
    public int damage;
    public Spell(String name, int damage){
        this.name=name;
        this.damage=damage;
    }
    public String getName(){
        return name;
    }
    public int getDamage(){
        return damage;
    }
    public static Spell Leviosa() {
        return new Spell("Wingardium Leviosa", 10);
    }
    public static Spell Accio() {
        return new Spell("Accio", 20);
    }
    public static Spell Patronus() {
        return new Spell("Expecto Patronus ", 40);
    }
    public static Spell Expelliarnus() {
        return new Spell("Expelliarnus ", 80);
    }
    public static Spell Sectumsempra() {
        return new Spell(" Sectumsempra", 100);
    }
    }

