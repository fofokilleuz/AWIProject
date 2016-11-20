name := """goldfish"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "mysql" % "mysql-connector-java" % "5.1.27",
  "com.google.apis" % "google-api-services-oauth2" % "v2-rev124-1.22.0"
)




fork in run := true

fork in run := true