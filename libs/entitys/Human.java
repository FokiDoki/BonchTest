package libs.entitys;
import libs.Entity;

public class Human extends Entity{
    protected int height;
    protected String name;
    public Human(){
        super(100);
        this.height = 180;
        this.name = "Human";
    }
    
    public Human(int height, String name, int hp){
        super(hp);
        this.height = height;
        this.name = name;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getHeight(){
        return this.height;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void say(String text){
        this.println(this.name+" says: "+text);
    }

}