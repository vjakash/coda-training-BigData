package com.coda.sparkTransformation

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object Cartesian {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val textFileRDD = sparkContext.textFile("/Users/vj/bigdata-training/training-files/auth.csv")
    //res_state_name res_dist_name


    val ss = SparkSession .builder()
      .appName("CodaDataJOB")
      .master("local[*]")
      .getOrCreate()
    val authDF = ss .read
      .option("header", "true")
      .csv("/Users/vj/bigdata-training/training-files/auth.csv")
    authDF.createOrReplaceTempView("AUTH_TABLE")

    val districtRDD = ss.sql("SELECT res_dist_name FROM AUTH_TABLE").toJavaRDD
    val stateRDD=ss.sql("SELECT res_state_name FROM AUTH_TABLE").toJavaRDD

//    val districtRDD=districtDF.rdd.map(each=>(each.get(0)))
//    val stateRDD=stateDF.rdd.map(each=>(each.get(0)))

    val districtAndState=districtRDD.cartesian(stateRDD)
    districtAndState.foreach(each=>println(each._1+"-"+each._2))
    sparkContext.stop()
  }
}
