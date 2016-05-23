package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by merey on 2016-05-15.
 */
public class SxinPool {
    private static Map<Connection,Integer> poolMap=null;
    static {

        System.out.println("SxinPool static");
        String url = "jdbc:mysql://localhost:3306/myweb?"
                + "user=root&password=qwert&useUnicode=true&characterEncoding=UTF8";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            poolMap = new HashMap<Connection, Integer>();
            for(int i=0;i<2;i++){
                poolMap.put(DriverManager.getConnection(url),0);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        for (Map.Entry<Connection, Integer> entry : poolMap.entrySet()) {
            if (entry.getValue()==0) {
                entry.setValue(1);
                return entry.getKey();
            }
        }
        return null;
    }


    public static void retConnection(Connection conn){
        for (Map.Entry<Connection, Integer> entry : poolMap.entrySet()) {
            if (entry.getKey().equals(conn)) {
                entry.setValue(0);
            }
        }
    }
}
