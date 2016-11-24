javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

resolvers += "emueller-bintray" at "http://dl.bintray.com/emueller/maven"

lazy val root = (project in file(".")).
  settings(
      name := "swagger-scala",
      version := "1.0",
      scalaVersion := "2.11.8",
      retrieveManaged := true,
      libraryDependencies += "io.swagger" % "swagger-parser" % "1.0.23",
      libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.5.0",
      libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test",
      libraryDependencies += "com.eclipsesource" %% "play-json-schema-validator" % "0.8.5"
  )
