package com.coda.RDD

import org.apache.spark.{SparkConf, SparkContext}

object RDDInternalWorking {

  // RDD - Resilient Distributed Data
  // Transformation - RDD
  // Action - Scala Data Object
  // RDD - Partitions
  // RDD - Lazy Loaded
  // RDD are resilient - fault tolerant
  // RDD are immutable
  // RDD are distributed
  // RDD contains partitions and partitions internally contain data
  def main(args: Array[String]) = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    sparkContext.setCheckpointDir("/Users/vj/bigdata-training/training-files/checkpointDirectory")
    // Spark should always talk to HDFS file system
    val textFileRDD = sparkContext.textFile("/Users/vj/bigdata-training/training-files/auth.csv", 100)
    val mappedRDD = textFileRDD.map(each => {
      val columns = each.split(",")
      println(columns(3))
      (columns(3), columns(5))
    })
    val filteredRDD = mappedRDD.filter(each => !each._1.equals("740000"))
    //store is in checpointdir for later use ,so that it wont make lot of computaion by fetching evicted actions filteredRDD
    filteredRDD.checkpoint()
    filteredRDD.collect().foreach(each => println(each))
    sparkContext.stop()
  }
}
