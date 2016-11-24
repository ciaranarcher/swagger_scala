# swagger_scala
Playground for Swagger API definitions and Scala JSON schema validation 

## Overview 
Takes a `swagger.json` [definition](http://swagger.io/specification/) and wrangles the `definitions` section into a valid [JSON schema](http://json-schema.org/).

Build as a POC to show that if you define your JSON payload schema with your swagger definition you can use it to validate JSON schemas for incoming requests etc.

Based on https://github.com/eclipsesource/play-json-schema-validator mostly.

## Helpful links
* http://www.jsonschemavalidator.net/ - validate your JSON schema.
* http://swagger.io/specification/ - swagger spec (note section on "Data Types").
* https://github.com/everit-org/json-schema - another parser worth a look. 

## Running
```
sbt run
```