package com.coda.transformation

object Map {
  def main(args: Array[String]): Unit = {
    val list=List("India","China","Pakistan","Nepal","Bangladesh","Indonesia")
    list.map(each=>each.concat("_flag")).foreach(println)

  }
}
