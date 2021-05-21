package com.coda.sparkActions

import org.apache.spark.{SparkConf, SparkContext}

object Count {

  // RDD - Resilient Distributed Data
  def main(args: Array[String]) = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val textFileRDD = sparkContext.textFile("/Users/vj/bigdata-training/training-files/auth.csv")

    val countedElements = textFileRDD.count()
    println(countedElements)
    //textFileRDD.foreach(each => println(each))
    sparkContext.stop()
  }
}
