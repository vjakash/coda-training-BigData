package com.coda.transformation

object Count {
  def main(args: Array[String]): Unit = {
    val list=List("India","China","Pakistan","Nepal","Bangladesh","Indonesia")
    val count=list.count(each=>each.startsWith("I"))
    println(count)
  }
}
