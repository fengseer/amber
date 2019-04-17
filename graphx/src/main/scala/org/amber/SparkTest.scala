package org.amber

import org.apache.spark.sql.SparkSession


object SparkTest {

  def main(args: Array[String]): Unit = {


    val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .master("local")
      .config("spark.some.config.option", "some-value")
      .getOrCreate()

    import spark.implicits._

    // [{"age":12,"name":"h2"},{"age":11,"name":"h1"}]›
    val dataFrame = spark.read.json("/Users/sundays/dev/git/amber/graphx/src/main/resources/user.json")
    dataFrame.printSchema()
    dataFrame.createOrReplaceTempView("people")

    spark.sql("select * from people").show(10)


    spark.sql("select * from people").flatMap(row => row.getValuesMap(row.schema.fields.map(_.name))).foreach(println(_))
  }

}
