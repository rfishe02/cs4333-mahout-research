// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

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
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import com.mysql.cj.jdbc.MysqlDataSource;

// Extend HttpServlet class
public class Suggestion extends HttpServlet {

   public void init() throws ServletException {
      // Do required initialization
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     int id = 2;
     int num = 3;

     response.setContentType("text/html");
     PrintWriter out = response.getWriter();

     DataModel model = null;

     try {
       MysqlDataSource dataSource = new MysqlDataSource();
       dataSource.setUrl("jdbc:mysql://localhost:3306/cs4333");
       dataSource.setUser("dbuser");
       dataSource.setPassword("mariadb");

       dataSource.getConnection();

       model = new MySQLJDBCDataModel(dataSource,"user_preferences", "user_id", "book_id", "preference", null);

     } catch(Exception e) {
       //out.println(e.getMessage()+"</br>");

       ServletContext context = request.getServletContext();
       String fullPath = context.getRealPath("/WEB-INF/classes/dataset.csv");

       model = new FileDataModel(new File(fullPath));
     }

     try {
       UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
       UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
       UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

       List<RecommendedItem> recommendations = recommender.recommend(id,num);

       for (RecommendedItem recommendation : recommendations) {
         out.println(recommendation.getItemID()+" "+recommendation.getValue()+",");
       }

     } catch(Exception ex2) {
       out.println(ex2.getMessage()+"");
     }

   }

   public void destroy() {
      // do nothing.
   }
}
