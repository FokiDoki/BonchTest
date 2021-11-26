package libs.entitys;
import libs.Entity;

public class Dog extends Entity{
    protected String alias;

    public Dog(){
        super(25);
        this.alias = "My Dog";
    }

    public Dog(String alias, int hp){
        super(hp);
        this.alias = alias;
    }

    public void setAlias(String alias){
        this.alias = alias;
    }
    public String getAlias(){
        return this.alias;
    }
    public void woof(){
        this.println("woof!");
    }
}