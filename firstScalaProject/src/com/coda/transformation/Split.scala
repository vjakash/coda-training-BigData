package com.coda.transformation

object Split {

  def main(args: Array[String]): Unit = {
    val list=List("India","China","Pakistan","Nepal","Bangladesh","Indonesia")
    list.splitAt(3)._1.foreach(print)
    println()
    list.splitAt(3)._2.foreach(print)
  }
}
