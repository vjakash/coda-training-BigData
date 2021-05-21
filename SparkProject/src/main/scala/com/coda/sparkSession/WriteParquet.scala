package com.coda.sparkSession

import org.apache.spark.sql.SparkSession

object WriteParquet {
  def main(args: Array[String]): Unit = {
    val ss = SparkSession .builder()
      .appName("CodaDataJOB")
      .master("local[*]")
      .getOrCreate()
    val authDF = ss .read
      .option("header", "true")
      .csv("/Users/vj/bigdata-training/training-files/auth.csv")
    val auaASALicenseDF = authDF.select("aua", "sa", "license_id")
    auaASALicenseDF.write.parquet("/Users/vj/bigdata-training/training-files/writtenFiles/ParquetFile")
    auaASALicenseDF.show(100)

  }
}
