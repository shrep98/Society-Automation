package database;



import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection connect()
{
Connection conn = null;

try
{
 Class.forName ("com.mysql.jdbc.Driver").newInstance ();
 conn = DriverManager.getConnection("jdbc:mysql://localhost/society automation","root","aj007");
 }
 catch(Exception e)
 {
     e.printStackTrace();
 }
 return conn;
}

}
