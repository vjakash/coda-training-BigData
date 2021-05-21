package com.coda.accumulator

import org.apache.spark.sql.SparkSession

object Broadcast {
  def main(args : Array[String]) = {
    //M
    val ss= SparkSession.builder()
      .appName("StateCounterJob")
      .master("local[*]")
      .getOrCreate()

    // States - Replace the state name with the state code using broadcast
    // Rajasthan - RH

    // M
    val sc = ss.sparkContext

    // W
    val textRDD = sc.textFile("/Users/vj/bigdata-training/training-files/auth.csv")
    val states = Map( ("Rajasthan","RH"),
      ("Andhra Pradesh","AN"),
      ("Tamil Nadu","TN"))
    val broadcastStates = sc.broadcast(states)

    // W
    val resStateColumnRDD = textRDD.map(each => each.split(",")(128))

    // W
    val accumulatorCalculationRDD = resStateColumnRDD.map(each => {
      if (broadcastStates.value.get(each)!=None) {
        broadcastStates.value.get(each)
      }else{
        each
      }
    })

    // M/W - result to the master
    accumulatorCalculationRDD.foreach(each => println(each))
  }
}
