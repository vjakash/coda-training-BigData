package com.coda.sparkSession

import org.apache.spark.sql.SparkSession

object WriteText {
  def main(args: Array[String]): Unit = {
    val ss = SparkSession .builder()
      .appName("CodaDataJOB")
      .master("local[*]")
      .getOrCreate()
    val authDF = ss .read
      .option("header", "true")
      .csv("/Users/vj/bigdata-training/training-files/auth.csv")
    val auaASALicenseDF = authDF.select("aua")

    //text file supports only single column
    auaASALicenseDF.write.text("/Users/vj/bigdata-training/training-files/writtenFiles/TextFile")
    auaASALicenseDF.show(100)

  }
}
