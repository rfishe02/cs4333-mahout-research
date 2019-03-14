
import java.sql.*;
import java.util.Random;
import java.io.*;
import java.util.HashSet;

public class InsertDB {

  public static void main (String[] args){

    HashSet<String> set = new HashSet<>();
    Random rand = new Random();
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(
      "jdbc:mysql://localhost:3306/cs4333",
      "dbuser",
      "mariadb"
      );

      PrintWriter pw = new PrintWriter(new FileWriter("dataset.csv"));
      Statement st = con.createStatement();
      int itemID;
      int rating;

      for(int i = 1; i <= 16; i++) {

        for(int j = 0; j < 12; j++) {

          itemID = rand.nextInt(16)+1;
          rating = rand.nextInt(5)+1;

          if(!set.contains(i+","+itemID)) {
            st.executeUpdate("INSERT INTO history(user_id,item_id,rating) VALUES ("+i+","+itemID+","+rating+")");
            pw.write(i+","+itemID+","+rating+"\n");

            set.add(i+","+itemID);
          }

        }

      }

      pw.close();
      con.close();

    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }

}
