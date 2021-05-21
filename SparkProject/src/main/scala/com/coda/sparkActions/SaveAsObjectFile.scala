package com.coda.sparkActions

import org.apache.spark.{SparkConf, SparkContext}

object SaveAsObjectFile {
  // RDD - Resilient Distributed Data
  // Transformation - RDD
  // Action - Scala Data Object
  def main(args: Array[String]) = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val textFileRDD = sparkContext.textFile("/Users/vj/bigdata-training/training-files/auth.csv")

    val mappedRDD = textFileRDD.map(each => {
      val columns = each.split(",")
      (columns(3), columns(5))
    })
    // New directory path every time
    mappedRDD.saveAsObjectFile("/Users/vj/intellij_projects/spark-files/mappedRDD-ObjectFile")

    //   textFileRDD.saveAsObjectFile("/Users/vj/intellij_projects/spark-files/savedAsObjectFile")
    sparkContext.stop()
  }
}
