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

// Extend HttpServlet class
public class GetSuggestion extends HttpServlet {

   public void init() throws ServletException {
      // Do required initialization
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      ServletContext context = request.getServletContext();
      String fullPath = context.getRealPath("/WEB-INF/classes/dataset.csv");

      try {
        DataModel model = new FileDataModel(new File(fullPath));
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
        UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

        List<RecommendedItem> recommendations = recommender.recommend(2, 3);
        for (RecommendedItem recommendation : recommendations) {
          out.println(recommendation);
        }
      } catch(TasteException ex2) {
        ex2.printStackTrace();
      }

   }

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



   }

   public void destroy() {
      // do nothing.
   }
}
