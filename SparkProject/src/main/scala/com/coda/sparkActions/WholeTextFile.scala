package com.coda.sparkActions

import org.apache.spark.{SparkConf, SparkContext}

object WholeTextFile {
  def main(args: Array[String]) = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val wtfRDD = sparkContext.wholeTextFiles("/Users/vj/bigdata-training/training-files")

    wtfRDD.foreach(each => println(each._1))
    wtfRDD.foreach(each => println(each._2))
    sparkContext.stop()
  }

}
