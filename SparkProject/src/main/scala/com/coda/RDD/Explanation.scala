package com.coda.RDD

import org.apache.spark.{SparkConf, SparkContext}

object Explanation {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val textFileRDD = sparkContext.textFile("/Users/vj/bigdata-training/training-files/auth.csv")
    val mappedRDD = textFileRDD.map(each => {
      val columns = each.split(",")
      println(columns(3)) //print only on executing collect()
      (columns(3), columns(5))
    })

    mappedRDD.collect()
    sparkContext.stop()

  }
}
