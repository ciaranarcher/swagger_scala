package org.example

import java.io.File

import com.eclipsesource.schema.SchemaType
import play.api.libs.json._


object SchemaValidator extends App {
  override def main(args: Array[String]): Unit = {
    val schemaPath = {
      /*
       * Change to swagger_with_nesting.json if you want to see a failure due to a nested reference (context)
       * being missing from the schema.
       */
      new File(".", "swagger.json").getCanonicalPath
    }

    println("Page view schema definition:")
    val schemaJson = extractJsonSchema(filePath = schemaPath, schemaName = "page_view")

    val schema = Json.fromJson[SchemaType](schemaJson).get
    val validator = new com.eclipsesource.schema.SchemaValidator

    val documentPath = {
      new File(".", "/samples/page_view.json").getCanonicalPath
    }

    val document = scala.io.Source.fromFile(documentPath)
    val documentData = try document.mkString finally document.close()

    val tmpJsonValue: JsValue = Json.parse(documentData)
    val result = validator.validate(schema, tmpJsonValue)

    result match {
      case _: JsError => println(s"\n\nDocument is invalid: ${result}\n")
      case default => println("\n\nDocument is valid.\n")
    }
  }

  def extractJsonSchema(filePath: String, schemaName: String) = {
    val source = scala.io.Source.fromFile(filePath)
    val lines = try source.mkString finally source.close() // Slurp the whole file
    val json: JsValue = Json.parse(lines)

    // Read a particular schema in the Swagger definition
     (json \ "definitions" \ schemaName).get
  }
}
