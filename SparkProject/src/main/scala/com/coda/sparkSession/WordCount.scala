package com.coda.sparkSession
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}
object WordCount {

  def main(args: Array[String]): Unit = {
    val ss = SparkSession .builder()
      .appName("CodaDataJOB")
      .master("spark://Vijays-MacBook-Pro.local:7077")
      .getOrCreate()

//    val sc = ss.sparkContext
//
//    val textFileRDD = sc.textFile("/Users/vj/bigdata-training/training-files/wordcount.txt")
//
//    val flatMappedData = textFileRDD.flatMap(each => each.split(" "))
//
//    val manualOneRDD = flatMappedData.map(each => (each,1))
//
//    val finalOutputRDD = manualOneRDD.reduceByKey((x,y) => x+y)
//
//    finalOutputRDD.foreach(println)

    ss.sparkContext
      .textFile("/Users/vj/bigdata-training/training-files/wordcount.txt")
      .flatMap(each => each.split(" "))
      .map(each => (each,1))
      .reduceByKey(_+_)
      .foreach(println)
  }
}
