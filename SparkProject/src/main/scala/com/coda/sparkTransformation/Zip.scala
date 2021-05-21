package com.coda.sparkTransformation

import org.apache.spark.sql.SparkSession

object Zip {

  def main(args: Array[String]): Unit = {
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

    val zippedRDD=districtRDD.zip(stateRDD)
   zippedRDD.foreach(each=>println(each._1+"---"+each._2))
  }
}
