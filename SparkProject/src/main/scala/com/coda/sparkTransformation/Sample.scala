package com.coda.sparkTransformation

import org.apache.spark.{SparkConf, SparkContext}

object Sample {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val textFileRDD = sparkContext.textFile("/Users/vj/bigdata-training/training-files/auth.csv")
                      .sample(false,0.1)
                      .foreach(each=>println(each))
  }
}
