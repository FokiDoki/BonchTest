
import libs.entitys.*;
import libs.entitys.dogs.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import libs.DBManager;



public class program{
    public static void main(String[ ] args){
        try {
            final String dir = System.getProperty("user.dir");
            System.out.println("current dir = " + dir);
            DBManager DB = new DBManager(new FileInputStream("C:\\projects\\BonchTest4\\src\\main\\java\\database_config.properties"));
            Human egor = new Human(160, "Egor", 55);
            DB.createHuman(egor);
            Human den = new Human(190, "Den", 0);
            DB.createEntity(den);
            DB.deleteDeadEntity();
            egor.say("Hello world");

            Chihuahua rrr = new Chihuahua(false, "RRR", 2);
            System.out.println(rrr.getAlias());
            rrr.touch();
            rrr.touch();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        

    }
}