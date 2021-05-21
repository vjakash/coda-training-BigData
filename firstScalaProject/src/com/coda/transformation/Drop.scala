package com.coda.transformation

object Drop {

  def main(args: Array[String]): Unit = {
    val list=List("India","China","Pakistan","Nepal","Bangladesh","Indonesia")
    list.drop(3).foreach(println)
  }
}
