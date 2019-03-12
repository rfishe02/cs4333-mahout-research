
import java.sql.*;
import java.util.Random;

public class InsertDB {

  public static void main (String[] args){

    Random rand = new Random();
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(
      "jdbc:mysql://localhost:3306/cs4333",
      "dbuser",
      "mariadb"
      );

      Statement st = con.createStatement();
      int userID;
      int itemID;
      int rating;

      for(int i = 0; i < 500; i++) {
        userID = rand.nextInt(100)+1;
        itemID = rand.nextInt(30)+1;
        rating = rand.nextInt(5);
        st.executeUpdate("INSERT INTO history(user_id,item_id,rating) VALUES ("+userID+","+itemID+","+rating+")");
      }

      con.close();

    } catch(Exception ex) {
      System.out.println(ex.getMessage());
    }
  }

}
