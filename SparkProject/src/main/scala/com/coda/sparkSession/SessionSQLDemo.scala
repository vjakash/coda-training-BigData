package com.coda.sparkSession

import org.apache.spark.sql.SparkSession

object SessionSQLDemo {
  def main(args: Array[String]): Unit = {
    val ss = SparkSession .builder()
      .appName("CodaDataJOB")
      .master("local[*]")
      .getOrCreate()

    val authDF = ss .read
      .option("header", "true")
      .csv("/Users/vj/bigdata-training/training-files/auth.csv")

    authDF.createOrReplaceTempView("AUTH_TABLE")

    val auaASADF = ss.sql("SELECT AUA,ASA FROM AUTH_TABLE")

    auaASADF.show()
  }
}
