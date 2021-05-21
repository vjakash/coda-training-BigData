package com.coda.transformation

object Find {

  def main(args: Array[String]): Unit = {
    val list=List("India","China","Pakistan","Nepal","Bangladesh","Indonesia")
    list.find(each=>each.startsWith("I")).foreach(println)
  }
}
