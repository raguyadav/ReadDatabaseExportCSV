name := "ReadingDatabaseAndPrintingCSVFile"

version := "1.0"

scalaVersion:= "2.10.5"

libraryDependencies ++=  Seq(
  "com.typesafe" % "config" % "1.2.0",
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "mysql" % "mysql-connector-java" % "5.1.34"
  )