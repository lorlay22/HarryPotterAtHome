package Modele;

public class Enemy extends Charactere {
    //variable pour xp
    int charactereXp;
    public Enemy(String name, int charactereXp){
        super(name,(int) (Math.random()*charactereXp+ charactereXp/3+5), (int)(Math.random()*(charactereXp/4+2)+1));
        //assigne variable
        this.charactereXp=charactereXp;
    }
    @Override
    public int attack(){
        return (int)(Math.random()*(charactereXp/4+1)+xp/4+3) ;
    }
    @Override
    public int defend(){
        return  (int)(Math.random()*(charactereXp/4+1)+xp/4+3) ;
    }
}
