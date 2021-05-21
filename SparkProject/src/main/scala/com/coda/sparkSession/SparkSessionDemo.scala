package com.coda.sparkSession

import org.apache.spark.sql.SparkSession

object SparkSessionDemo {

  // Dataframe is also immutable in nature
  def main(args: Array[String]): Unit = {

    val ss = SparkSession .builder()
                          .appName("CodaDataJOB")
                          .master("local[*]")
                          .getOrCreate()
    // Always write the function with a proper indentation
    val authDF = ss .read
                    .option("header", "true")
                    .csv("/Users/vj/bigdata-training/training-files/auth.csv")
    val auaASALicenseDF = authDF.select("aua", "sa", "license_id")
    auaASALicenseDF.show(100)
//    authDF.show()
  }
}
