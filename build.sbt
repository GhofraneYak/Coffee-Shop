ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.14"

lazy val root = (project in file("."))
  .settings(
    name := "Coffee-Shop"
  )
val AkkaHttpVersion = "10.5.2"
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.8.3"
libraryDependencies += "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion
libraryDependencies += "com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttpVersion
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.8.6"
libraryDependencies += "org.json4s" %% "json4s-native" % "4.0.7"
libraryDependencies += "org.json4s" %% "json4s-ext" % "4.0.3"
libraryDependencies += "com.typesafe.akka" %% "akka-http-jackson" % "10.5.2"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.17.1"
// https://mvnrepository.com/artifact/com.github.jwt-scala/jwt-core
libraryDependencies += "com.github.jwt-scala" %% "jwt-core" % "10.0.1"
libraryDependencies += "com.typesafe.akka" %% "akka-http-testkit" % "10.2.10" % Test
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.16" % Test
