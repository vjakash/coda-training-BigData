package com.coda

import org.apache.spark.{SparkConf, SparkContext}

object SparkDataJob {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val textFileRDD = sparkContext.textFile("/Users/vj/bigdata-training/training-files/auth.csv")
    textFileRDD.foreach(each => println(each))
    sparkContext.stop()
  }
}
