package com.coda.sparkActions

import org.apache.spark.{SparkConf, SparkContext}

object Partitioning {
  // RDD - Resilient Distributed Data
  def main(args: Array[String]) = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val textFileRDD = sparkContext.textFile("/Users/vj/bigdata-training/training-files/auth.csv", 100)

    textFileRDD.saveAsTextFile("/Users/vj/intellij_projects/spark-files/partitionSavedAsTextFile")
    sparkContext.stop()
    // Spark should always talk to HDFS file system
    // part-00000
    // part-00001
  }

}
