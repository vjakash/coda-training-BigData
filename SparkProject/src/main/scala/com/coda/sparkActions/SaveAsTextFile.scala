package com.coda.sparkActions

import org.apache.spark.{SparkConf, SparkContext}

object SaveAsTextFile {
  // RDD - Resilient Distributed Data
  def main(args: Array[String]) = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val textFileRDD = sparkContext.textFile("/Users/vj/bigdata-training/training-files/auth.csv")

    textFileRDD.saveAsTextFile("/Users/vj/intellij_projects/spark-files/savedAsTextFile")
    sparkContext.stop()
  }
}
