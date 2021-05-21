package com.coda.sparkActions

import org.apache.spark.{SparkConf, SparkContext}

object Take {
  // RDD - Resilient Distributed Data
  def main(args: Array[String]) = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val textFileRDD = sparkContext.textFile("/Users/vj/bigdata-training/training-files/auth.csv")

    val takenElements = textFileRDD.take(5)
    takenElements.foreach(each => {
      val cols = each.split(",")
      println(cols(1) + "-" + cols(4))
    })
    //textFileRDD.foreach(each => println(each))
    sparkContext.stop()
  }
}
