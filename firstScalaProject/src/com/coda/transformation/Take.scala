package com.coda.transformation

object Take {

  def main(args: Array[String]): Unit = {
    val list=List("India","China","Pakistan","Nepal","Bangladesh","Indonesia")
    list.take(3).foreach(println)
  }
}
