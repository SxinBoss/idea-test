package db;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import org.apache.commons.configuration.tree.ConfigurationNode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by merey on 2016-05-15.
 */
public class SxinPool {
    private static Map<Connection,Integer> poolMap=null;
    static {

        System.out.println("SxinPool static");
     //   String url = "jdbc:mysql://localhost:3306/myweb?"
       //         + "user=root&password=qwert&useUnicode=true&characterEncoding=UTF8";
        String url="jdbc:sqlserver://121.40.209.140,2833; DatabaseName=ESCN";
        /*
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            SQLServerDriver sqlDriver = new SQLServerDriver();
            Properties infoPro = new Properties();
            infoPro.setProperty("userName","ECM");
            infoPro.setProperty("userPwd","ECM");

            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            poolMap = new HashMap<Connection, Integer>();
            for(int i=0;i<2;i++){
                poolMap.put(sqlDriver.connect(url,infoPro),0);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }*/
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
