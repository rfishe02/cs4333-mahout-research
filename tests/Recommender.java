
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
import java.io.File;
import java.io.IOException;

public class Recommender {

  public static void main(String[] args) {

    try {
      DataModel model = new FileDataModel(new File("./dataset.csv"));
      UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
      UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
      UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

      List<RecommendedItem> recommendations = recommender.recommend(2, 3);
      for (RecommendedItem recommendation : recommendations) {
        System.out.println(recommendation);
      }
    } catch(IOException ex) {
      ex.printStackTrace();
    } catch(TasteException ex2) {
      ex2.printStackTrace();
    }
    
  }

}
