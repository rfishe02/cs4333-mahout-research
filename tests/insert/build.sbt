import sbt._
import Keys._

logLevel := Level.Error

ThisBuild / scalaVersion := "2.10.7"
ThisBuild / version := "1.0"

lazy val root = (project in file(".")).settings(
  name := "InsertDB",
  libraryDependencies ++= Seq(
    "mysql" % "mysql-connector-java" % "8.0.15",
    "org.scala-lang" % "scala-library" % "2.10.7",
  )
)
