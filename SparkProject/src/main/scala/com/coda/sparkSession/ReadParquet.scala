package com.coda.sparkSession

import org.apache.spark.sql.SparkSession

object ReadParquet {
  def main(args: Array[String]): Unit = {

    val ss = SparkSession .builder()
      .appName("CodaDataJOB")
      .master("local[*]")
      .getOrCreate()
    // parquet / orc => efficient storing of data
    val authDF = ss .read
      .option("header", "true")
      .parquet("/Users/vj/bigdata-training/training-files/writtenFiles/ParquetFile")
    authDF.show()
  }
}
