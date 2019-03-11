 // Imports necessary for Spark based applications
 import org.apache.mahout.math._
 import org.apache.mahout.math.algorithms.regression._
 import org.apache.mahout.math.scalabindings._
 import org.apache.mahout.math.scalabindings.RLikeOps._
 import org.apache.mahout.math.drm._
 import org.apache.mahout.math.drm.RLikeDrmOps._
 import org.apache.mahout.sparkbindings._
 import collection._
 import JavaConversions._
 
 // Imports necessary for this application
 import scala.io.Source
 import scala.collection.mutable.ListBuffer;

 object LeastSquares extends App {
   override def main(args: Array[String]): Unit = {        
     implicit val mahoutCtx = mahoutSparkContext(
       masterUrl = "local",
       appName = "MahoutLocalContext"
     ) // Create a spark context for the application
        
     val data = getMatrix("data/Admission_Predict.csv")
     val drmData = drmParallelize(new DenseMatrix(data._1)) // Load onto cluster

     val drmX = drmData(::, 0 until (data._2 - 1)) // Extract features
     val drmY = drmData(::, (data._2 - 1) until data._2) // Extract target variable

     val model = new OrdinaryLeastSquares[Int]().fit(drmX, drmY)
     println(model.summary)
        
     mahoutCtx.stop() // End the context
   }  
   def getMatrix(filename : String) = {
     val lines = Source.fromFile(filename).getLines()
     lines.next() // Discard titles
     val arrays = lines.map(_.split(","))
   
     val list = new ListBuffer[Array[Double]];
     var ind = 0
    
     for(array <- arrays) {
       list += array.map(x => x.toDouble) // Convert elements to Array[Double]
     }
        
     val res = list.toArray // Convert the ListBuffer to an Array[Array[Double]]
     (res,res(0).length)  
  }
}
