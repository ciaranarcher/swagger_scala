package org.example

import java.io.File

import io.swagger.models.Swagger
import io.swagger.parser.SwaggerParser
import io.swagger.util.Json

object SchemaValidator extends App {
  override def main(args: Array[String]): Unit = {
    val schemaPath = {
      new File(".", "page_view.json").getCanonicalPath
    }

    val swaggerDefinition = {
      new SwaggerParser().read(schemaPath)
    }

    printSchema(schema = swaggerDefinition)
  }

  def printSchema(schema: Swagger) = {
    println("Pretty schema:")
    println(Json.pretty(schema))
  }
}
