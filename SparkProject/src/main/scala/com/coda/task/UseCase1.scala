package com.coda.task

import org.apache.spark.sql.SparkSession

object UseCase1 {

  def main(args : Array[String]) = {
    // master
    val ss = SparkSession .builder()
      .appName("CodaDataJOB")
      .master("local[*]")
      .getOrCreate()

//    In the sales.csv attached, for the ProductLine=“Golf Equipment” how many ProductType are there ?
//      Write the SparkJOB using RDD transformations for the above problem statement.

    // master
    val sc = ss.sparkContext

    // master
    val sharedAccumulator = sc.longAccumulator("SharedAccumulator")

    // worker
    val textFileRDD = sc.textFile("/Users/vj/bigdata-training/training-files/sales.csv")

    // worker
    val mappedRDD = textFileRDD.map(each => {
      val columns = each.split(",")
//      println(columns.toList)
      if (columns(1).equals("Golf Equipment"))
        sharedAccumulator.add(1L)
    })

    // collected data will come to the master
    mappedRDD.collect()

    // master
    println("Total ProductType : " + sharedAccumulator.value)
  }

}
