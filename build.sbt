ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.2"

lazy val root = (project in file("."))
  .settings(
    name := "Coffee-Shop"
  )

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.8.3"
libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.5.2"
libraryDependencies += "com.typesafe.akka" %% "akka-http-spray-json" % "10.5.2"
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.8.6"
libraryDependencies += "org.json4s" %% "json4s-native" % "4.0.7"
libraryDependencies += "org.json4s" %% "json4s-ext" % "4.0.3"
libraryDependencies += "com.typesafe.akka" %% "akka-http-jackson" % "10.5.2"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.17.1"
