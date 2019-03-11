 import sbt._
 import Keys._
 
 logLevel := Level.Error

 ThisBuild / scalaVersion := "2.10.7"
 ThisBuild / version := "1.0"

 lazy val root = (project in file(".")).settings(
   name := "LeastSquares",
   libraryDependencies ++= Seq(
     "org.apache.hadoop" % "hadoop-core" % "1.2.1",
     "org.apache.spark" %% "spark-core" % "2.1.3",
     "org.apache.mahout" % "mahout-core" % "0.9",
     "org.apache.mahout" % "mahout-math" % "0.13.0",
     "org.apache.mahout" %% "mahout-math-scala" % "0.13.0",
     "org.apache.mahout" %% "mahout-spark" % "0.13.0",
     "org.scala-lang" % "scala-library" % "2.10.7"
   ) // Add dependencies to the root project
 )
