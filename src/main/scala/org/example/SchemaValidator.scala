package org.example

import java.io.File

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

    println("Pretty schema:")
    println(Json.pretty {
      swaggerDefinition
    })
  }
}
