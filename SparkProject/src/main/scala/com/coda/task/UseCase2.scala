package com.coda.task

import org.apache.spark.sql.SparkSession

object UseCase2 {
  def main(args : Array[String]) = {
    // master
    val ss = SparkSession .builder()
      .appName("CodaDataJOB")
      .master("local[*]")
      .getOrCreate()

    //    In the sales.csv attached, What is the total revenue for the “Retailer Country” = France ?
    //      Solve the above problem using dataframe. Fetch the Retailer Country from sales1.csv and revenue count from another sales2.csv
    //      and compute the revenue by joining them. Sales1.csv and Sales2.csv are both identical copies.e are there ?

    // master
    val sc = ss.sparkContext

    val salesDF = ss .read
      .option("header", "true")
      .csv("/Users/vj/bigdata-training/training-files/sales.csv")

    salesDF.createOrReplaceTempView("SALES_TABLE")
  ss.sql("select * from SALES_TABLE").show();
    val auaASADF = ss.sql("SELECT SUM(Revenue) FROM SALES_TABLE WHERE `Retailer country`='France'")

    auaASADF.show()

  }
}
