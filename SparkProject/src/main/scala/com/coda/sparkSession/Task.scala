package com.coda.sparkSession

import org.apache.spark.sql.SparkSession

object Task {
  // SQL - In the auth.csv, can you count the number of people in each state
  // Team - A and B
  def main(args: Array[String]): Unit = {
    val ss = SparkSession .builder()
      .appName("CodaDataJOB")
      .master("local[*]")
      .getOrCreate()

    val authDF = ss .read
      .option("header", "true")
      .csv("/Users/vj/bigdata-training/training-files/auth.csv")

    authDF.createOrReplaceTempView("AUTH_TABLE")

    val auaASADF = ss.sql("SELECT res_state_name,count(*) FROM AUTH_TABLE group by res_state_name")

    auaASADF.show()
  }
}
