// usage:  1. compile: javac -cp /usr/lib/oracle/18.3/client64/lib/ojdbc8.jar cust_find.java
//         2. execute: java -cp /usr/lib/oracle/18.3/client64/lib/ojdbc8.jar cust_find.java
import java.sql.*;
import oracle.jdbc.*;
import java.math.*;
import java.io.*;
import java.awt.*;
import oracle.jdbc.pool.OracleDataSource;

public class select_cust {

   public static void main (String args []) throws SQLException {
    try
    {

      //Connection to Oracle server. Need to replace username and
      //password by your username and your password. For security
      //consideration, it's better to read them in from keyboard.
      OracleDataSource ds = new oracle.jdbc.pool.OracleDataSource();
      ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
      Connection conn = ds.getConnection("mdara1", "nyyfan20");

      

      //Input Cid from keyboard
        BufferedReader  readKeyBoard;
        String          cid;
        String customer_name;
        String telephone_num;
        String visits_made;
        String last_visit_made;

        readKeyBoard = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter CID:");
        cid = readKeyBoard.readLine();
        

     
       

      // Query
      Statement stmt = conn.createStatement ();

      // Save result
        ResultSet rset;
        rset = stmt.executeQuery ("SELECT * FROM customers where cid ='"+cid+"'");

      // Print
      while (rset.next()) {
         System.out.print (rset.getString(1)+"  ");
         System.out.print (rset.getString(2)+"  ");
         System.out.print (rset.getString(3)+"  ");
         System.out.print (rset.getString(4)+"  ");
         System.out.print (rset.getString(5)+"  ");
         //System.out.println (rset.getString (6)+"  ");
      }
      //close
      rset.close();
      stmt.close();
      conn.close();

      
   }
     catch (SQLException ex) { System.out.println ("\n*** SQLException caught ***\n");}
     catch (Exception e) {System.out.println ("\n*** other Exception caught ***\n");}
  }
}
