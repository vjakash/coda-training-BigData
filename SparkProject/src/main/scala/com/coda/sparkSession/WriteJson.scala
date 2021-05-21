package com.coda.sparkSession

import org.apache.spark.sql.SparkSession

object WriteJson {
  def main(args: Array[String]): Unit = {
    val ss = SparkSession .builder()
      .appName("CodaDataJOB")
      .master("local[*]")
      .getOrCreate()
    val authDF = ss .read
      .option("header", "true")
      .csv("/Users/vj/bigdata-training/training-files/auth.csv")
    val auaASALicenseDF = authDF.select("aua", "sa", "license_id")
    auaASALicenseDF.write.json("/Users/vj/bigdata-training/training-files/writtenFiles/JSONFile")
    auaASALicenseDF.show(100)

  }
}
