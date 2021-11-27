package libs;

import java.util.ArrayList;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
public class DBCore<T>{
    private String url;
    private String username;
    private String password;
    private ArrayList resultList = new ArrayList();

    public String driver = "com.mysql.jdbc.Driver";

    public DBCore(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }
    public DBCore(String url, String username, String password, String driver){
        this.url = url;
        this.username = username;
        this.password = password;
        this.driver = driver;
    }
    public ArrayList dbRead(String Query, Class <T> object){
        
        try{
            Class.forName(this.driver);
            Connection connection = DriverManager.getConnection(this.url, this.username, this.password);
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(Query);
                while (result.next()){
                    try {
                        resultList.add(serialize(result, object));
                    } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                            | InvocationTargetException | NoSuchMethodException | SecurityException
                            | NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                }
                result.close();
                statement.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }
    public void dbWrite(String Query){
        try{
            Class.forName(this.driver);
            Connection connection = DriverManager.getConnection(this.url, this.username, this.password);
                Statement statement = connection.createStatement();
                statement.executeUpdate(Query);
                statement.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public int dbGetLastID(String database){
        try{
            Class.forName(this.driver);

            Connection connection = DriverManager.getConnection(this.url, this.username, this.password);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("Select max(id) from "+database);
            result.next();
            return result.getInt("max(id)");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    private <T> T serialize (ResultSet result, Class <T> object) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, SQLException {
        T t = object.getDeclaredConstructor().newInstance();
        for (var item: object.getFields()) {
            object.getDeclaredField(item.getName()).set(t, result.getObject(item.getName()));
        }
        return t;
    }
}
