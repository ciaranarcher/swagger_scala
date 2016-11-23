javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

lazy val root = (project in file(".")).
  settings(
      name := "swagger-scala",
      version := "1.0",
      scalaVersion := "2.12.0",
      retrieveManaged := true,
      libraryDependencies += "io.swagger" % "swagger-parser" % "1.0.23",
      libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.5.0",
      libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"
  )
