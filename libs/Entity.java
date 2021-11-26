package libs;


public class Entity {
    protected int hp;
    public Entity(){
        this.hp = 100;
    }

    public Entity(int hp){
        this.hp = hp;

    }

    public void setHP(int hp){
        this.hp = hp;
    }
    public int getHP(){
        return this.hp;
    }
    public void println(String text){
        System.out.println(text);
    }
}
