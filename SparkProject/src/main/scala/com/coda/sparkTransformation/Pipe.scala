package com.coda.sparkTransformation

import org.apache.spark.{SparkConf, SparkContext}

object Pipe {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val textFileRDD = sparkContext.textFile("/Users/vj/bigdata-training/training-files/auth.csv")

    textFileRDD.pipe("ls -l").foreach(param=>println(param))
    sparkContext.stop()
  }
}
