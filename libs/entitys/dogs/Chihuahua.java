package libs.entitys.dogs;
import libs.entitys.Dog;
public class Chihuahua extends Dog{
    protected int isAngry;
    public Chihuahua(){
        super("RRRRRR", 2);
        this.isAngry = 1;
    }

    public Chihuahua(Boolean isAngry, String alias, int hp){
        super(alias, hp);
        this.setAngryStatus(isAngry);
    }

    public boolean getAngryStatus(){
        return this.isAngry==1;
    }
    public void setAngryStatus(Boolean isAngry){
        if (isAngry){
            this.isAngry = 1;
        } else {
            this.isAngry = 0;
        }
        
    }
    public void touch(){
        if (this.getAngryStatus()){
            this.println("*bite*");
        } else {
            this.setAngryStatus(true);
            this.println("*angry sounds*");
        }
    }
}