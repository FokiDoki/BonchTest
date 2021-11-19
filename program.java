
import libs.entitys.*;
import libs.entitys.dogs.*;




public class program{
    public static void main(String[ ] args){
        Human egor = new Human(160, "Egor", 55);
        egor.say("Hello world");
        Chihuahua rrr = new Chihuahua(false, "RRR", 2);
        System.out.println(rrr.getAlias());
        rrr.touch();
        rrr.touch();
    }
}