package com.coda.accumulator

import org.apache.spark.sql.SparkSession

object AccumulatorDemo {

  // Accumulator / Broadcast
  def main(args : Array[String]) = {
    // master
    val ss = SparkSession .builder()
      .appName("CodaDataJOB")
      .master("local[*]")
      .getOrCreate()

    // How many number of authentication rows are there for the State = Karnataka
    // using accumulator

    // master
    val sc = ss.sparkContext

    // master
    val sharedAccumulator = sc.longAccumulator("SharedAccumulator")

    // worker
    val textFileRDD = sc.textFile("/Users/vj/bigdata-training/training-files/auth.csv")

    // worker
    val mappedRDD = textFileRDD.map(each => {
      val columns = each.split(",")
//      if(columns.toList.indexOf("Karnataka")>=0)
//      println(columns.toList.indexOf("Karnataka"))
      if (columns(128).equals("Karnataka"))
        sharedAccumulator.add(1L)
    })

    // collected data will come to the master
    mappedRDD.collect()

    // master
    println("Total Count : " + sharedAccumulator.value)
  }

}
