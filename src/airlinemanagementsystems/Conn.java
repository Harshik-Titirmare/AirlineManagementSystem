package airlinemanagementsystems;
import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
  public Conn(){
      
      try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem", "root" , "Harshik786#@tit");
          s = c.createStatement();
      }
      
      catch(Exception e) {
          e.printStackTrace();
      }
      
  }

    
  
}
