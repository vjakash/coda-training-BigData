package com.coda.transformation

object Slice {

  def main(args: Array[String]): Unit = {
    val list=List("India","China","Pakistan","Nepal","Bangladesh","Indonesia")
    list.slice(1,4).foreach(println)

  }
}
