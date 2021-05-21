package com.coda.transformation

object Partition {

  def main(args: Array[String]): Unit = {
    val list=List("India","China","Pakistan","Nepal","Bangladesh","Indonesia")
    val partitionedList=list.partition(each=>each.startsWith("I"))
    partitionedList._1.foreach(print)
    println()
    partitionedList._2.foreach(print)
  }
}
