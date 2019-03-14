
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;
import java.sql.*;

import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Suggestion extends HttpServlet {
   public void init() throws ServletException {

   }
   public void destroy() {

   }
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     response.setContentType("text/html");
     PrintWriter out = response.getWriter();

     try {

       int id = Integer.parseInt(request.getParameter("userID"));
       DataModel model = null;

       try {

         MysqlDataSource dataSource = new MysqlDataSource();
         dataSource.setUrl("jdbc:mysql://localhost:3306/cs4333");
         dataSource.setUser("dbuser");
         dataSource.setPassword("mariadb");

         dataSource.getConnection(); // Attempt to connect.

         model = new MySQLJDBCDataModel(dataSource,"history", "user_id", "item_id", "rating", null);

       } catch(Exception ex) {

         // Load backup data if the connection was unsuccessful.
         ServletContext context = request.getServletContext();
         model = new FileDataModel(new File(context.getRealPath("/WEB-INF/classes/dataset.csv")));

       }

       UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
       UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.05, similarity, model);
       UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

       List<RecommendedItem> recommendations = recommender.recommend(id,6);

       for (RecommendedItem recommendation : recommendations) {
         out.print(recommendation.getItemID()+" "+recommendation.getValue()+",");
       }

       try {

         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection(
         "jdbc:mysql://localhost:3306/cs4333",
         "dbuser",
         "mariadb"
         );

         Statement st = con.createStatement();
         out.print("\t"); // Separate sets.

         ResultSet rs = st.executeQuery("SELECT a.user_id, a.item_id, a.rating, b.name FROM history a, names b WHERE a.user_id = b.user_id AND a.user_id ="+id+" ORDER BY item_id");

         while(rs.next()) {
           out.print(id+" "+rs.getString("item_id")+" "+rs.getString("rating")+" "+rs.getString("name")+",");
         }
         out.print("|");

         long[] users = recommender.mostSimilarUserIDs(id,3);

         for(int a = 0; a < users.length; a++) {

           rs = st.executeQuery("SELECT a.user_id, a.item_id, a.rating, b.name FROM history a, names b WHERE a.user_id = b.user_id AND a.user_id ="+users[a]+" ORDER BY item_id");

           while(rs.next()) {
             out.print(users[a]+" "+rs.getString("item_id")+" "+rs.getString("rating")+" "+rs.getString("name")+",");
           }

           if(a < users.length-1) {
             out.print("|");
           }

         }

         st.close();

       } catch(Exception ex) {
         out.println("database select error");
       }

     } catch(Exception ex){
       out.println("error");
     }

   }
}
