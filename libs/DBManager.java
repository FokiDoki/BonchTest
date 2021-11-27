package libs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Formatter;
import java.util.Properties;
import libs.DBCore;
import libs.entitys.Human;

public class DBManager {
    DBCore DB;
    Formatter formatter;
    public DBManager(InputStream configStream){
        Properties props = new Properties();
        try {
            props.load(configStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");
        DB = new DBCore(url, username, password);
    }
    public void createEntity(Entity entity){
        this.DB.dbWrite("INSERT INTO Entity (hp) VALUES ("+String.valueOf(entity.getHP())+")");
        this.DB.dbGetLastID("Entity");
    }

    public void createHuman(Human Human){
        this.createEntity(Human);
        String lastEntityID = String.valueOf(this.DB.dbGetLastID("Entity"));
        this.DB.dbWrite("INSERT INTO HumanT (name, height, entity_id) VALUES ('"+Human.getName()+"',"+String.valueOf(Human.getHeight())+","+lastEntityID+");");
    }
    public void deleteDeadEntity(){
        this.DB.dbWrite("DELETE FROM Entity WHERE hp=0;");
    }
}
