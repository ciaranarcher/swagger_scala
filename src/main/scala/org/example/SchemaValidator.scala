package org.example

import java.io.File

import io.swagger.models.Swagger
import io.swagger.parser.SwaggerParser
import io.swagger.util.Json
import org.json4s.jackson.JsonMethods.{parse, compact, render}


object SchemaValidator extends App {
  override def main(args: Array[String]): Unit = {
    val schemaPath = {
      new File(".", "page_view.json").getCanonicalPath
    }

    val swaggerDefinition = {
      new SwaggerParser().read(schemaPath)
    }

    println("Swagger definition:")
    printSchema(schema = swaggerDefinition) // Print the Swagger, nicely.

    println("Page view schema definition:")
    println(extractJsonSchema(filePath = schemaPath, schemaName = "page_view")) // Print the JSON schema we are after
  }

  def extractJsonSchema(filePath: String, schemaName: String) = {

    val source = scala.io.Source.fromFile(filePath)
    val lines = try source.mkString finally source.close() // Slurp the whole file
    val json = parse(lines)

    // Read a particular schema in the Swagger definition
    val schema = json \\ "definitions" \\ schemaName

    compact(render(schema))
  }

  def printSchema(schema: Swagger) = {
    println("Pretty schema:")
    println(Json.pretty(schema))
  }
}
