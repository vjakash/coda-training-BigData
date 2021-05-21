package com.coda.transformation

object Reverse {

  def main(args: Array[String]): Unit = {
    val list=List("India","China","Pakistan","Nepal","Bangladesh","Indonesia")
    list.reverse.foreach(println)
  }
}
