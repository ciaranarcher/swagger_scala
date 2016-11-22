import sbt._
import sbt.Keys._

object Swagger_scalaBuild extends Build {

  lazy val swagger_scala = Project(
    id = "swagger_scala",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "swagger_scala",
      organization := "org.example",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.2"
      // add other settings here
    )
  )
}
